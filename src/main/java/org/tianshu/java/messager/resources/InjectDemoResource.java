package org.tianshu.java.messager.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

//import org.tianshu.java.messager.model.Message;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("sessionID") String header,
											@CookieParam("sessionID") String cookie){
		
		return "MP " + matrixParam + " hd " + header + " cookie " + cookie;
	}
	
	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriif, @Context HttpHeaders headers){
		String path = uriif.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path = " + path + " Cookies = " + cookies;
	}
}
