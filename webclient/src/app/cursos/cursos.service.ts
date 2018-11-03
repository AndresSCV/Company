import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs'

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class CursosService {

  constructor(private http : HttpClient) { }


  obtenerCursos() {
    return this.http.get('http://localhost:8080/api/curso');
  }


  obtenerCursoPorId(id) {
    return this.http.get('http://localhost:8080/api/curso/'+id);
  }
}
