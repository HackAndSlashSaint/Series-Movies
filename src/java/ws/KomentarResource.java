/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.DB;
import db.Komentar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@Path("komentar")
public class KomentarResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of KomentarResource
     */
    public KomentarResource() {
    }

    /**
     * Retrieves representation of an instance of ws.KomentarResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String prikaziKomentar() {
        List<Komentar> komentari = DB.query("SELECT k FROM Komentar k");
      JSONArray a = new JSONArray();
        for(Komentar k: komentari){
            JSONObject obj = new JSONObject();
            Date t = k.getKomDatum();
                LocalDateTime dt= LocalDateTime.ofInstant(t.toInstant(), ZoneId.systemDefault());
                String vreme=DateTimeFormatter.ISO_LOCAL_DATE.format(dt);
            
            obj.put("ime", k.getKorId().getKorIme());
            obj.put("prezime", k.getKorId().getKorPrezime());
            obj.put("email",k.getKorId().getKorEmail());
            obj.put("datum",vreme);
            obj.put("tekst",k.getKomTekst());
            
            a.put(obj);    
        }
        return a.toString();
       
    }


    /**
     * PUT method for updating or creating an instance of KomentarResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
