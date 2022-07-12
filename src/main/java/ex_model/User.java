package ex_model;

public class User {
	private int id;
	private String name;
	private String country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public User(int id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}
	public User(String name2, String country2) {
		super();
		this.name = name2;
		this.country = country2;
	}

}
