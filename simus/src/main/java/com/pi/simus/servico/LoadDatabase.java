package com.pi.simus.servico;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pi.simus.model.Aluno;
import com.pi.simus.model.IAlunoRepository;

import com.pi.simus.model.Aluno.StatusMatricula;

@Configuration
public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IAlunoRepository alunoRepository;

    @Bean
    CommandLineRunner initDatabase(IAlunoRepository repository) {
        return args -> {
        Aluno aluno1 = new Aluno("12345678910", "580940305", "23/03/2003", "03562020", "SP", "São Paulo", "Vila Nhocune", "Rua Doutor João Priore", 102, "teste@gmail.com","11999615887", "Victor Cardoso Andrade");

        Aluno aluno2 = new Aluno("54451318823", "123456789", "23/03/2003", "03562020", "SP", "São Paulo", "Vila Nhocune", "Rua Doutor João Priore", 102, "test@gmail.com","11987654321", "Victor Cardoso Andrade");

        Aluno aluno3 = new Aluno("10987654321", "987654321", "23/03/2003", "03562020", "SP", "São Paulo", "Vila Nhocune", "Rua Doutor João Priore", 102, "testando@gmail.com","11912345678", "Victor Cardoso Andrade");

        aluno1.setStatusMatricula(StatusMatricula.ATIVA);
        aluno2.setStatusMatricula(StatusMatricula.ATIVA);

        repository.saveAll(Arrays.asList(aluno1, aluno2, aluno3));

        logger.info("Loaddatabase -> aluno cadastrado");
        };
    }
}
