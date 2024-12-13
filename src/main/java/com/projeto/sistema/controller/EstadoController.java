package com.projeto.sistema.controller;

import com.projeto.sistema.models.Estado;
import com.projeto.sistema.repositorys.EstadoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@NoArgsConstructor
@AllArgsConstructor
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping("/cadastro")//cadastrarEstado
    public ModelAndView cadastrar(Estado estado) {
        ModelAndView mv = new ModelAndView("administrativo/estados/cadastro");
        mv.addObject("estado", estado);

        return mv;
    }

    @PostMapping("/salvar")//salvarEstado
    public ModelAndView salvar(Estado estado, BindingResult result) {
        if (result.hasErrors()) {
            return cadastrar(estado);
        }

        estadoRepository.saveAndFlush(estado);
        return cadastrar(new Estado());
    }




}
