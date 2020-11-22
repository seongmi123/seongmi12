import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {

	ArticleDao articleDao = new ArticleDao();
	Scanner sc = new Scanner(System.in);
	Member loginedMember = null;

public void doCommand(String user) {
	
	if (user.equals("add")) {
		addArticle();
	}
	
	if (user.equals("list")) {
		printArticleList();
	}

	if (user.equals("update")) {
		updateArticle();
	}

	if (user.equals("delete")) {
		deleteArticle();
	}
	
	if (user.equals("read")) {
		readArticle();
	}

	if (user.equals("search")) {
		searchArticle();
	}
}
	
	public void setLoginedMember(Member member) {
		this.loginedMember = member;
	}

	public void searchArticle() {
		System.out.print("검색 항목을 선택해주세요 (1. 제목, 2. 내용, 3, 제목+내용, 4. 작성자) : ");
		int select = Integer.parseInt(sc.nextLine());
		System.out.print("검색 키워드를 입력해주세요 : ");
		String keyword = sc.nextLine();
		ArrayList<게시물> list = articleDao.getArticles();

		for (int i = 0; i < list.size(); i++) {
			게시물 게시물 = list.get(i);
			String targetStr = "";
			if (select == 1) {
				targetStr = 게시물.getTitle();
			} else if (select == 2) {
				targetStr = 게시물.getContents();
			} else if (select == 3) {
				targetStr = 게시물.getTitle() + 게시물.getContents();
			} else {
				targetStr = 게시물.getWriter();
			}

			if (targetStr.contains(keyword)) {
				System.out.println("번호 : " + 게시물.getId());
				System.out.println("제목 : " + 게시물.getTitle());
				System.out.println("등록날짜 : " + 게시물.getDate());
				System.out.println("조회수 : " + 게시물.getClicks());
				System.out.println("작성자 : " + 게시물.getWriter());
				System.out.println("==============================");

			}
		}
	}

	public void readProcess(게시물 게시물) {
		while (true) {
			System.out.print("상세보기 기능을 선택해주세요(1. 댓글등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
			int readSelect = Integer.parseInt(sc.nextLine());
			if (readSelect == 1) {
				System.out.print("댓글 내용을 입력해주세요 : ");
				String comment = sc.nextLine();
				Comment c = new Comment(게시물.getId(), comment, "익명");
				articleDao.addReply(c);
				System.out.println("댓글이 등록되었습니다.");

				printArticle(게시물);

			} else if (readSelect == 2) {
				System.out.println("[좋아요]");
			} else if (readSelect == 3) {
				updateArticle();
			} else if (readSelect == 4) {
				deleteArticle();
			} else {
				break;
			}
		}
	}

	public void readArticle() {
		System.out.print("상세보기할 게시물 번호 : ");
		int readId = Integer.parseInt(sc.nextLine());

		게시물 게시물 = articleDao.getArticleById(readId);
		if (게시물 == null) {
			System.out.println("없는 게시물 입니다.");
		} else {
			int targetC = 게시물.getClicks();
			게시물.setClicks(targetC + 1);
			printArticle(게시물);
			readProcess(게시물);
		}
	}

	public void deleteArticle() {
		if (isLogin()) {
			System.out.print("삭제할 게시물 번호 : ");
			int deleteId = Integer.parseInt(sc.nextLine());
			boolean rst = articleDao.deleteArticle(deleteId);
			System.out.println("삭제가 완료되었습니다.");

			if (!rst) {
				System.out.println("잘못된 정보입니다.");
			}
		} 
	}

	public void updateArticle() {
		ArrayList<게시물> list = articleDao.getArticles();
		if (isLogin()) {
			System.out.print("수정할 게시물 번호 : ");
			int updateId = Integer.parseInt(sc.nextLine());

			for (int i = 0; i < list.size(); i++) {
				게시물 게시물 = list.get(i);
				게시물 target게시물 = list.get(updateId);
				if (게시물.getWriter().equals(target게시물.getWriter())) {
					System.out.print("제목 : ");
					String updateTitle = sc.nextLine();
					System.out.print("내용 : ");
					String updateContents = sc.nextLine();

					boolean rst = articleDao.updateArticle(updateId, updateTitle, updateContents);
					System.out.println("수정이 완료되었습니다.");

					if (!rst) {
						System.out.println("잘못된 정보입니다.");
					}

				} else {
					System.out.println("자신의 게시물만 수정 가능합니다.");
				}
			}

		} 
	}

	public void printArticleList() {
		ArrayList<게시물> list = articleDao.getArticles();
		for (int i = 0; i < list.size(); i++) {
			게시물 게시물 = list.get(i);
			System.out.println("번호 : " + 게시물.getId());
			System.out.println("제목 : " + 게시물.getTitle());
			System.out.println("작성자 : " + 게시물.getWriter());
			System.out.println("등록 날짜 : " + 게시물.getDate());
			System.out.println("조회수 : " + 게시물.getClicks());
			System.out.println("=======================");
		}
	}

	public void addArticle() {
		if (isLogin()) {
			System.out.print("게시물 제목을 입력해주세요 : ");
			String title = sc.nextLine();
			System.out.print("게시물 내용을 입력해주세요 : ");
			String contents = sc.nextLine();
			System.out.println("게시물이 등록되었습니다.");

			게시물 게시물 = new 게시물(title, contents, 0, "익명", "test");
			articleDao.addArticle(게시물);
		} 
	}

	public void printArticle(게시물 게시물) {
		System.out.println("========== " + 게시물.getId() + "번 게시물 ==========");
		System.out.println("번호 : " + 게시물.getId());
		System.out.println("제목 : " + 게시물.getTitle());
		System.out.println("내용 : " + 게시물.getContents());
		System.out.println("작성자 : " + 게시물.getWriter());
		System.out.println("등록 날짜 : " + 게시물.getDate());
		System.out.println("조회수 : " + 게시물.getClicks());
		System.out.println("================================");

		System.out.println("------------ 댓글 ------------");
		ArrayList<Comment> commentList = articleDao.getReplies();
		for (int j = 0; j < commentList.size(); j++) {
			Comment c = commentList.get(j);

			if (게시물.getId() == c.getParentId()) {
				System.out.println("내용 : " + c.getComment());
				System.out.println("작성자 : " + c.getWriter());
				System.out.println("등록 날짜 : " + c.getRegDate());
			}
		}
	}
	
	public boolean isMyArticle(게시물 게시물) {
		if(게시물.getWriterId().equals(loginedMember.getID())) {
			return true;
		} else {
			System.out.println("자신의 게시물만 수정/삭제할 수 있습니다.");
			return false;
		}
	}

	public boolean isLogin() {
		if(loginedMember == null) {
			System.out.println("로그인이 필요한 기능입니다.");
			return false;
		} else {
			return true;
		}
	}
	
	public void init() {
		ArrayList<게시물> list = articleDao.getArticles();
		게시물 a = new 게시물("제목1", "내용1", 1, articleDao.getCurrentDate(), 0, "익명1", "test");
		게시물 b = new 게시물("제목2", "내용2", 2, articleDao.getCurrentDate(), 0, "익명2", "test");
		게시물 c = new 게시물("제목3", "내용3", 3, articleDao.getCurrentDate(), 0, "익명3", "test");
		
		list.add(a);
		list.add(b);
		list.add(c);
	}

}
