package br.unitins.abamanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.unitins.abamanager.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	@Query("SELECT p FROM Paciente p JOIN p.user u WHERE u.username = :username")
	List<Paciente> findAllByUsuario(@Param("username") String username);
	
}
