
public class 게시물 {
	private String title;
	private String contents;
	private int id;
	private String writer;
	private String date;
	private int clicks;
	private String writerId;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public 게시물(String title, String contents, int id, String date, int clicks, String writer, String writerId) {
		this.title = title;
		this.contents = contents;
		this.id = id;
		this.date = date;
		this.clicks = clicks;
		this.writer = writer;
		this.writerId = writerId;
	}
	
	public 게시물(String title, String contents, int clicks, String writer, String writerId) {
		this.title = title;
		this.contents = contents;
		this.clicks = clicks;
		this.writer = writer;
		this.writerId = writerId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
}
