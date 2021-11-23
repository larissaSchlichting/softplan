package com.softplan.model.service;

import com.softplan.model.Entity.Pessoa;
import com.softplan.repository.PessoaRepository;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

@Service("CadastroServicoImpl")
public class CadastroServicoImpl implements CadastroServico {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public Pessoa savePessoa(Pessoa pessoa) {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        if (pessoaRepository.findPessoaNomeByCPF(pessoa.getCpf()) == null) {
            pessoa.setHoraCadastro(formato.format(data));
        } else {
            pessoa.setHoraAtualizacao(formato.format(data));
        }

        Pessoa pessoaResponse = pessoaRepository.save(pessoa);
        return pessoaResponse;
    }
}
