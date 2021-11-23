package com.softplan.model.service;

import com.softplan.model.Entity.Pessoa;
import org.springframework.stereotype.Service;

@Service
public interface CadastroServico {

    public Pessoa savePessoa(Pessoa student);

}
