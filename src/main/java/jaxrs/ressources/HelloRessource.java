package jaxrs.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/greetings")
public class HelloRessource {

    @GET
    public String sayHello(){
        return "Hello from JAX-RS";
    }

    @GET
    @Produces
    public String sayHelloTo(String nom,String prenom){
        return "hello from JAX-RS"+" "+nom+" "+prenom;
    }
}
