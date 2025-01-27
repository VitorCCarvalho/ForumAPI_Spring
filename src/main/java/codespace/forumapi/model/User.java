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
	private String Description;
	private Date LastLogin;
	private Date DateJoined;
	
}
