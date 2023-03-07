package tn.esprit.graphql;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;

import graphql.servlet.SimpleGraphQLServlet;
import tn.esprit.business.LogementBusiness;
import tn.esprit.business.RendezVousBusiness;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQlEndPoint extends SimpleGraphQLServlet {
    public GraphQlEndPoint(){
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        LogementBusiness logementBusiness=new LogementBusiness();
        RendezVousBusiness rendezVousBusiness=new RendezVousBusiness();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(logementBusiness,rendezVousBusiness),new Mutation(logementBusiness,rendezVousBusiness))
                .build()
                .makeExecutableSchema();

    }
}

