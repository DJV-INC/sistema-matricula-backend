package com.pi.simus.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
import com.pi.simus.model.Aluno.StatusMatricula;



@Repository
public interface IAlunoRepository extends JpaRepository<Aluno, Long> {
    public Optional<Aluno> findByCpf(String cpf);
    public Optional<Aluno> findByRg(String rg);
    public List<Aluno> findByStatusMatricula(StatusMatricula statusMatricula);
    public String deleteByCpf(String cpf);
}
