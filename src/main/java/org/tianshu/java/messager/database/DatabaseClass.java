package org.tianshu.java.messager.database;

import java.util.HashMap;
import java.util.Map;

import org.tianshu.java.messager.model.Message;
import org.tianshu.java.messager.model.Profile;

public class DatabaseClass {
	private static Map<Long, Message> mgs = new HashMap();
	private static Map<String, Profile> prfls = new HashMap();
	
	public static Map<Long, Message> getMessage(){
		return mgs;
	}
	public static Map<String, Profile> getProfile(){
		return prfls;
	}
	
}
