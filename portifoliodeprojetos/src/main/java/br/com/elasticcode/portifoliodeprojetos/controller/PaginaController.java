package br.com.elasticcode.portifoliodeprojetos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class PaginaController {

    @GetMapping("/pagina")
    public String pagina (Model model){
        model.addAttribute("now", new Date());
        return  "pagina";
    }
}
