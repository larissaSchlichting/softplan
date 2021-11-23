package com.softplan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.softplan.model.Entity.Pessoa;
import com.softplan.model.service.CadastroServicoImpl;
import java.nio.charset.Charset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static com.softplan.model.Enum.SexoEnum.MASCULINO;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@WebMvcTest(CadastroController.class)
public class CadastroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CadastroServicoImpl cadastroServicoImpl;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Test
    public void cadastrarNovaPessoaComSucesso() throws Exception {
        Pessoa pessoaResult = new Pessoa();
        pessoaResult.setCpf("123.456.789-52");
        pessoaResult.setEmail("email@gmail.com");
        pessoaResult.setDataNascimento("05/12/2010");
        pessoaResult.setNome("Marcos");
        pessoaResult.setNaturalidade("Blumenau");
        pessoaResult.setNacionalidade("Brasileiro");
        pessoaResult.setSexo(MASCULINO);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(pessoaResult);

        org.mockito.Mockito.when(cadastroServicoImpl.savePessoa(pessoaResult)).thenReturn(pessoaResult);
        this.mockMvc.perform(post("/save").content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}