package codespace.forumapi.model;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "fthreadimage")
public class FThreadImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int FThreadId;
	private String ImgId;
	public Object getFThreadId() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getFThreadId'");
	}
    public void setFThreadId(Object fThreadId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFThreadId'");
    }
    public Object getImgId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getImgId'");
    }
    public void setImgId(Object imgId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setImgId'");
    }
}
