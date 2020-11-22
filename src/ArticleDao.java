import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArticleDao {
	private ArrayList<게시물> list = new ArrayList<>();
	private ArrayList<Comment> commentList = new ArrayList<>();
	private ArrayList<Like> likeList = new ArrayList<>();
	int id = 4;

	public String getCurrentDate() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM.dd");
		Date time = new Date();		
		String time1 = format1.format(time);
		return time1;
	}
	
	public boolean isExistLikeByParentIdAndMemberId(int parentId, String memberId) {
		for(int i =0; i<likeList.size(); i++) {
			if(likeList.get(i).getParentId() == parentId && likeList.get(i).getCheckMemberId().equals(memberId)) {
				return true;
			}
		}
		return false;
	}
	
	public int getLikeCountByParentId(int parentId) {
		int cnt = 0;
		for(int i = 0; i < likeList.size(); i++) {
			if(likeList.get(i).getParentId() == parentId) {
				cnt++;
			}
		}

		return cnt;
	}

	public Like getLikeByParentIdAndMemberLoginId(int parentId, String memberLoginId) {
		for(int i = 0; i < likeList.size(); i++) {
			if(likeList.get(i).getParentId() == parentId && likeList.get(i).getCheckMemberId().equals(memberLoginId)) {
				return likeList.get(i);
			}
		}

		return null;
	}

	public void removeLike(Like like) {
		likeList.remove(like);
	}
	
	public void addLike(Like like) {
		like.setRegDate(getCurrentDate());
		likeList.add(like);
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