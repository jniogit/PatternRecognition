package io.swagger.api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Point;

@Path("/")
@Api(value = "/", description = "")
public interface DefaultApi  {

    @GET
    @Path("/lines")
    @ApiOperation(value = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "All lines with N collinear points", response = List.class, responseContainer = "List") })
    public List<List<Point>> linesGet(@Multipart(value = "N")  Integer N);

    @POST
    @Path("/point")
    @ApiOperation(value = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response") })
    public void pointPost(@Multipart(value = "x")  Double x, @Multipart(value = "y")  Double y);

    @DELETE
    @Path("/space")
    @ApiOperation(value = "Delete", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    public void spaceDelete();

    @GET
    @Path("/space")
    @ApiOperation(value = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Get all points in the space", response = Point.class, responseContainer = "List") })
    public List<Point> spaceGet();
}

