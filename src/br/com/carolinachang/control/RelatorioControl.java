package br.com.carolinachang.control;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import br.com.carolinachang.Relatorio;
import br.com.carolinachang.repository.RelatorioServices;

@ManagedBean
@SessionScoped
public class RelatorioControl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private RelatorioServices relatorioService;
	private Relatorio selectedRelatorio;
	private Part arquivoLayout;
	
	public RelatorioControl(){
		
	}
	
	public List<Relatorio> getRelatorios(){
		return relatorioService.getRelatorios();
	}
	
	public String doCadastrarNovo(){
		selectedRelatorio = new Relatorio();
		return "/novo.faces";
	}
	
	public String doCadastrarNovoSalvar() throws IOException{
		byte[] arquivoByte = new byte[(int) arquivoLayout.getSize()];
		arquivoLayout.getInputStream().read(arquivoByte);
		getSelectedRelatorio().setRelatorio(arquivoByte);
		
		relatorioService.persistRelatorio(getSelectedRelatorio());
		
		return "/index.faces";
	}
	
	public void doExecutarRelatorio(Relatorio rel){
		byte[] arqResultado = relatorioService.executarRelatorio(rel);
	}

	public String doCancelar(){
		return "/index.faces";
	}
	public Relatorio getSelectedRelatorio() {
		return selectedRelatorio;
	}

	public void setSelectedRelatorio(Relatorio selectedRelatorio) {
		this.selectedRelatorio = selectedRelatorio;
	}

	public Part getArquivoLayout() {
		return arquivoLayout;
	}

	public void setArquivoLayout(Part arquivoLayout) {
		this.arquivoLayout = arquivoLayout;
	}

	
}
