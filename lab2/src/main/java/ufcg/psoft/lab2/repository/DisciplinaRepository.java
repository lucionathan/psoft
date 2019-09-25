package ufcg.psoft.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufcg.psoft.lab2.entities.Disciplina;

import java.io.Serializable;
import java.util.List;

@Repository
public interface DisciplinaRepository<T, ID extends Serializable>
        extends JpaRepository<Disciplina, Long> {

    List<Disciplina> findByOrderByNotaDesc();

    List<Disciplina> findByOrderByLikesDesc();

}
