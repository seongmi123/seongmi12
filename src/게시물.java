
public class 게시물 {
	private String title;
	private String contents;
	private int id;
	private String writer;
	private String cal;
	private int clicks;

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public String getWriter() {
		return writer;
	}

	public void setWritter(String writer) {
		this.writer = writer;
	}

	public String getCal() {
		return cal;
	}

	public void setCal(String cal) {
		this.cal = cal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public 게시물(String title, String contents, int id, String cal, int clicks, String writer) {
		this.title = title;
		this.contents = contents;
		this.id = id;
		this.cal = cal;
		this.clicks = clicks;
		this.writer = writer;
	}
}
