package com.gbInc.actividadDosTDC.repository;

import com.gbInc.actividadDosTDC.model.Mascota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImascotaRepository extends JpaRepository<Mascota, Long> {

	
	@Query("SELECT m FROM Mascota m where m.especie LIKE %:especie% AND m.raza LIKE %:raza%")
	public List<Mascota> findByParams(String especie, String raza);
	
	
}
