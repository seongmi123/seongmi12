
public class Member {
	private String ID;
	private String PW;
	private String nickName;

	public Member(String ID, String PW, String nickName) {
		this.ID = ID;
		this.PW = PW;
		this.nickName = nickName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
