package com.gbInc.actividadDosTDC.controller;

import com.gbInc.actividadDosTDC.service.IdueñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbInc.actividadDosTDC.model.Dueño;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/dueño")
public class dueñoController {

	@Autowired
	IdueñoService dueñoSv;
	
		@PostMapping("/crear")
	public ResponseEntity<Boolean> crearDueño(@RequestBody Dueño d) {

		boolean creado = this.dueñoSv.crearDueño(d);
		
		if (creado) {
			return new ResponseEntity<>(true, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/obtenerTodos")
	public ResponseEntity<List<Dueño>> obtenerDueños() {

		return new ResponseEntity<>(this.dueñoSv.leerDueños(), HttpStatus.OK);

	}

	@PutMapping("/editar")
	public ResponseEntity<Boolean> editarDueño(@RequestBody Dueño d) {

		boolean editado = this.dueñoSv.editarDueño(d);
		if (editado) {
			return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/borrar")
	public ResponseEntity<Boolean> elimiarDueño(@RequestParam Long id) {

		boolean borrado = this.dueñoSv.eliminarDueño(id);

		if (borrado) {
			return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}

	
}
