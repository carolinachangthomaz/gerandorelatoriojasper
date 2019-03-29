package br.com.carolinachang.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.carolinachang.Relatorio;

/**
 * Session Bean implementation class RelatorioService
 */
@Stateless
@LocalBean
public class RelatorioRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	@PersistenceContext
	private EntityManager em;
 
	/**
     * Default constructor. 
     */
    public RelatorioRepository() {
        // TODO Auto-generated constructor stub
    }
    
    public Relatorio persistRelatorio(Relatorio rel) {
		em.persist(rel);
		return rel;
	}

	public Relatorio updateRelatorio(Relatorio rel) {
		return em.merge(rel);
	}

	public void deleteRelatorio(Relatorio rel) {
		em.remove(rel);
	}

	public List<Relatorio> getRelatorios() {
		Query qr = em.createQuery("select rel from Relatorio rel");
		return qr.getResultList();
	}

}
