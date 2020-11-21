import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArticleDao {
	private ArrayList<게시물> list = new ArrayList<>();
	private ArrayList<Comment> commentList = new ArrayList<>();
	int id = 4;

	public String getCurrentDate() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM.dd");
		Date time = new Date();		
		String time1 = format1.format(time);
		return time1;
	}

	public void init() {
		list.add(new 게시물("제목1", "내용1", 1, getCurrentDate(), 0, "익명1"));
		list.add(new 게시물("제목2", "내용2", 2, getCurrentDate(), 0, "익명2"));
		list.add(new 게시물("제목3", "내용3", 3, getCurrentDate(), 0, "익명3"));  
	}

	public void addReply(Comment c) {
		c.setRegDate(getCurrentDate());
		commentList.add(c);
	}

	public void addArticle(게시물 article) {
		article.setId(id);
		article.setDate(getCurrentDate());
		list.add(article);
		id++;
	}

	public boolean updateArticle(int id, String title, String content) {
		int index = getArticleIndexById(id);
		if(index != -1) {
			게시물 게시물 = list.get(index);
			게시물.setTitle(title);
			게시물.setContents(content);

			list.set(index, 게시물);
			return true;
		} 

		return false;
	}

	public boolean deleteArticle(int id) {
		int index = getArticleIndexById(id);
		if(index != -1) {
			list.remove(index);
			return true;
		}

		return false;
	}

	public 게시물 getArticleById(int id) {
		int index = getArticleIndexById(id);
		if(index == -1) {
			return null;
		} else {
			return list.get(index);
		}
	}

	public int getArticleIndexById(int aid) {
		int index = -1; // -1 없다.

		for (int i = 0; i < list.size(); i++) {
			게시물 게시물 = list.get(i);
			if (aid == 게시물.getId()) {
				index = i;
			}
		}

		return index;

	}

	public ArrayList<게시물> getArticles() {
		return list;
	}
	public void setArticles(ArrayList<게시물> list) {
		this.list = list;
	}
	public ArrayList<Comment> getReplies() {
		return commentList;
	}
	public void setReplies(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}	

}