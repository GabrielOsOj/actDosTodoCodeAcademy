package com.gbInc.actividadDosTDC.service;

import com.gbInc.actividadDosTDC.model.Dueño;
import java.util.List;

public interface IdueñoService {
	
	public boolean crearDueño(Dueño dueño);
	public List<Dueño> leerDueños();
	public boolean editarDueño(Dueño dueño);
	public boolean eliminarDueño(Long id);

}
