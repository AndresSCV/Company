import { Component } from '@angular/core';
import { Employee } from './employee.employees';
import { EmployeeService } from './employees.service';

@Component({
  selector: 'employee',
  templateUrl: './employee.component.html'
})

export class EmployeeComponent {

  public employeeServicios:  Employee[] = [];
  public lastNameBuscar:number;
  public employeeBusqueda: Employee[] = [];

  constructor(public employeeService: EmployeeService) { }

  ngOnInit(){
  }

  

  public cargarEmployees():void{
     try {
      this.employeeService.obtenerEmployee()
        .subscribe((resp : Employee[]) => {
          this.employeeServicios = resp
        },
          error => {
            console.log(error, "error");
        })
    } catch (e) {
      console.log(e);
    }
  }

  public buscarEmployee() : void{
      try {
        this.employeeService.obtenerEmployeePorLastName(this.lastNameBuscar)
          .subscribe((resp : Employee[]) => {
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
