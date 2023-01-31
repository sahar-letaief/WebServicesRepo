package jaxrs.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greetings")
public class HelloRessource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHello(){
        return "Hello from JAX-RS";
    }

   @GET
   @Produces(MediaType.TEXT_HTML)
   @Path("{FirstName}/{LastName}")
    public String sayHelloTo(@PathParam(value="FirstName")String nom,@PathParam(value="LastName")String prenom){
        return "hello from JAX-RS"+" "+nom+" "+prenom;
    }
}
