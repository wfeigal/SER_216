package Core_Week_3;

public class Customer {
	private String name = "";
	private String streetAddress = "";
	private String city = "";
	private String state = "";
	private String zip = "";
	private int age = 0;
	/**
	 * Constructor for Customer object initializes the name and address 
	 * of the account holder
	 * 
	 * @param newname name of account holder
	 * @param newaddress Address of account holder
	 */
	public Customer(String newname, String newaddress){
		this.name = newname;
		this.streetAddress = newaddress;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the age
	 */
	public int getAge() {    
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * 
	 * @return the formatted address of the account holder
	 */
	public String displayAddress() {
		return this.streetAddress + "\n" + this.city + ", " + this.state + " " + this.zip;
	}
	/**
	 * 
	 * @return the formatted address label for the account holder, includes name
	 */
	public String displayAddressLabel() {
		return this.name + "\n" + this.streetAddress + "\n" + this.city + ", " + this.state + " " + this.zip;
	}
}
