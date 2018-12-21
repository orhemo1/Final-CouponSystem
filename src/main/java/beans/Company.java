package beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * this is the object for making companies.
 * 
 *
 */
@XmlRootElement
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String password;
	private String email;

	public Company() {
	}

	public Company(long id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;

	}

	public Company(String name, String password, String email) {
		super();

		this.name = name;
		this.password = password;
		this.email = email;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}

}
