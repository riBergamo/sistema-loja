package com.projeto.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/administrativo")
    public String acessarMain() {
        return "administrativo/home";//caminho
    }


}
