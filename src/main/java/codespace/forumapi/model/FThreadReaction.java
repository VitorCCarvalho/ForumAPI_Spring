package codespace.forumapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fthreadreaction")
public class FThreadReaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ThreadId;
	private String UserId;
	private boolean Reaction;

	public boolean getReaction() {
		return Reaction;
	}
	public void setReaction(boolean reaction) {
		Reaction = reaction;
	}

	public int getThreadId() {
		return ThreadId;
	}
	public void setThreadId(int threadId) {
		ThreadId = threadId;
	}

	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}

}
