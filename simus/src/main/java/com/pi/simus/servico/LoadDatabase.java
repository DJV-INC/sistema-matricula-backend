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

@Configuration
public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IAlunoRepository alunoRepository;

    @Bean
    CommandLineRunner initDatabase(IAlunoRepository repository) {
        return args -> {
        Aluno aluno1 = new Aluno("54451318823", "03562020", "SP", "São Paulo", "Vila Nhocune", "Rua Doutor João Priore", 102, "teste@gmail.com", "Victor Cardoso Andrade", "580940305");

        Aluno aluno2 = new Aluno("22117985866", "03562020", "SP", "São Paulo", "Vila Nhocune", "Rua Doutor João Priore", 102, "teste@gmail.com", "Victor Cardoso Andrade", "987654321");

        Aluno aluno3 = new Aluno("12345678910", "03562020", "SP", "São Paulo", "Vila Nhocune", "Rua Doutor João Priore", 102, "teste@gmail.com", "Victor Cardoso Andrade", "123456789");

        aluno1.setStatus(true);
        aluno2.setStatus(true);

        repository.saveAll(Arrays.asList(aluno1, aluno2, aluno3));

        logger.info("Loaddatabase -> aluno cadastrado");
        };
    }
}
