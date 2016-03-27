package es.upm.dit.isst.tfg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tfg implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String autor;
	
	private String titulo;
	
	private String resumen;
	
	private String tutor;
	
	private String secretario;
	
	private String fichero;
	
	private int estado;
}
