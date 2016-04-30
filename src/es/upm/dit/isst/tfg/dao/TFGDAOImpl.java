package es.upm.dit.isst.tfg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.tfg.model.TFG;


public class TFGDAOImpl implements TFGDAO {
	
	private static TFGDAOImpl instance;
	
	private TFGDAOImpl(){
		
	}
	
	public static TFGDAOImpl getInstance(){
		if (instance == null)
			instance = new TFGDAOImpl();
		return instance;
	}

	@Override
	public void insertData(String autor, String titulo, String resumen,
			String tutor, String secretario, String fichero, int estado) {
	TFG tfgObject = new TFG(autor, titulo, resumen, tutor, secretario, fichero, estado);
	
	EntityManager em = EMFService.get().createEntityManager();
	
	em.persist(tfgObject);
	
	em.close();
	}

	@Override
	public TFG getTfg(String autor) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT m FROM TFG m WHERE m.autor = :autor");
		q.setParameter("autor", autor);
		TFG retornar = (TFG) q.getSingleResult();
		em.close();
		return retornar;
	}

	@Override
	public List<TFG> getAllTfg() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT m FROM TFG m");
		List<TFG> retornar = q.getResultList();
		em.close();
		return retornar;
	}

	@Override
	public List<TFG> getByTutor(String tutor) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT m FROM TFG m WHERE m.autor = :tutor");
		q.setParameter("tutor", tutor);
		List<TFG> retornar = q.getResultList();
		em.close();
		return retornar;
	}

	@Override
	public List<TFG> getBySecretario(String secretario) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT m FROM TFG m WHERE m.secretario = :secretario");
		q.setParameter("secretario", secretario);
		List<TFG> retornar = q.getResultList();
		em.close();
		return retornar;
	}

	@Override
	public List<TFG> getByEstado(int estado) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT m FROM TFG m WHERE m.estado = :estado");
		q.setParameter("estado", estado);
		List<TFG> retornar = q.getResultList();
		em.close();
		return retornar;
	}

	@Override
	public void update(TFG tfg) {
		EntityManager em = EMFService.get().createEntityManager();
		
		em.merge(tfg);
		
		em.close();

	}

	@Override
	public void delete(TFG tfg) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("SELECT m FROM TFG m WHERE m.autor = :tutor");
		q.setParameter("tutor", tfg.getAutor());
		TFG eliminar = (TFG) q.getSingleResult();
		
		em.remove(eliminar);
		
		em.close();

	}

}
