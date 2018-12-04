/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.DB;
import db.Korisnik;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import json.JSONObject;

/**
 * REST Web Service
 *
 * @author kojot
 */
@Path("login")
public class LoginResource {

    @Context
    private UriInfo context;

    @Context 
    private HttpServletRequest request;
    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of ws.LoginResource
     * @return an instance of java.lang.String
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(String content) {
        JSONObject user=new JSONObject(content);
        String email=user.getString("email");
        String pass=user.getString("pass");
        List<Korisnik> korisnik = DB.query("SELECT k FROM Korisnik k WHERE k.korEmail=?1 and k.korSifra=?2", email, pass);
           if(korisnik.size()>0){
            request.getSession(true).setAttribute("user", email);
              return("OK");
        }
            
       return ("ERR");
    }

    /**
     * PUT method for updating or creating an instance of LoginResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}