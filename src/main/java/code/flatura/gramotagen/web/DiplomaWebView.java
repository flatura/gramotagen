package code.flatura.gramotagen.web;

import code.flatura.gramotagen.model.Dto.DiplomaDto;
import code.flatura.gramotagen.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller("/")
public class DiplomaWebView {
    private DiplomaService diplomaService;

    @Autowired
    public DiplomaWebView(DiplomaService diplomaService) {
        this.diplomaService = diplomaService;
    }

    @GetMapping("/")
    public ModelAndView consumeStatistics(Map<String, Object> model) {
    //public String consumeStatistics(Map<String, Object> model) {
        List<DiplomaDto> result = diplomaService.getAll();
        model.put("diploma_list", result);
        for (DiplomaDto d : result)
            System.out.println(d);
        return new ModelAndView("home");
        //return "home.html";
    }
}
