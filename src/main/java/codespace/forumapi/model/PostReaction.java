package codespace.forumapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "postreaction")
public class PostReaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int PostId;
	private String UserId;
	public Object getReaction() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getReaction'");
	}
    public void setReaction(Object reaction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setReaction'");
    }
}
