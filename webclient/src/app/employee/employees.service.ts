import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs'

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class EmployeeService {

  constructor(private http : HttpClient) { }


  public obtenerEmployee() : any{
    return this.http.get(`http://localhost:8080/api/employee`);
  }


  obtenerEmployeePorLastName(lastName) {
    return this.http.get('http://localhost:8080/api/employee/lastName/'+lastName);
  }
}
