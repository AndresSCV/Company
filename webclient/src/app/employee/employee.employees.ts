export class Employee{

	public firstName:string;
	public lastName:string;
	public email:string;
	public title:string;
	public dept:string;


	constructor(firstName, lastName, email,title,dept){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.title = title;
		this.dept = dept;
	}
}