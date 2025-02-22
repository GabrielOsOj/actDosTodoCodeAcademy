package com.gbInc.actividadDosTDC.repository;

import com.gbInc.actividadDosTDC.model.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdueñoRepository extends JpaRepository<Dueño, Long>
{

}
