package ufcg.psoft.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufcg.psoft.lab2.entities.Disciplina;

import java.io.Serializable;

@Repository
public interface DisciplinaRepository<T, ID extends Serializable>
        extends JpaRepository<Disciplina, Long> {
}
