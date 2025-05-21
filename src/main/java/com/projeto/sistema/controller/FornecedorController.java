package com.projeto.sistema.controller;

import com.projeto.sistema.model.Fornecedor;
import com.projeto.sistema.repository.CidadeRepository;
import com.projeto.sistema.repository.FornecedorRepository;
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
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/cadastrarFornecedor")//cadastrarFornecedor
    public ModelAndView cadastrar(Fornecedor fornecedor) {
        ModelAndView mv = new ModelAndView("administrativo/fornecedores/cadastro");

        mv.addObject("fornecedor", fornecedor);
        mv.addObject("listarCidade", cidadeRepository.findAll());

        return mv;
    }

    @GetMapping("/listarFornecedor")//listaFornecedor
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("administrativo/fornecedores/lista");
        mv.addObject("listarFornecedor", fornecedorRepository.findAll());

        return mv;
    }

    @GetMapping("/editarFornecedor/{id}")//editarFornecedor
    public ModelAndView editar(@PathVariable("id") Long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);

        return cadastrar(fornecedor.get());
    }

    @PostMapping("/salvarFornecedor")//salvarFornecedor
    public ModelAndView salvar(Fornecedor fornecedor, BindingResult result) {
        if (result.hasErrors()) {
            return cadastrar(fornecedor);
        }

        fornecedorRepository.saveAndFlush(fornecedor);
        return cadastrar(new Fornecedor());
    }

    @GetMapping("/removerFornecedor/{id}")//removerFornecedor
    public ModelAndView remover(@PathVariable("id") Long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        fornecedorRepository.delete(fornecedor.get());

        return listar();
    }
}
