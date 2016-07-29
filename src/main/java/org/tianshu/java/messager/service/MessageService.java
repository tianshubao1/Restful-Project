package org.tianshu.java.messager.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.ws.rs.QueryParam;

import org.tianshu.java.messager.database.DatabaseClass;
import org.tianshu.java.messager.exception.DataNotFoundException;
import org.tianshu.java.messager.model.Message;

//@WebService
public class MessageService {
	private Map<Long, Message> mgs = DatabaseClass.getMessage();
	
	public MessageService(){
		Message m1 = new Message(1L, "hello world!!", "tianshu");
		Message m2 = new Message(2L, "hello jersey!!", "tianshu");

		mgs.put(1L,m1);
		mgs.put(2L,m2);
	}
	
	public List<Message> getAllMessages(){
		List<Message> al = new ArrayList<Message>(mgs.values());
		return al;
	}
	public List<Message> getAllMessagesforYear(int year){
		List<Message> al = new ArrayList<Message>();
		Calendar cl = Calendar.getInstance();
		for(Message m:mgs.values()){
			cl.setTime(m.getCreated());
			if(cl.get(Calendar.YEAR) == year){
				al.add(m);
			}
		}
		return al;
	}

	public List<Message> getMessagePaginated(int start, int size){
		List<Message> al = new ArrayList<Message>(mgs.values());
		if(start + size > al.size())
			return new ArrayList<Message>();
		return al.subList(start, start + size);
	}	
	
	public Message getMessage(long id){
		Message mg = mgs.get(id);
		if(mg == null)
			throw new DataNotFoundException("message with id "+ id + " not found");
		return mg;
	}
	
	public Message addMessage(Message mg){
		mg.setId(mgs.size() + 1);
		mgs.put(mg.getId(), mg);
		return mg;
	}

	public Message updateMessage(Message mg){
		if(mg.getId() <= 0)
			return null;
		mgs.put(mg.getId(), mg);
		return mg;
	}
	
	public Message removeMessage(long id){
		return mgs.remove(id);
	}	
}
