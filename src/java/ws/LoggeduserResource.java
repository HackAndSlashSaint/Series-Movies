/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import json.JSONObject;

/**
 * REST Web Service
 *
 * @author kojot
 */
@Path("loggeduser")
public class LoggeduserResource {

    @Context
    private UriInfo context;

    @Context 
    private HttpServletRequest request;

    /**
     * Creates a new instance of LoggeduserResource
     */
    public LoggeduserResource() {
    }

    /**
     * Retrieves representation of an instance of ws.LoggeduserResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String loggeduser() {
        HttpSession session = request.getSession();
        JSONObject obj=new JSONObject();
        if(session==null) {
            obj.put("user","none");
            return obj.toString();
        }
        String email=session.getAttribute("user").toString();
        obj.put("user", email);
        return obj.toString();
    }

    
}