package com.example.helloworld.resources;

import com.example.helloworld.api.Saying;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final String defaultName2;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName, String defaultName2) {
        this.template = template;
        this.defaultName = defaultName;
        this.defaultName2 = defaultName2;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name, @QueryParam("name2") Optional<String> name2) {
        final String value = String.format(template, name.orElse(defaultName),name2.orElse(defaultName2));
        return new Saying(counter.incrementAndGet(), value);
    }
}
