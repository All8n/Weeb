package service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Alumno;
import model.Curso;

public class FormacionServiceImpl implements FormacionService {
	private static List<Curso> cursos=List.of(new Curso("Java for dummies",50,List.of(
				
				                                    new Alumno("alumno1",25,7) ,
				                                    new Alumno("alumno2",32,2) ,
				                                    new Alumno("alumno3",19,8) 
													)),
									     	  new Curso("Spring",60,List.of(
													
								                    new Alumno("alumno5",18,6.9) ,
								                    new Alumno("alumno4",40,3.2) ,
								                    new Alumno("alumno8",28,6) 
								                    )),
										      new Curso("JavaScript",75,List.of(			
													new Alumno("alumno2",32,7.1),
													new Alumno("alumno4",40,8.3),
													new Alumno("alumno7",33,4)
													))	
				);
		
	//duracion media de todos los cursos
	@Override
	public double duracionMedia() {
		return cursos.stream()
				.collect(Collectors.averagingDouble(c->c.duracion()));
		
		
	}
	
	//lista de cursos con numeros de alumnos inferior a un determinado valor
	@Override
	public List<Curso> cursosInferiorAlumnos(int numAlumnos	){
			return cursos.stream()
					.filter(n->n.matriculas().size()<numAlumnos)//Stream<Curso>
					.toList();		
	}
	
	//edad media del curso de una determinada denominacion
	
	@Override
	public double duracionMediaCursos(String denominacion) {
		return cursos.stream()//Stream<Curso>
				.filter(c->c.denominacion().equals(denominacion))//Stream<Curso>
				.flatMap(n->n.matriculas().stream())//Stream<Alumno>
				.collect(Collectors.averagingDouble(a->a.edad()));//double
		
	}
	//lista de nombres de alumnos
	@Override
	public List<String> nombresAlumnos(){
		return cursos.stream()//Stream<Curso>
				.flatMap(n->n.matriculas().stream())//Stream<Alumno>
				.map(a->a.nombre())//Stream<String>
				.toList();
		
		
		
	}
	
	//nota media de todos los cursos	
	
	@Override
	public double notaMediaCursos() {
		return cursos.stream()//Stream<Curso>
		.flatMap(n->n.matriculas().stream())//Stream<Alumno>
		.collect(Collectors.averagingDouble(a->a.nota()));//double
	
		
		
	}
	
	//lista de alumnos aprobados 
	@Override
	public List<Alumno> aprobados(){
		
		return cursos.stream()//Stream<Curso>
				.flatMap(n->n.matriculas().stream())//Stream<Alumno>
				.filter(n->n.nota()>=5)//Stream<Alumno>
				//.collect(Collectors.toList());//List<Alumno>
				.toList();//igual que el anterior, pero desde java 13
				
}
	
	//(lista de nombres de curso
	@Override
	public List<String> cursos(){
		
		return cursos.stream()//Stream<Curso>
				.map(c->c.denominacion())//Stream<String>
				.toList();
				

	}
	//nota media del curso de una determinada denominacion 	
	@Override
	public double mediaDetCurso(String denominacion) {
		return cursos.stream()
				.filter(c->c.denominacion().equals(denominacion))//Stream<Curso>
				.flatMap(n->n.matriculas().stream())//Stream<Alumno>
				.collect(Collectors.averagingDouble(a->a.nota()));//double
		
	}
	//lista de alumnos de un curso de un determinada denominacion
	@Override
	public List<Alumno> alumnoCurso(String denominacion){
		/*return cursos.stream()
				.filter(n->n.denominacion().equals(denominacion))
				.flatMap(n->n.matriculas().stream())
				.toList(); */
		
		
		return cursos.stream()
				.filter(n->n.denominacion().equals(denominacion))
				.findFirst()
				.get()
				.matriculas();
	}

	}


