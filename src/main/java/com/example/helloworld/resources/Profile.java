package com.example.helloworld.resources;

import com.example.helloworld.User;
import com.codahale.metrics.annotation.Timed;
import javax.validation.constraints.NotEmpty;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

@Path("/social-profile")
@Produces(MediaType.APPLICATION_JSON)
public class Profile {
    String username;
    String location;
    Date today;
    private static final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public Profile()
    {
        username = "None";
        location = "India";
        today = new Date();
    }

    @GET
    @Timed
    public String getProfile(@QueryParam("user") @NotEmpty String uname)
    {
        username = uname;
        String result = username+"\'s profile";
        result+="\nLocation: "+location;
        result+="\nDate: "+df.format(today);
        result+="\nSignout: localhost:8080/social-network";
        return result;
    }
}
