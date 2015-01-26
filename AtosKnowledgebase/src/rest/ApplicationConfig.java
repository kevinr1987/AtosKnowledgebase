package rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		addRestResourcesClasses(resources);
		return resources;
	}

	private void addRestResourcesClasses(Set<Class<?>> resources) {
		resources.add(rest.UserRest.class);
		// resources.add(controller.RegisterUser.class);
		// resources.add(controller.Database.class);
		// resources.add(database.User.class);
	}
}
