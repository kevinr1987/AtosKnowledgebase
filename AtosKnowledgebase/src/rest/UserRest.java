package rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import database.User;
import database.UserDao;

@Path("/add")
public class UserRest {

	@Inject
	private UserDao userDao;

	@POST
	@Path("/addUser")
	@Produces(MediaType.TEXT_PLAIN)
	public Response addUser(@FormParam("id") String id, @FormParam("fn") String fn,
			@FormParam("mn") String mn, @FormParam("ln") String ln, @FormParam("dob") String dob,
			@FormParam("func") String func, @FormParam("comp") List<String> comp) {

		if (id.isEmpty() || fn.isEmpty() || ln.isEmpty()) {
			return Response
					.status(200)
					.entity("You need to fill in all the required fields! <br /> <a href='javascript:javascript:history.go(-1)'>Click here</a> to go back to the previous page.")
					.build();
		} else {
			try {

				// Validates member using bean validation
				// UserDao userDao = new UserDaoImpl();
				userDao.registerUser(id.toUpperCase(), fn, mn, ln, dob, func, comp);
				return Response.status(200).entity("New user: " + fn + " " + ln + " created!")
						.build();
			} catch (Exception e) {
				e.getStackTrace();
				return Response.status(200).entity("New user wasn't created!").build();
			}
		}
	}

	@GET
	@Path("/getusers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userDao.displayUsers();
	}
}
