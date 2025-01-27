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

	public Object getContent() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getContent'");
	}

    public void setContent(Object content) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setContent'");
    }

    public Object getTitle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitle'");
    }

    public void setTitle(Object title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }
}
