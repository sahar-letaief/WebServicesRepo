package tn.esprit.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import tn.esprit.business.LogementBusiness;
import tn.esprit.business.RendezVousBusiness;
import tn.esprit.entites.Logement;
import tn.esprit.entites.RendezVous;

public class Mutation implements GraphQLRootResolver {
    private final LogementBusiness logementBusiness;
    private final RendezVousBusiness rendezVousBusiness;

    public Mutation(LogementBusiness logementBusiness, RendezVousBusiness rendezVousBusiness) {
        this.logementBusiness=logementBusiness;
        this.rendezVousBusiness=rendezVousBusiness;
    }
    public RendezVous createRendezVous(int id, String date, String heure, Logement refLog, String num ){
       RendezVous r=new RendezVous(id,date,heure,refLog,num);
        rendezVousBusiness.addRendezVous(r);
        return  r;
    }

}
