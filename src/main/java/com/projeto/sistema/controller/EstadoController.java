package com.projeto.sistema.controller;

import com.projeto.sistema.models.Estado;
import com.projeto.sistema.repositorys.EstadoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("estados")
@NoArgsConstructor
@AllArgsConstructor
public class EstadoController {

    private EstadoRepository estadoRepository;

    @GetMapping("/cadastro")//cadastroEstado
    public ModelAndView cadastrar(Estado estado) {
        ModelAndView mv = new ModelAndView("administrativo/estados/cadastro");
        mv.addObject("estado", estado);

        return mv;
    }


}
