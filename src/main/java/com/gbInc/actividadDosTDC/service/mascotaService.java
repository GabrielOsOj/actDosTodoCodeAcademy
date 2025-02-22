package com.gbInc.actividadDosTDC.service;

import com.gbInc.actividadDosTDC.model.Mascota;
import com.gbInc.actividadDosTDC.repository.ImascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mascotaService implements ImascotaService {

	@Autowired
	ImascotaRepository mascotaRepo;

	@Override
	public boolean crearMascota(Mascota mascota) {

		this.mascotaRepo.save(mascota);
		return true;
	}

	@Override
	public List<Mascota> leerMascotas() {

		return this.mascotaRepo.findAll();

	}

	@Override
	public boolean actualizarMascota(Mascota mascota) {

		if (this.mascotaRepo.existsById(mascota.getIdMascota())) {

			this.mascotaRepo.save(mascota);
			return true;
			
		}
		return false;
	}

	@Override
	public boolean eliminarMascota(Long idMascota) {

		if(this.mascotaRepo.existsById(idMascota)){
			
			this.mascotaRepo.deleteById(idMascota);
			return true;
		}
		
		return false;
	}

}
