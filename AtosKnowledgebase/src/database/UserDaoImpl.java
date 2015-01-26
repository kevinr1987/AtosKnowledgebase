package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import controller.Database;

public class UserDaoImpl implements UserDao {

	Database database;

	public UserDaoImpl() {
		database = new Database();
	}

	@Override
	public void registerUser(String id, String fn, String mn, String ln, String dob, String function, List<String> competence) {
		Morphia morphia = new Morphia();
		morphia.mapPackage("database");
		Datastore datastore = morphia.createDatastore(database.getMongoClient(),
				database.getDatabaseName());
		datastore.save(new User(id, fn, mn, ln, dob, function, competence));
		
	}

	@Override
	public List<User> displayUsers() {
		DBCursor cursor = database.getCollection().find();
		List<User> users = new ArrayList<>();
		
		Morphia morphia = new Morphia();
		morphia.mapPackage("database");
		Datastore datastore = morphia.createDatastore(database.getMongoClient(),
				database.getDatabaseName());
//		users = datastore.find(User.class).asList();
		
		Query query = datastore.createQuery(User.class);
		for (int i = 0 ; i < query.asList().size(); i ++){
			User user = (User)query.asList().get(i);
			users.add(user);
		}
		
		try {
			while (cursor.hasNext()) {
				String s = "" + cursor.next();
				
			}
		} finally {
			cursor.close();
		}
		return users;
	}

	@Override
	public String getCollectionNames() {
		Set<String> colls = database.getDatabase().getCollectionNames();

		String collectionNames = "";
		// Iterate through the possible collections and print there names:
		for (String s : colls) {
			collectionNames = s + "\n";
		}
		return collectionNames;
	}

	@Override
	public void deleteAllRecordsSelectedCollection() {
		database.getCollection().remove(new BasicDBObject());
	}

	@Override
	public String getRecordsByID(String id) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", id);
		DBCursor dbObj = database.getCollection().find(query);

		String foundRecords = "";
		while (dbObj.hasNext()) {
			foundRecords = foundRecords + dbObj.next() + "\n";
		}

		return foundRecords;
	}

	@Override
	public String getRecordsByFirstName(String firstName) {
		BasicDBObject query = new BasicDBObject();
		query.put("FirstName", firstName);
		DBCursor dbObj = database.getCollection().find(query);

		String foundRecords = "";
		while (dbObj.hasNext()) {
			foundRecords = foundRecords + dbObj.next() + "\n";
		}

		return foundRecords;
	}

	@Override
	public String getRecordsByMiddleName(String middleName) {
		BasicDBObject query = new BasicDBObject();
		query.put("MiddleName", middleName);
		DBCursor dbObj = database.getCollection().find(query);

		String foundRecords = "";
		while (dbObj.hasNext()) {
			foundRecords = foundRecords + dbObj.next() + "\n";
		}

		return foundRecords;
	}

	@Override
	public String getRecordsByLastName(String lastName) {
		BasicDBObject query = new BasicDBObject();
		query.put("SurName", lastName);
		DBCursor dbObj = database.getCollection().find(query);

		String foundRecords = "";
		while (dbObj.hasNext()) {
			foundRecords = foundRecords + dbObj.next() + "\n";
		}

		return foundRecords;
	}
}
