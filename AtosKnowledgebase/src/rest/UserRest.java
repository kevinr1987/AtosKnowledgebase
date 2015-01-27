package rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import database.User;
import database.UserDao;

@Path("/user")
public class UserRest {

	@Inject
	private UserDao userDao;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addUser(@FormParam("id") String id, @FormParam("fn") String fn,
			@FormParam("mn") String mn, @FormParam("ln") String ln, @FormParam("dob") String dob,
			@FormParam("func") String func, @FormParam("comp") List<String> comp) {

		if (id.isEmpty() || fn.isEmpty() || ln.isEmpty()) {

		} else {
			try {
				userDao.registerUser(id.toUpperCase(), fn, mn, ln, dob, func, comp);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userDao.displayUsers();
	}
}
