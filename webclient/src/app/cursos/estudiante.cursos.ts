export class Estudiante{

	public nombre:string;
	public apellidos:string;
	public intercambio:boolean;

	constructor(nombre_est, apellidos_est, intercambio_){
		this.nombre = nombre_est;
		this.apellidos = apellidos_est;
		this.intercambio = intercambio_;
	}

}