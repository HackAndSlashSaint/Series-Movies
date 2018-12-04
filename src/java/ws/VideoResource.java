/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.DB;
import db.Komentar;
import db.Korisnik;
import db.Video;
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
@Path("video")
public class VideoResource {

    @Context
    private UriInfo context;

    @Context
    private HttpServletRequest request;
    /**
     * Creates a new instance of VideoResource
     */
    public VideoResource() {
    }

    /**
     * Retrieves representation of an instance of ws.VideoResource
     * @return an instance of java.lang.String
     */
   @GET
    @Produces("application/json")
    public String getJson() {
        
        HttpSession session = request.getSession();
        if(session==null || session.getAttribute("user")==null) return "ERR";
        
       List<Video>res = DB.query("SELECT v FROM Video v");
            JSONArray a = new JSONArray();
            for(Video v:res) {
                JSONObject obj = new JSONObject();
                Date t = v.getVidDatum();
                LocalDateTime dt= LocalDateTime.ofInstant(t.toInstant(), ZoneId.systemDefault());
                String vreme=DateTimeFormatter.ISO_LOCAL_DATE.format(dt);
                obj.put("ime", v.getVidIme());
                obj.put("godina", vreme);
                obj.put("izdavac", v.getIzdId().getIzdIme());
                obj.put("opis", v.getVidOpis());
                
                a.put(obj);
            }
           return a.toString();
           
    }

    /**
     * PUT method for updating or creating an instance of VideoResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void upisKomentara(String content) {
        
        HttpSession session = request.getSession();
        if(session!=null && session.getAttribute("user")!=null){
        
        JSONObject komentari = new JSONObject(content);
        String komentar = komentari.getString("tekst");
        Date d = new Date();
        Komentar k = new Komentar();
        k.setKomTekst(komentar);
        k.setKomDatum(d);
        String user = session.getAttribute("user") + "" ;
        List<Korisnik> korisnici = DB.query("SELECT k FROM Korisnik k WHERE k.korEmail=?1",user);
        for(Korisnik p: korisnici)
            k.setKorId(p);
        
        DB.insert(k);
    }
}
}