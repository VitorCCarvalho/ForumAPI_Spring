package codespace.forumapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fthreadimage")
public class FThreadImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int FThreadId;
	private String ImgId;
	
	public int getFThreadId() {
		return FThreadId;
	}
	public void setFThreadId(int fThreadId) {
		FThreadId = fThreadId;
	}
	public String getImgId() {
		return ImgId;
	}
	public void setImgId(String imgId) {
		ImgId = imgId;
	}

	

}
