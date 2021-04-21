package code.flatura.gramotagen.web;

import code.flatura.gramotagen.model.Dto.DiplomaDto;
import code.flatura.gramotagen.service.DiplomaService;
import code.flatura.gramotagen.util.PDFService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller("/")
public class DiplomaWebView {
    private DiplomaService diplomaService;

    @Autowired
    public DiplomaWebView(DiplomaService diplomaService) {
        this.diplomaService = diplomaService;
    }

    // TODO Add security access only for admins
    // TODO Add pagination
    @GetMapping("/all")
    public ModelAndView getAll(Map<String, Object> model) {
        List<DiplomaDto> result = diplomaService.getAll();
        model.put("diploma_list", result);
        return new ModelAndView("home");
    }

    @GetMapping("/")
    public String getByPersonalInfoForm() {
        return "search_form_simple.html";
    }

    // Выдача грамот с проверкой ДР
    @PostMapping("/my")
    public ModelAndView listByPersonalInfoSubmit(@RequestParam(name = "name") String name,
                                                 @RequestParam(name = "middlename") String middleName,
                                                 @RequestParam(name = "surname") String surName,
                                                 @RequestParam(name = "birthdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
                                                 Map<String, Object> model) {
        List<DiplomaDto> result = diplomaService.findByPersonalInfoWithBirthday(name, middleName, surName, birthDate);
        if (result.isEmpty()) {
            return new ModelAndView("search_form");
        } else model.put("diploma_list", result);
        model.put("name", name);
        model.put("middle_name", middleName);
        return new ModelAndView("search_result", model);
    }

    // Без ДР
    @PostMapping("/my-simple")
    public ModelAndView listByPersonalInfoSubmit(@RequestParam(name = "name") String name,
                                                 @RequestParam(name = "middle_name") String middleName,
                                                 @RequestParam(name = "surname") String surName,
                                                 Map<String, Object> model) {
        List<DiplomaDto> result = diplomaService.findByPersonalInfo(name, middleName, surName);
        if (result.isEmpty()) {
            return new ModelAndView("search_form");
        } else model.put("diploma_list", result);
        model.put("name", name);
        model.put("middle_name", middleName);
        return new ModelAndView("search_result", model);
    }

    @GetMapping("/my")
    public void getDiploma(HttpServletResponse response, @RequestParam(name = "name") String name,
                           @RequestParam(name = "surname") String surName,
                           @RequestParam("id") UUID id) {
        DiplomaDto diplomaDto = diplomaService.getById(id);
        if (diplomaDto != null) {
            // Проверяем информацию в нем
            if (diplomaDto.getPersonName().equalsIgnoreCase(name) &&
                    diplomaDto.getPersonSurname().equalsIgnoreCase(surName)) {
                try {
                    PDFService.generate(diplomaDto, response.getOutputStream());
                    response.setContentType("application/pdf");
                    String header = diplomaDto.getType() + " " + diplomaDto.getPersonName() + " " + diplomaDto.getPersonSurname();
                    response.setHeader(header, header);
                    response.flushBuffer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                diplomaService.incrementPrintCounter(id);
            }
        }
    }

    // Форма добавления новой грамоты
    @GetMapping("/add")
    public String addDiplomaForm() {return "add_new_diploma.html";}

    // Добавление грамот в БД с предварительной проверкой кода +79261396438
    @PostMapping("/add")
    public ModelAndView addDiplomaFormSubmit(
                                             @RequestParam(name = "competition_short") String competitionThemeShort,
                                             @RequestParam(name = "competition") String competitionTheme,
                                             @RequestParam(name = "issue_date") String issueDate,
                                             @RequestParam(name = "type") String type,
                                             @RequestParam(name = "discipline") String discipline,
                                             @RequestParam(name = "name") String name,
                                             @RequestParam(name = "middlename") String middleName,
                                             @RequestParam(name = "surname") String surName,
                                             @RequestParam(name = "status") String status,
                                             @RequestParam(name = "pass") String pass,
                                             Map<String, Object> model) {
        if(pass.equals("+79261396438")) {
            diplomaService.addDiploma(competitionThemeShort, competitionTheme, issueDate, type, discipline, name, middleName, surName, status);
        }

        return new ModelAndView("search_form_simple.html");
    }

    @GetMapping("/demo")
    public void getDemoPDF(HttpServletResponse response) {
        Document document = new Document();
        try {
            // Работаем с библиолтекой iText
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("Demo PDF generator", font);
            document.add(chunk);
            document.close();

            // Выводим файл
            response.setContentType("application/pdf");
            response.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        } catch (DocumentException ex) {
            throw new RuntimeException("iText document error");
        }
    }
}
