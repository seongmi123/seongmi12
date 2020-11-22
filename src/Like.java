
public class Like {
	private int parentId;
	private String checkMemberId;
	private String regDate;
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getCheckMemberId() {
		return checkMemberId;
	}
	public void setCheckMemberId(String checkMemberId) {
		this.checkMemberId = checkMemberId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Like(int parentId, String checkMemberId, String regDate) {
		this.parentId = parentId;
		this.checkMemberId = checkMemberId;
		this.regDate = regDate;
		
	}
	
	public Like(int parentId, String checkMemberId) {
		this.parentId = parentId;
		this.checkMemberId = checkMemberId;		
	}
}
