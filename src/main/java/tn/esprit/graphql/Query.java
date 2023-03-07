package tn.esprit.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import tn.esprit.business.LogementBusiness;
import tn.esprit.business.RendezVousBusiness;
import tn.esprit.entites.Logement;
import tn.esprit.entites.RendezVous;

import java.util.List;

public class Query implements GraphQLRootResolver {
    private final LogementBusiness logementBusiness;
    private final RendezVousBusiness rendezVousBusiness;

    public Query(LogementBusiness logementBusiness, RendezVousBusiness rendezVousBusiness) {
        this.logementBusiness=logementBusiness;
        this.rendezVousBusiness=rendezVousBusiness;
    }



    public List<Logement> getLogements() {return logementBusiness.getLogements();}
}
