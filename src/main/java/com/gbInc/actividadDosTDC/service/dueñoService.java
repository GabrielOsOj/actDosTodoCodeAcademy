package com.gbInc.actividadDosTDC.service;

import com.gbInc.actividadDosTDC.model.Dueño;
import com.gbInc.actividadDosTDC.repository.IdueñoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dueñoService implements IdueñoService {

	@Autowired
	IdueñoRepository dueñoRepo;

	@Override
	public boolean crearDueño(Dueño dueño) {
		this.dueñoRepo.save(dueño);
		return true;
	}

	@Override
	public List<Dueño> leerDueños() {

		return this.dueñoRepo.findAll();

	}

	@Override
	public boolean editarDueño(Dueño dueño) {

		if (this.dueñoRepo.existsById(dueño.getIdDueño())) {
			this.dueñoRepo.save(dueño);
			return true;
		}
		else {
			return false;
		}

	}

	@Override
	public boolean eliminarDueño(Long id) {

		if (this.dueñoRepo.existsById(id)) {
			this.dueñoRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}

	}

}
