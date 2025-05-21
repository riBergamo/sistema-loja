package com.projeto.sistema.controller;

import com.projeto.sistema.model.Cliente;
import com.projeto.sistema.repository.CidadeRepository;
import com.projeto.sistema.repository.ClienteRepository;
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
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/cadastrarCliente")//cadastrarCliente
    public ModelAndView cadastrar(Cliente cliente) {
        ModelAndView mv = new ModelAndView("administrativo/clientes/cadastro");

        mv.addObject("cliente", cliente);
        mv.addObject("listarCidade", cidadeRepository.findAll());

        return mv;
    }

    @GetMapping("/listarCliente")//listaCliente
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("administrativo/clientes/lista");
        mv.addObject("listarCliente", clienteRepository.findAll());

        return mv;
    }

    @GetMapping("/editarCliente/{id}")//editarCliente
    public ModelAndView editar(@PathVariable("id") Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cadastrar(cliente.get());
    }

    @PostMapping("/salvarCliente")//salvarCliente
    public ModelAndView salvar(Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return cadastrar(cliente);
        }

        clienteRepository.saveAndFlush(cliente);
        return cadastrar(new Cliente());
    }

    @GetMapping("/removerCliente/{id}")//removerCliente
    public ModelAndView remover(@PathVariable("id") Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        clienteRepository.delete(cliente.get());

        return listar();
    }
}
