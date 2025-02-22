package com.gbInc.actividadDosTDC.service;

import com.gbInc.actividadDosTDC.model.Mascota;
import java.util.List;

public interface ImascotaService {
	
	public boolean crearMascota(Mascota mascota);
	public List<Mascota> leerMascotas();
	public boolean actualizarMascota(Mascota mascota);
	public boolean eliminarMascota(Long idMascota);
	
}
