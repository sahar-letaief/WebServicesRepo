package jaxrs.ressources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/greetings")
public class HelloRessource {

   /* @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHello(){
        return "Hello from JAX-RS";
    }*/

   @GET
   @Produces(MediaType.TEXT_HTML)
   @Path("{FirstName}/{LastName}")
    public String sayHelloTo(@PathParam(value="FirstName")String nom,@PathParam(value="LastName")String prenom){
        return "hello from JAX-RS"+" "+nom+" "+prenom;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    //@Path("{FirstName}/{LastName}") ce n'est la peine de faire cette ligne à cause de query param
   // @Path("/byQuery")
    public String sayHelloTo2(@QueryParam(value="FirstName") String nom, @QueryParam(value="LastName") String prenom){
        if(nom==null && prenom==null)
            return "Hello from JAX-RS";
        return "hello from JAX-RS 2"+" "+nom+" "+prenom;
    }
}
