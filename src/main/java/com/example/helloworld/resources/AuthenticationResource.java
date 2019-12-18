package com.example.helloworld.resources;

import com.example.helloworld.User;
import com.codahale.metrics.annotation.Timed;
import com.sun.jndi.toolkit.url.Uri;
import io.dropwizard.auth.Auth;

import javax.validation.constraints.NotEmpty;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import io.dropwizard.jersey.caching.CacheControl;

@Path("/social-network")
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

    @GET
    @CacheControl(maxAge = 10, maxAgeUnit = TimeUnit.SECONDS)
    public Response getUser(@Auth User user)
    {
        URI uri = UriBuilder.fromUri("/social-profile?user="+user.getName()).build();
        return Response.seeOther(uri).build();
    }
}
