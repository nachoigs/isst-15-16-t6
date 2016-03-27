package es.upm.dit.isst.tfg.dao;

import es.upm.dit.isst.tfg.model.Tfg;

public interface TFGDAO {
	public void insertData(String autor, String titulo, String resumen, String tutor, String secretario, String fichero, int estado);
	
	public Tfg getTfg(String autor);
	
	public Tfg[] getAllTfg();
	
	public Tfg[] getByTutor(String tutor);
	
	public Tfg[] getBySecretario(String secretario);
	
	public Tfg[] getByEstado(int estado);
	
	public void update(Tfg tfg);
	
	public void delete(Tfg tfg);



}
