package br.unitins.abamanager.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.unitins.abamanager.model.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long>{

	@Query("SELECT a FROM Atividade a JOIN a.paciente u WHERE u.id = :id")
	List<Atividade> findAllByPaciente(@Param("id") Long id, Sort sort);
	
}
