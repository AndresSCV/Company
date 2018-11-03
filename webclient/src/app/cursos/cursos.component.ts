import { Component } from '@angular/core';
import { Docente } from './docente.cursos';
import { Estudiante } from './estudiante.cursos';
import { Curso } from './curso.cursos';
import { CursosService } from './cursos.service';

@Component({
  selector: 'cursos',
  templateUrl: './cursos.component.html'
})

export class CursosComponent {


  public estudianteMatricula:Estudiante; 
  public cursos:Array<Curso>;
  public cursosServicio:any;
  public idBuscar:number;
  public cursoBusqueda:any;

  constructor(public cursosService: CursosService) { }

  ngOnInit(){
    this.cursos = new Array();
    let cursoDefault = new Curso('Programacion Web', 40, 1000000); 
    this.cursos.push(cursoDefault);
    this.estudianteMatricula = new Estudiante('','',false);
    //this.cargarCursos();
  }

  matricularEstudiante(){
      this.cursos[0].estudiantes.push(this.estudianteMatricula);
  }

  cargarCursos(){
     try {
      this.cursosService.obtenerCursos()
        .subscribe(resp => {
          console.log(resp);
          this.cursosServicio = resp
        },
          error => {
            console.log(error, "error");
        })
    } catch (e) {
      console.log(e);
    }
  }

  buscarCurso(){
      try {
        this.cursosService.obtenerCursoPorId(this.idBuscar)
          .subscribe(resp => {
            console.log(resp);
            this.cursoBusqueda = resp
          },
            error => {
              console.log(error, "error");
          })
      } catch (e) {
        console.log(e);
      }

  }

}
