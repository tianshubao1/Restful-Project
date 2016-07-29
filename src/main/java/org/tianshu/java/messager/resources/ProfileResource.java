package org.tianshu.java.messager.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tianshu.java.messager.model.Profile;
import org.tianshu.java.messager.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProfileResource {
	ProfileService ps = new ProfileService();
	
	@GET
	public List<Profile> getProfile(){
		return ps.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile pf){
		return ps.addProfile(pf);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName")String profileName, Profile pf){
		pf.setProfileName(profileName);
		return ps.updateProfile(pf);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile removeProfile(@PathParam("profileName")String profileName){
		return ps.removeProfile(profileName);
	}	
	
	@GET
	@Path("/{profileName}")
	public Profile getMessage(@PathParam("profileName")String profileName){
		return ps.getProfile(profileName);
	}
}
