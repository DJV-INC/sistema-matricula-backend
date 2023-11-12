package com.pi.simus.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;



@Repository
public interface IAlunoRepository extends JpaRepository<Aluno, Long> {
    public Optional<Aluno> findByCpf(String cpf);
    public Optional<Aluno> findByRg(String rg);
    public List<Aluno> findByStatusMatricula(StatusMatricula statusMatricula);
}
