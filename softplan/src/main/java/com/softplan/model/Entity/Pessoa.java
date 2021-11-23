package com.softplan.model.Entity;

import com.softplan.Utils.Validador;
import com.softplan.model.Enum.SexoEnum;
import com.softplan.model.Enum.Util.SexoAttributeConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nome;

    @Convert(converter = SexoAttributeConverter.class)
    @Column
    private SexoEnum sexo;

    @Column
    private String email;

    @Column
    private String dataNascimento;

    @Column
    private String naturalidade;

    @Column
    private String nacionalidade;

    @Column
    private String cpf;

    @Column
    private String horaCadastro;

    @Column
    private String horaAtualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if ((!email.isEmpty() || email != null) && Validador.isValidEmail(email)) {
            this.email = email;
        }
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) throws Exception {
        if (Validador.isBornDateValid(dataNascimento)) {
            throw new Exception("Data de nascimento não pode ser maior que data atual");
        }
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if (Validador.isValidCPF(cpf)) {
            this.cpf = cpf;
        }
    }

    public String getHoraCadastro() {
        return horaCadastro;
    }

    public void setHoraCadastro(String horaCadastro) {
        this.horaCadastro = horaCadastro;
    }

    public String getHoraAtualizacao() {
        return horaAtualizacao;
    }

    public void setHoraAtualizacao(String horaAtualizacao) {
        this.horaAtualizacao = horaAtualizacao;
    }
}