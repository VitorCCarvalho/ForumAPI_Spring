package codespace.forumapi.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "fthreadreaction")
public class FThreadReaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ThreadId;

	private String UserId;
	private boolean Reaction;
	public Object getReaction() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getReaction'");
	}
    public void setReaction(Object reaction2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setReaction'");
    }
}
