package tn.esprit.business;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.entites.Logement;
import tn.esprit.entites.Logement.Type;;import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class LogementBusiness {
	
	private List<Logement> logements;

	
	public LogementBusiness() {
		logements=new ArrayList<Logement>();
		logements.add(new Logement(1,"27, Rue des roses", "El ghazela","Ariana",Type.Studio,"cuisine equipee",300f));
		logements.add(new Logement(5,"58, Rue des roses", "El ghazela","Ariana",Type.EtageVilla,"cuisine equipee",450f));
		logements.add(new Logement(2,"201, R�sidence Omrane4", "Riadh El Andalous","Ariana",Type.Appartement,"chauffage central, ascenseur, climatisation",700f));
		logements.add(new Logement(3,"540, R�sidence Les Tulipes", "El Aouina","Ariana",Type.Appartement,"S+2, chauffage central, ascenseur, climatisation",500f));
		logements.add(new Logement(4,"78, Rue des Oranges", "Bardo","Tunis",Type.EtageVilla,"chauffage central, ascenseur, climatisation",400f));
	}

	public List<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/log/{reference}")
	public Logement getLogementsByReference(@PathParam(value="reference") int reference){
		
		for (Logement l:logements){
			if(l.getReference()==reference)
				return l;
		}
		return null;
	}

	//ou bien avec le format xml
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/log/{reference}")
	public Response getLogementsByReferenceXML(@PathParam(value="reference") int reference){

		for (Logement l:logements){
			if(l.getReference()==reference)
				return Response.status(Response.Status.FOUND).entity(l).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/log/{deleg}")
	public List<Logement> getLogementsByDeleguation(@PathParam(value="deleg") String deleguation){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getDeleguation().equals(deleguation))
				liste.add(l);
		}
		return liste;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/log/{gov}")
	public List<Logement> getLogementsByGouvernorat(@PathParam(value="gov") String gouvernorat){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getGouvernorat().equals(gouvernorat))
				liste.add(l);
		}
		return liste;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/log/{type}")
	public List<Logement> getLogementsByType(@PathParam(value="type") Type type){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getType().equals(type))
				liste.add(l);
		}
		return liste;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/log/{price}")
	public List<Logement> getLogementsByPrix(@PathParam(value="price") float prix){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getPrix()<=prix)
				liste.add(l);
		}
		return liste;
	}
	

}
