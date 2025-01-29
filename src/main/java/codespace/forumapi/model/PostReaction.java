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
	private boolean Reaction;

	public void setReaction(boolean reaction) {
		Reaction = reaction;
	}
	public boolean getReaction() {
		return Reaction;
	}

	public int getPostId() {
		return PostId;
	}
	public void setPostId(int postId) {
		PostId = postId;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
}
