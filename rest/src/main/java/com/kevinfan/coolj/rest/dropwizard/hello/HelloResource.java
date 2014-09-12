package com.kevinfan.coolj.rest.dropwizard.hello;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kevinjom on 14-9-12.
 */
@Path("/hello")
@Produces("application/json")
public class HelloResource {
    private final String template;
    private final AtomicLong counter;

    public HelloResource(String template) {
        this.template = template;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Greeting greet(@QueryParam("name") Optional<String> name) {
        String result = String.format(template, name.or("default name"));
        return new Greeting(counter.incrementAndGet(), result);
    }
}
