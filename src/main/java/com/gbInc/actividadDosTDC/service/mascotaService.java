package com.gbInc.actividadDosTDC.service;

import com.gbInc.actividadDosTDC.dto.DTOdueñoMascota;
import com.gbInc.actividadDosTDC.model.Mascota;
import com.gbInc.actividadDosTDC.model.Dueño;

import com.gbInc.actividadDosTDC.repository.IdueñoRepository;
import com.gbInc.actividadDosTDC.repository.ImascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mascotaService implements ImascotaService {

	@Autowired
	ImascotaRepository mascotaRepo;

	@Autowired
	IdueñoRepository dueñoRepo;

	@Override
	public boolean crearMascota(Mascota mascota) {

		if (this.verificarDueño(mascota.getDueño())) {

			this.mascotaRepo.save(mascota);
			return true;

		}

		return false;
	}

	@Override
	public List<Mascota> leerMascotas() {
		return this.mascotaRepo.findAll();
	}

	@Override
	public boolean actualizarMascota(Mascota mascota) {
			
		if(mascota.getIdMascota() == null){
			System.out.println("Id no puede ser null");
			return false;
		
		}
		
		if (this.mascotaRepo.existsById(mascota.getIdMascota())) {

			this.mascotaRepo.save(mascota);
			return true;

		}
		
		System.out.println("Mascota no existe en db");
		return false;
	}

	@Override
	public boolean eliminarMascota(Long idMascota) {

		if (idMascota != null) {

			this.mascotaRepo.deleteById(idMascota);
			return true;

		}

		return false;
	}

	@Override
	public List<Mascota> buscarPorEspecieYraza(String especie, String raza) {

		return this.mascotaRepo.findByParams(especie, raza);
		
	}

	@Override
	public DTOdueñoMascota obtenerDueñoYmascota(Long id) {
		
		if(id == null){
			return null;
		}
		
		if(!this.mascotaRepo.existsById(id)){
			return null;
		}
		
		Mascota m = this.mascotaRepo.findById(id).get();
		Dueño d = m.getDueño();
		
		DTOdueñoMascota dm = new DTOdueñoMascota();
		dm.setNombreMascota(m.getNombre());
		dm.setEspecie(m.getEspecie());
		dm.setRaza(m.getRaza());
		dm.setNombreDueño(d.getNombre());
		dm.setApellidoDueño(d.getApellido());
		
		return dm;
	}

	/*-------------- Utilidades ---------------*/
	private Boolean verificarDueño(Dueño d) {

		if (d.getIdDueño() != null && this.valoresDueñoNulos(d)) {
			return true;
		}
		else if (d.getIdDueño() == null && !this.valoresDueñoNulos(d)) {
			this.dueñoRepo.save(d);
			return true;
		}

		return false;
	}

	/***
	 * Retorna true si los campos de dueño (menos id) son nulos
	 * @param Dueño d
	 * @return true si los valores son nulos, false si algun valor es distinto a null o 0
	 */
	private boolean valoresDueñoNulos(Dueño d) {

		if (d.getNombre() == null && d.getApellido() == null && d.getCelular() == 0 && d.getDNI() == 0) {

			return true;

		}

		return false;

	}

}
