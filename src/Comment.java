
public class Comment {
	private String comment;
	private int parentId;
	private String writer;
	private String regDate;

	public Comment(String comment, int parentId, String writer, String regDate) {
		this.comment = comment;
		this.parentId = parentId;
		this.writer = writer;
		this.regDate = regDate;
	}
	
	public Comment(int parentId, String comment, String writer) {
		super();
		this.parentId = parentId;
		this.comment = comment;
		this.writer = writer;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
