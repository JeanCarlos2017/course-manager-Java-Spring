package com.coursemanager.domain.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.coursemanager.domain.model.CursoEntidade;
import com.coursemanager.domain.model.MatriculaEntidade;
import com.coursemanager.domain.model.UsuarioEntidade;

public class UtilsEntidadeToDTO {
	public static List<MatriculaDTO> matriculaEntidadeToDTO(List<MatriculaEntidade> matriculaEntidadeList){
		List<MatriculaDTO> listaMatriculaDTO= new ArrayList<MatriculaDTO>();
		for(MatriculaEntidade matriculaEntidade: matriculaEntidadeList) {
			listaMatriculaDTO.add(new MatriculaDTO(matriculaEntidade));
		}
		return listaMatriculaDTO;
	}
	
	public static List<CursoDTO> getCursoDTODeMatriculaEntidade(Collection<MatriculaEntidade> matriculaEntidadeList){
		return matriculaEntidadeList.stream()
				.map( (curso) -> new CursoDTO(curso.getCurso()))
				.collect(Collectors.toList());
	}
	
	public static List<UsuarioDTO> usuarioEntidadeToDTO(Collection<UsuarioEntidade> usuarioEntidadeList){
		return usuarioEntidadeList.stream()
				.map( (usuario) -> new UsuarioDTO(usuario))
				.collect(Collectors.toList());
	}
	
	public static List<CursoDTO> cursoEntidadeToDTO(Collection<CursoEntidade> cursoEntidadeList){
		return cursoEntidadeList.stream()
				.map( (curso) -> new CursoDTO(curso))
				.collect(Collectors.toList());
	}
	
	public static List<UsuarioDTO> getUsuarioDTODeMatriculaEntidade(Collection<MatriculaEntidade> matriculaEntidadeList){
		return matriculaEntidadeList.stream()
				.map( (matricula) -> new UsuarioDTO(matricula.getAluno()))
				.collect(Collectors.toList());
	}
}
