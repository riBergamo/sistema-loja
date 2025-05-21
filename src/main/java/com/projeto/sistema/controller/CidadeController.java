package com.projeto.sistema.controller;

import com.projeto.sistema.model.Cidade;
import com.projeto.sistema.repository.CidadeRepository;
import com.projeto.sistema.repository.EstadoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@NoArgsConstructor
@AllArgsConstructor
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;


    @GetMapping("/cadastrarCidade")//cadastrarCidade
    public ModelAndView cadastrar(Cidade cidade) {
        ModelAndView mv = new ModelAndView("administrativo/cidades/cadastro");
        
        mv.addObject("cidade", cidade);
        mv.addObject("listarEstado", estadoRepository.findAll());

        return mv;
    }

    @GetMapping("/listarCidade")//listaCidade
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("administrativo/cidades/lista");
        mv.addObject("listarCidade", cidadeRepository.findAll());

        return mv;
    }

    @GetMapping("/editarCidade/{id}")//editarCidade
    public ModelAndView editar(@PathVariable("id") Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);

        return cadastrar(cidade.get());
    }

    @PostMapping("/salvarCidade")//salvarCidade
    public ModelAndView salvar(Cidade cidade, BindingResult result) {
        if (result.hasErrors()) {
            return cadastrar(cidade);
        }

        cidadeRepository.saveAndFlush(cidade);
        return cadastrar(new Cidade());
    }

    @GetMapping("/removerCidade/{id}")//removerCidade
    public ModelAndView remover(@PathVariable("id") Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        cidadeRepository.delete(cidade.get());

        return listar();
    }





}
