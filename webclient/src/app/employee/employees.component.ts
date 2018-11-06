import { Component } from '@angular/core';
import { Employee } from './employee.employees';
import { EmployeeService } from './employees.service';

@Component({
  selector: 'employee',
  templateUrl: './employee.component.html'
})

export class EmployeeComponent {

  public employeeServicios:  Employee[] = [];
  public employeeServicio: any;
  public lastNameBuscar:number;
  public employeeBusqueda:any;

  constructor(public employeeService: EmployeeService) { }

  ngOnInit(){
    //this.cargarEmployees();
    /*this.cursos = new Array();
    let cursoDefault = new Curso('Programacion Web', 40, 1000000); 
    this.cursos.push(cursoDefault);
    this.estudianteMatricula = new Estudiante('','',false);
    */
  }

  

  public cargarEmployees():void{
    this.employeeServicios = [{firstName:'Andres',lastName:'Calle'}];
    console.log(this.employeeServicios);
     /*try {
      this.employeeService.obtenerEmployee()
        .subscribe(resp => {
          console.log(resp);
          this.employeeServicio = resp
        },
          error => {
            console.log(error, "error");
        })
    } catch (e) {
      console.log(e);
    }*/
  }

  buscarEmployee(){
      try {
        this.employeeServicio.obtenerEmployeePorLastName(this.lastNameBuscar)
          .subscribe(resp => {
            console.log(resp);
            this.employeeBusqueda = resp
          },
            error => {
              console.log(error, "error");
          })
      } catch (e) {
        console.log(e);
      }

  }

}
