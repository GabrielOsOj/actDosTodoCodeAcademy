package com.gbInc.actividadDosTDC.service;

import com.gbInc.actividadDosTDC.model.Dueño;
import com.gbInc.actividadDosTDC.repository.IdueñoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class dueñoService implements IdueñoService{

	@Autowired	
	IdueñoRepository dueñoRepo;
	
	@Override
	public boolean crearDueño(Dueño dueño) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public List<Dueño> leerDueños() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean editarDueño(Dueño dueño) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean eliminarDueño(Long id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
