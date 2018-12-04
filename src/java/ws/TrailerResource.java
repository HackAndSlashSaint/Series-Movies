/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.DB;
import db.Trailer;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import json.JSONArray;
import json.JSONObject;

/**
 * REST Web Service
 *
 * @author Kojot
 */
@Path("trailer")
public class TrailerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TrailerResource
     */
    public TrailerResource() {
    }

    /**
     * Retrieves representation of an instance of ws.TrailerResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
       List<Trailer> res=DB.query("SELECT t FROM Trailer t");
            JSONArray a = new JSONArray();
            for(Trailer t:res) {
                JSONObject obj = new JSONObject();
                
                Date c = t.getTraDatum();
                LocalDateTime dt= LocalDateTime.ofInstant(c.toInstant(), ZoneId.systemDefault());
                String vreme=DateTimeFormatter.ISO_LOCAL_DATE.format(dt);
                
                obj.put("id", t.getTraId());
                obj.put("ime", t.getTraIme());
                obj.put("datum", vreme);
                
                a.put(obj);
            }
           return a.toString();
    }
    /**
     * PUT method for updating or creating an instance of TrailerResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
