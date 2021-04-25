package com.coursemanager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursemanager.domain.dto.MatriculaDTO;
import com.coursemanager.domain.dto.UtilsDTO;
import com.coursemanager.domain.service.MatriculaService;

@RestController 
@RequestMapping("/usuario/{id_aluno}/matricular")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MatriculaController {
	@Autowired
	private MatriculaService matriculaService;
	
	@PostMapping("/curso/{id_curso}")
	public ResponseEntity<MatriculaDTO> matriculaAluno(@PathVariable long id_aluno	, 
			@PathVariable long id_curso){
		return ResponseEntity.ok( new MatriculaDTO(matriculaService.matriculaAluno(id_aluno, id_curso)) );
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<MatriculaDTO>> listaMatricula(){
		return ResponseEntity.ok( UtilsDTO.matriculaEntidadeToDTO( matriculaService.listaMatricula()) );
	}
	
	
}
