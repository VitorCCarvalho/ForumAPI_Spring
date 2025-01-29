package codespace.forumapi.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "AspNetUsers")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Id;
	private String Name;
	private String Email;
	private String Description;
	private Date LastLogin;
	private Date DateJoined;

	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getLastLogin() {
		return LastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		LastLogin = lastLogin;
	}

	public Date getDateJoined() {
		return DateJoined;
	}
	
	public void setDateJoined(Date dateJoined) {
		DateJoined = dateJoined;
	}
	


}
