package com.gbInc.actividadDosTDC.repository;

import com.gbInc.actividadDosTDC.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImascotaRepository extends JpaRepository<Mascota, Long> {

}
