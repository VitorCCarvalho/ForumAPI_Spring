package codespace.forumapi.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "threads")
public class FThread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
    
    @Column(name = "forum_id")
	private int ForumID;
    
    @Column(name = "name")
	private String Name;
    
    @Column(name = "text")
	private String Text;
    
    @Column(name = "user_id")
	private String UserId;
    
    @Column(name = "date_created")
	private Date DateCreated;

    public int getForumID() {
        return ForumID;
    }

    public void setForumID(int forumID) {
        ForumID = forumID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

	


}
