package code.flatura.gramotagen.web;

import code.flatura.gramotagen.model.Dto.DiplomaDto;
import code.flatura.gramotagen.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller("/")
public class DiplomaWebView {
    private DiplomaService diplomaService;

    @Autowired
    public DiplomaWebView(DiplomaService diplomaService) {
        this.diplomaService = diplomaService;
    }

    // Only for admins
    // TODO Add security access only for admins
    // TODO Add pagination
    @GetMapping("/all")
    public ModelAndView getAll(Map<String, Object> model) {
        List<DiplomaDto> result = diplomaService.getAll();
        model.put("diploma_list", result);
        return new ModelAndView("home");
    }

    @GetMapping("/")
    public String getByPersonalInfoForm(Map<String, Object> model) {
        return "search_form.html";
    }


    @PostMapping("/")
    public ModelAndView getByPersonalInfoSubmit(@RequestParam(name = "name") String name,
                                          @RequestParam(name = "middlename") String middleName,
                                          @RequestParam(name = "surname") String surName,
                                          @RequestParam(name = "birthdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
                                                Map<String, Object> model) {
        List<DiplomaDto> result = diplomaService.findByPersonalInfo(name, middleName, surName, birthDate);
        if (result.isEmpty()) {return new ModelAndView("search_form");}
        else model.put("diploma_list", result);
        model.put("name", name);
        model.put("middle_name", middleName);
        return new ModelAndView("search_result", model);
    }
}
