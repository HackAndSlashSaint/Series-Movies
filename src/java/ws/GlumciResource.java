/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.DB;
import db.Glumac;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import json.JSONArray;
import json.JSONObject;

/**
 * REST Web Service
 *
 * @author kojot
 */
@Path("glumci")
public class GlumciResource {

    @Context
    private UriInfo context;

    @Context
    private HttpServletRequest request;

    /**
     * Creates a new instance of GlumciResource
     */
    public GlumciResource() {
    }

    /**
     * Retrieves representation of an instance of ws.GlumciResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        
        HttpSession session = request.getSession();
        if(session==null || session.getAttribute("user")==null) return "ERR";
        
         List<Glumac> res=DB.query("SELECT g FROM Glumac g");
            JSONArray a = new JSONArray();
            for(Glumac g:res) {
                JSONObject obj = new JSONObject();
                Date t = g.getGluGodiste();
                LocalDateTime dt= LocalDateTime.ofInstant(t.toInstant(), ZoneId.systemDefault());
                String vreme=DateTimeFormatter.ISO_LOCAL_DATE.format(dt);
                obj.put("ime", g.getGluIme());
                obj.put("prezime", g.getGluPrezime());
                obj.put("godiste", vreme);
                obj.put("drzava", g.getGluDrzava());
                
                a.put(obj);
            }
           return a.toString();
    }


    /**
     * PUT method for updating or creating an instance of GlumciResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}