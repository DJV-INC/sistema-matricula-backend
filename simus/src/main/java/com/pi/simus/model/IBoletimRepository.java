package com.pi.simus.model;

import org.springframework.stereotype.Repository;
import com.pi.simus.model.Boletim.Conceito;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IBoletimRepository extends JpaRepository<Boletim, Long> {
    public List<Boletim> findByAluno(Aluno aluno);
    public List<Boletim> findBySemestre(String semestre);
    public List<Boletim> findByProfessor(String professor);
    public List<Boletim> findByDisciplina(String disciplina);
    public List<Boletim> findByConceito(Conceito conceito);
}
