package com.gbInc.actividadDosTDC.service;

import com.gbInc.actividadDosTDC.model.Mascota;
import com.gbInc.actividadDosTDC.repository.ImascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class mascotaService implements ImascotaService{

	@Autowired
	ImascotaRepository mascotaRepo;
	
	@Override
	public boolean crearMascota(Mascota mascota) {
		
		return true;
	}

	@Override
	public List<Mascota> leerMascotas() {
	
	}

	@Override
	public boolean actualizarMascota(Mascota mascota) {
	
		return true;
	}

	@Override
	public boolean eliminarMascota(Long idMascota) {
		
		return true;
	}

}
