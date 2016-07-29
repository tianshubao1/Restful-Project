package org.tianshu.java.messager.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//tuitorial 在25 12：00完成  comment class
@Path("/")
public class CommentResource {
	
	@GET
	public String test(){
		return "sub resource";
	}
	
	@GET
	@Path("{commentId}")
	public String test2(@PathParam("messageId")long mgid, @PathParam("commentId")long comid){
		return "messageId = " + mgid + ", commentId = " + comid;
	}	
}
