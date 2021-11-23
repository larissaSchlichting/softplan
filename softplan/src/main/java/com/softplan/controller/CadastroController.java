package com.softplan.controller;

import com.softplan.model.Entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cadastro")
public class CadastroController {

    @Autowired
    private com.softplan.model.service.CadastroServico cadastroService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Pessoa savePessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaResponse = (Pessoa) cadastroService.savePessoa(pessoa);
        return pessoaResponse;
    }
}
