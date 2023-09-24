package com.pi.simus.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface IAlunoRepository extends JpaRepository<Aluno, Long> {
    public Optional<Aluno> findByCpf(String cpf);
    public Optional<Aluno> findByRg(String rg);
    public Optional<Aluno> findByStatus(boolean status);
}
