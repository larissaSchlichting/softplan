package com.softplan.repository;

import com.softplan.model.Entity.Pessoa;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Serializable> {

    List<Pessoa> findByNome(@Param("name") String name);

    @Query("SELECT c.nome FROM Pessoa c where c.cpf = :cpf")
    Pessoa findPessoaNomeByCPF(@Param("cpf") String cpf);

}