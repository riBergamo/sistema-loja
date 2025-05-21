package com.projeto.sistema.controller;

import com.projeto.sistema.model.Estado;
import com.projeto.sistema.repository.EstadoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@NoArgsConstructor
@AllArgsConstructor
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping("/cadastrarEstado")//cadastrarEstado
    public ModelAndView cadastrar(Estado estado) {
        ModelAndView mv = new ModelAndView("administrativo/estados/cadastro");
        mv.addObject("estado", estado);

        return mv;
    }

    @GetMapping("/listarEstado")//listaEstado
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("administrativo/estados/lista");
        mv.addObject("listarEstado", estadoRepository.findAll());

        return mv;
    }

    @GetMapping("/editarEstado/{id}")//editarEstado
    public ModelAndView editar(@PathVariable("id") Long id) {
        Optional<Estado> estado = estadoRepository.findById(id);

        return cadastrar(estado.get());
    }

    @PostMapping("/salvarEstado")//salvarEstado
    public ModelAndView salvar(Estado estado, BindingResult result) {
        if (result.hasErrors()) {
            return cadastrar(estado);
        }

        estadoRepository.saveAndFlush(estado);
        return cadastrar(new Estado());
    }

    @GetMapping("/removerEstado/{id}")//removerEstado
    public ModelAndView remover(@PathVariable("id") Long id) {
        Optional<Estado> estado = estadoRepository.findById(id);
        estadoRepository.delete(estado.get());

        return listar();
    }





}
