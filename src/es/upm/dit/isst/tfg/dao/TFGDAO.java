package es.upm.dit.isst.tfg.dao;

import java.util.List;

import es.upm.dit.isst.tfg.model.TFG;

public interface TFGDAO {
	public void insertData(String autor, String titulo, String resumen, String tutor, String secretario, String fichero, int estado);
	
	public TFG getTfg(String autor);
	
	public List<TFG> getAllTfg();
	
	public List<TFG> getByTutor(String tutor);
	
	public List<TFG> getBySecretario(String secretario);
	
	public List<TFG> getByEstado(int estado);
	
	public void update(TFG tfg);
	
	public void delete(TFG tfg);



}
