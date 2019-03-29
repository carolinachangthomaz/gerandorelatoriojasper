package br.com.carolinachang.repository;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.carolinachang.Relatorio;
import br.com.carolinachang.service.RelatorioRepository;

/**
 * Session Bean implementation class RelatorioRepository
 */
@Stateless
@LocalBean
public class RelatorioServices {
	
	@EJB
	private RelatorioRepository relatorioRepository;

    /**
     * Default constructor. 
     */
    public RelatorioServices() {
        // TODO Auto-generated constructor stub
    }

    public Relatorio persistRelatorio(Relatorio rel) {
    	return relatorioRepository.persistRelatorio(rel);
	}

	public Relatorio updateRelatorio(Relatorio rel) {
		return relatorioRepository.updateRelatorio(rel);
	}

	public void deleteRelatorio(Relatorio rel) {
		relatorioRepository.deleteRelatorio(rel);
	}

	public List<Relatorio> getRelatorios() {
		return relatorioRepository.getRelatorios();
	}
	
	public byte[] executarRelatorio(Relatorio rel){
		
		return null;
	}
}
