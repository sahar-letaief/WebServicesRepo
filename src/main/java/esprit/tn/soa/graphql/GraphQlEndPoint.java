package esprit.tn.soa.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.SchemaParser;
import esprit.tn.soa.repository.StudentRepository;
import graphql.schema.GraphQLSchema;

import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns = "/graphql")
public class GraphQlEndPoint extends SimpleGraphQLServlet {
    public GraphQlEndPoint(){
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        StudentRepository studentRepository=new StudentRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers( new Query(studentRepository))
                .build()
                .makeExecutableSchema();

    }
}
