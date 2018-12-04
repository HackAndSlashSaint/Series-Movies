/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Kojot
 */
@javax.ws.rs.ApplicationPath("app")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ws.GlumciResource.class);
        resources.add(ws.KomentarResource.class);
        resources.add(ws.KorisnikResource.class);
        resources.add(ws.LoggeduserResource.class);
        resources.add(ws.LoginResource.class);
        resources.add(ws.OdjavaResource.class);
        resources.add(ws.TrailerResource.class);
        resources.add(ws.VideoResource.class);
    }
    
}
