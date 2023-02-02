package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	//duracion media de todos los cursos
	double duracionMedia();

	//lista de cursos con numeros de alumnos inferior a un determinado valor
	List<Curso> cursosInferiorAlumnos(int numAlumnos);

	double duracionMediaCursos(String denominacion);

	//lista de nombres de alumnos
	List<String> nombresAlumnos();

	double notaMediaCursos();

	//lista de alumnos aprobados 
	List<Alumno> aprobados();

	//(lista de nombres de curso
	List<String> cursos();

	//nota media del curso de una determinada denominacion 	
	double mediaDetCurso(String denominacion);

	//lista de alumnos de un curso de un determinada denominacion
	List<Alumno> alumnoCurso(String denominacion);

}