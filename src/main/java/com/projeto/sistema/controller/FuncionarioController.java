package com.projeto.sistema.controller;

import com.projeto.sistema.model.Funcionario;
import com.projeto.sistema.repository.FuncionarioRepository;
import com.projeto.sistema.repository.CidadeRepository;
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
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private CidadeRepository cidadeRepository;


    @GetMapping("/cadastrarFuncionario")//cadastrarFuncionario
    public ModelAndView cadastrar(Funcionario funcionario) {
        ModelAndView mv = new ModelAndView("administrativo/funcionarios/cadastro");

        mv.addObject("funcionario", funcionario);
        mv.addObject("listarCidade", cidadeRepository.findAll());

        return mv;
    }

    @GetMapping("/listarFuncionario")//listaFuncionario
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("administrativo/funcionarios/lista");
        mv.addObject("listarFuncionario", funcionarioRepository.findAll());

        return mv;
    }

    @GetMapping("/editarFuncionario/{id}")//editarFuncionario
    public ModelAndView editar(@PathVariable("id") Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

        return cadastrar(funcionario.get());
    }

    @PostMapping("/salvarFuncionario")//salvarFuncionario
    public ModelAndView salvar(Funcionario funcionario, BindingResult result) {
        if (result.hasErrors()) {
            return cadastrar(funcionario);
        }

        funcionarioRepository.saveAndFlush(funcionario);
        return cadastrar(new Funcionario());
    }

    @GetMapping("/removerFuncionario/{id}")//removerFuncionario
    public ModelAndView remover(@PathVariable("id") Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        funcionarioRepository.delete(funcionario.get());

        return listar();
    }
}
