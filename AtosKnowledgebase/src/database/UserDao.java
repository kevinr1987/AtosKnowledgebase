package database;

import java.util.List;

public interface UserDao {

	public void registerUser(String id, String fn, String mn, String ln, String dob, String function, List<String> competence);

	public List<User> displayUsers();

	public String getCollectionNames();

	public void deleteAllRecordsSelectedCollection();

	public String getRecordsByID(String id);

	public String getRecordsByFirstName(String firstName);

	public String getRecordsByMiddleName(String middleName);

	public String getRecordsByLastName(String lastName);

}
