package org.tianshu.java.messager.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.tianshu.java.messager.model.Message;
import org.tianshu.java.messager.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService ms = new MessageService();
	
	@GET
	public List<Message> getMessage(@BeanParam MessageFilterBean filterBean
//									@QueryParam("year")int year,
//									@QueryParam("start")int start,
//									@QueryParam("size")int size
									){
		if(filterBean.getYear() > 0)
			return ms.getAllMessagesforYear(filterBean.getYear());
		if(filterBean.getStart() >= 0 && filterBean.getSize() >= 0)
			return ms.getMessagePaginated(filterBean.getStart(), filterBean.getSize());
		
		return ms.getAllMessages();
	}
	
	
	@POST
	public Response addMessage(Message mg, @Context UriInfo uriif) throws URISyntaxException{
		Message meg = ms.addMessage(mg);
		String newId = String.valueOf(meg.getId());
		URI uri = uriif.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(meg)
				.build();
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id, Message mg){
		mg.setId(id);
		return ms.updateMessage(mg);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message removeMessage(@PathParam("messageId")long id){
		return ms.removeMessage(id);
	}	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		return ms.getMessage(id);
	}
	

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}
