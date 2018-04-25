package landlord;

import java.util.List;

public class LandlordPojo {

	/*
	 * { "id": "53ASHANA",
	 *  "firstName": "aana", 
	 *  "lastName": "sa", 
	 *  "trusted": false, 
	 * "apartments": [] }
	 */

	public String id;
	public String lastName;
	public String trusted;
	public String[] apartments;
	public String firstName;

	public LandlordPojo(String id, String lastName, String trusted,
			String[] apartments, String firstName) {
		
		this.id = id;
		this.lastName = lastName;
		this.trusted = trusted;
		this.apartments = apartments;
		this.firstName = firstName;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTrusted() {
		return trusted;
	}

	public void setTrusted(String trusted) {
		this.trusted = trusted;
	}

	public String[] getApartments() {
		return apartments;
	}

	public void setApartments(String[] apartments) {
		this.apartments = apartments;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
}
