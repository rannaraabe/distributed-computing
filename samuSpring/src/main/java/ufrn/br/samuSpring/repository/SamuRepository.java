package ufrn.br.samuSpring.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufrn.br.samuSpring.model.Ambulancia;

@Repository
public interface SamuRepository extends JpaRepository<Ambulancia, Long> {
	
	// "SELECT * FROM ambulancia WHERE id = ?":
//	Optional<Ambulancia> encontrarAmbulancia(Long id);
	
	/* sudo -u postgres psql
	 * \l
	 * create database samu;
	 * grant all privileges on database "samu" to postgres;
	 * \c samu
	 * \d
	 * \d ambulancia
	 * select * from ambulancia;
	 */
	
}
