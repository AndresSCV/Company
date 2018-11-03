import { Docente } from './docente.cursos';
import { Estudiante } from './estudiante.cursos';

export class Curso{

	public nombre:string;
	public duracion_horas:number;
	public precio:number;
	public docente:Docente;
	public estudiantes:Array<Estudiante>;

	constructor(nombre_, duracion_horas_, precio_){
		this.nombre = nombre_;
		this.duracion_horas = duracion_horas_;
		this.precio = precio_;
		this.docente = this.cargarDocente();
		this.estudiantes = this.cargarEstudiantes();
	}

	cargarEstudiantes(){
	    let lista_estudiantes = new Array<Estudiante>();
	    lista_estudiantes.push(new Estudiante('Maria', 'Calle', false));
	    lista_estudiantes.push(new Estudiante('Lucas', 'Ramirez', false));
	    lista_estudiantes.push(new Estudiante('Nicolas', 'Moreno', false));
	    lista_estudiantes.push(new Estudiante('Sandra', 'Fonseca', true));
	    lista_estudiantes.push(new Estudiante('Mario', 'Casas', false));
	    return lista_estudiantes;
  	}


  	cargarDocente(){
  		let docente = new Docente('Julio', 'Rodriguez', 420000, true);
  		return docente;
	}
	


}