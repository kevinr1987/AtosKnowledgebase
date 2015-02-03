package database;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("usercollection")
public class User {

	@Id
	@Property("id")
	private String id;

	@Property("FirstName")
	private String firstName;

	@Property("MiddleName")
	private String middleName;

	@Property("SurName")
	private String surName;

	@Property("DateOfBirth")
	private String geboorteDatum;

	@Property("Function")
	private String function;

	@Property("Compentence")
	private List<String> competenties;

	public User() {

	}

	public User(String id, String firstName, String middleName, String surName, String geboorteDatum, String function, List<String> competenties) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.surName = surName;
		this.geboorteDatum = geboorteDatum;
		this.function = function;
		this.competenties = competenties;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getGeboorteDatum() {
		return geboorteDatum;
	}

	public void setGeboorteDatum(String geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public List<String> getCompetenties() {
		return competenties;
	}

	public void setCompetenties(List<String> competenties) {
		this.competenties = competenties;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", surName=" + surName + ", geboorteDatum="
				+ geboorteDatum + ", function=" + function + ", competenties=" + competenties + "]";
	}

}