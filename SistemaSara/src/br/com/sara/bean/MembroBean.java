package br.com.sara.bean;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.sara.entidade.Constantes;
import br.com.sara.entidade.Membro;
import br.com.sara.dao.ClassDao;
import br.com.sara.dao.HibernateUtil;

@ManagedBean(name="beanmembro")
@SessionScoped
public class MembroBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Membro membro = new Membro();
	private List<Membro> membroList;
	private ClassDao<Membro> dao;		
	private int tipoConsulta;
	private String campo;
	private String pesMembro;
	private Constantes constantes = new Constantes();
	private String discipulador;
	
	public MembroBean() {
		dao = new ClassDao<Membro>(Membro.class);			

	}
	
	public void onDateSelect(SelectEvent event) {
	     FacesContext facesContext = FacesContext.getCurrentInstance();
	     SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	public String editar()
	{
		return "cadMembro?faces-redirect=true";
	}

	public int getTipoConsulta() {
		return tipoConsulta;
	}



	public void setTipoConsulta(int tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}


	public String getCampo() {
		return campo;
	}



	public void setCampo(String campo) {
		this.campo = campo;
	}


	public String getPesCli() {
		return pesMembro;
	}


	public void setPesMembro(String pesMembro) {
		this.pesMembro = pesMembro;
	}



	public Membro getMembro() {
		return membro;
	}


	public void setMembro(Membro membro) {
		this.membro = membro;
	}


	public List<Membro> getMembroList() {
			return membroList;
		
	}


	public void setMembroList(List<Membro> membroList) {
		this.membroList = membroList;
	}


	public String limpar(){
		membro = new Membro();
		return null;
	}
	
	public String selecionado(){
		System.out.println("<<<<<<<<<<<<<<<<<<<"+membro.getNome()+">>>>>>>>>>>>>.");

		return null;
	}	

	public String novo()
	{
		this.membro = new Membro();
		return "cadMembro?faces-redirect=true";
	}

	public String salvar(){
	

		FacesContext fc = FacesContext.getCurrentInstance();
	
		this.membro.setDiscipulador(discipulador);
		
		if(membro.getObjref()!=0){
			try{
				dao.update(membro);
				novo();
				fc.addMessage("cadMembro", new FacesMessage("Membro Salvo com sucesso!!!"));
				membro = new Membro();
				membroList = dao.findAll();
			}catch(Exception e){
				e.printStackTrace();
				FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", e.getMessage());
				fc.addMessage(null, ms);
			}
			
			return null;
			
		}
		
		try{
			dao.create(membro);
			novo();
			fc.addMessage("cadMembro", new FacesMessage("Membro Salvo com sucesso!!!"));
			membro = new Membro();
			membroList = dao.findAll();
		}catch(Exception e){
			e.printStackTrace();
			FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", e.getMessage());
			fc.addMessage(null, ms);
		}
		
		return null;
	}
	
	public String delete(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			
			HibernateUtil.getSessionFactory().getCurrentSession().evict(membro);
			
			membro = dao.findByCod(membro.getObjref());	
			dao.delete(membro);
			fc.addMessage("fmMembro", new FacesMessage("Cliente Deletado com sucesso!!!"));
		}catch(Exception e){
			e.printStackTrace();
			FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", e.getMessage());
			fc.addMessage(null, ms);
		}
		findMembro();
		return null;
	}	



	@SuppressWarnings("unchecked")
	public String findMembro(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			if(campo =="objref")
			{ 
				Integer pesMembro1 =   Integer.parseInt(pesMembro); 
				membroList  = (ArrayList<Membro>)	dao.consultaByTipoCriteria(0, null, tipoConsulta, campo, pesMembro1).list();
				return null;
			}		
			membroList  = 	(ArrayList<Membro>) dao.consultaByTipoCriteria(0, null, tipoConsulta, campo, pesMembro).list();
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", e.getMessage());
			fc.addMessage(null, ms);
			}
		return null;
	

	}

	public ClassDao<Membro> getDao() {
		return dao;
	}

	public void setDao(ClassDao<Membro> dao) {
		this.dao = dao;
	}

	public Constantes getConstantes() {
		return constantes;
	}

	public void setConstantes(Constantes constantes) {
		this.constantes = constantes;
	}

	public String getDiscipulador() {
		return discipulador;
	}

	public void setDiscipulador(String discipulador) {
		this.discipulador = discipulador;
	}

	public String getPesMembro() {
		return pesMembro;
	}



}
