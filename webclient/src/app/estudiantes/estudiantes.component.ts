import { Component } from '@angular/core';

@Component({
  selector: 'estudiantes',
  templateUrl: './estudiantes.component.html'
})

export class EstudiantesComponent {
  public nombre:string;
  public codigo:number;
  public asignaturasMatriculadas:Array<string>;
  public codigosAsignaturasMatriculadas:Array<any>;

  constructor(){
  	this.nombre = 'David Perez';
  	this.codigo = 1245;
  	this.asignaturasMatriculadas = ['Programacion Web', 'Big Data'];
  	this.codigosAsignaturasMatriculadas  = [789456, 'PW12368'];
  	this.mostrarNombre();
  }

  mostrarNombre(){
  	//alert(this.nombre);
  }
}
