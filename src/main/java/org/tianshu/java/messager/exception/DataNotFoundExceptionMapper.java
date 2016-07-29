package org.tianshu.java.messager.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.tianshu.java.messager.model.ErrorMessage;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage em = new ErrorMessage(ex.getMessage(), 404, "www.google.com");
		return Response.status(Status.NOT_FOUND)
						.entity(em)
						.build();
	}
	
}
