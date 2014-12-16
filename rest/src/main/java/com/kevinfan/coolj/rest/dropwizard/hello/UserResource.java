package com.kevinfan.coolj.rest.dropwizard.hello;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;
import org.hibernate.validator.constraints.NotBlank;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kevinjom on 14-9-13.
 */
@Path("/user")
@Produces("application/json")
public class UserResource {
    private final ConcurrentMap<Long, User> users = new ConcurrentHashMap<Long, User>();
    private final AtomicLong counter = new AtomicLong();

    @Timed
    @Path("/create")
    @POST
    public Long create(@QueryParam("name") @NotBlank String name, @QueryParam("pwd") @NotBlank String pwd) {
        long id = counter.incrementAndGet();
        User user = new User(id, name, pwd);
        users.put(id, user);
        return id;
    }

    @Timed
    @Path("/{id}")
    @GET
    public User get(@PathParam("id") long id) {
        return users.get(id);
    }

}
