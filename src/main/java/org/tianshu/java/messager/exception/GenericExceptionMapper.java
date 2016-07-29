package org.tianshu.java.messager.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.tianshu.java.messager.model.ErrorMessage;
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{
	@Override
	public Response toResponse(Throwable ex) {
		// TODO Auto-generated method stub
		ErrorMessage em = new ErrorMessage(ex.getMessage(), 500, "www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(em)
						.build();
	}
}
