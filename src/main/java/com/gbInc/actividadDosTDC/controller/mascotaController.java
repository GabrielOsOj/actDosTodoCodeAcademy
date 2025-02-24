package com.gbInc.actividadDosTDC.controller;

import com.gbInc.actividadDosTDC.service.ImascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbInc.actividadDosTDC.model.Mascota;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/mascota")
public class mascotaController {

	@Autowired
	ImascotaService mascotaSv;

	@PostMapping("/crear")
	public ResponseEntity<Boolean> crearMascota(@RequestBody Mascota m) {

		if (this.mascotaSv.crearMascota(m)) {

			return new ResponseEntity<>(true, HttpStatus.CREATED);

		}
		else {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/obtenerTodas")
	public ResponseEntity<List<Mascota>> obtenerMascotas() {

		return new ResponseEntity<>(this.mascotaSv.leerMascotas(), HttpStatus.OK);

	}

	@PutMapping("/editar")
	public ResponseEntity<Boolean> editarMascota(@RequestBody Mascota m) {

		boolean editada = this.mascotaSv.actualizarMascota(m);
		if (editada) {
			return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
		}
		else {

			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

		}

	}

	@DeleteMapping("/borrar")
	public ResponseEntity<Boolean> elimiarMascota(@RequestParam Long id) {

		boolean borrada = this.mascotaSv.eliminarMascota(id);

		if (borrada) {
			return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping("/buscarRazaYespecie")
	public ResponseEntity<List<Mascota>> buscarPorRazaYEspecie(
			@RequestParam String especie,
			@RequestParam String raza
	){
	
		List<Mascota> mascotas = this.mascotaSv.buscarPorEspecieYraza(especie, raza);
		
		if(mascotas.isEmpty()){
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<>(mascotas,HttpStatus.OK);
		}
		
	}
	
}