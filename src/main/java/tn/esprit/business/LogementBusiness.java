package tn.esprit.business;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.entites.Logement;
import tn.esprit.entites.Logement.Type;;import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/logements")
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
	public Response getLogementsByReference(@QueryParam(value="reference") int reference){
		
		for (Logement l:logements){
			if(l.getReference()==reference)
				return Response.status(Status.FOUND).entity(l).build();
		}
		return  Response.status(Status.FOUND).entity("not found").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public  Response  displaylogements() {

		if(logements.size()!=0)
			return Response.status(Status.FOUND).entity(logements).build();
		else
			return Response.status(Status.NOT_FOUND).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLogementsByDeleguation(@QueryParam(value="delegation") String deleguation){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getDeleguation().equals(deleguation))
				liste.add(l);
			return Response.status(Status.FOUND).entity(l).build();
		}
		return Response.status(Status.ACCEPTED).entity(logements).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLogementsByGouvernorat(@QueryParam(value="gouvernorat") String gouvernorat){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getGouvernorat().equals(gouvernorat))
				liste.add(l);
			return Response.status(Status.FOUND).entity(l).build();
		}
		return Response.status(Status.ACCEPTED).entity(logements).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLogementsByType(@QueryParam(value="type") Type type){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getType().equals(type))
				liste.add(l);
			return Response.status(Status.FOUND).entity(l).build();
		}
		return Response.status(Status.ACCEPTED).entity(logements).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLogementsByPrix(@QueryParam(value="prix") float prix){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getPrix()<=prix)
				liste.add(l);
			return Response.status(Status.FOUND).entity(logements).build();
		}
		return Response.status(Status.ACCEPTED).entity(logements).build();
	}
	

}
