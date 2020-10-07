package com.example;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @GET
    public List<User> getUsersByName(@QueryParam("name") String name) {
        return User.find("name like ?1", "%" + name + "%").list();
    }

    @POST
    @Transactional
    public Response createUser(User user) {
        User.persist(user);
        return Response.ok().build();
    }
}
