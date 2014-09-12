package org.mongodb.model;

public class User {
	private String nombre;
	private String mail;
	private String password;
	private int dni;
	
	public User() {
	}
	
	public User(String nombre, String mail, String password, int dni) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.password = password;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

}
