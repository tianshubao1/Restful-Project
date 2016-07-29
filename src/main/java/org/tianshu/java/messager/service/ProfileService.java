package org.tianshu.java.messager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.tianshu.java.messager.database.DatabaseClass;
import org.tianshu.java.messager.model.Profile;

public class ProfileService {
	private Map<String, Profile> prfls = DatabaseClass.getProfile();
	
	public ProfileService(){
		Profile m1 = new Profile(1L, "pro1", "tianshu","bao");
		Profile m2 = new Profile(2L, "pro2", "dada","pig");

		prfls.put("pro1",m1);
		prfls.put("pro2",m2);
	}
	
	public List<Profile> getAllProfiles(){
		List<Profile> al = new ArrayList<Profile>(prfls.values());
		return al;
	}
	
	public Profile getProfile(String profileName){
		return prfls.get(profileName);
	}
	
	public Profile addProfile(Profile pf){
		pf.setId(prfls.size() + 1);
		prfls.put(pf.getProfileName(), pf);
		return pf;
	}

	public Profile updateProfile(Profile pf){
		if(pf.getId() <= 0)
			return null;
		prfls.put(pf.getProfileName(), pf);
		return pf;
	}
	
	public Profile removeProfile(String profileName){
		return prfls.remove(profileName);
	}
}
