import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class 게시판1 {
	static ArrayList<게시물> list = new ArrayList<>();
	static ArrayList<Comment> commentList = new ArrayList<>();
	static ArrayList<Member> memberList = new ArrayList<>();
	
	static SimpleDateFormat format1 = new SimpleDateFormat ("yyyy.MM.dd");
	static Date time = new Date();		
	static String time1 = format1.format(time);
	
	public static int getArticleIndexById(int aid) {
		int index = -1; // -1 없다.

		for (int i = 0; i < list.size(); i++) {
			게시물 게시물 = list.get(i);
			if (aid == 게시물.getId()) {
				index = i;
			}
		}
		return index;
	}
	
	public static void printArticle(게시물 게시물) {
		System.out.println("========== "+게시물.getId()+"번 게시물 ==========");
		System.out.println("번호 : "+게시물.getId());
		System.out.println("제목 : "+게시물.getTitle());
		System.out.println("내용 : "+게시물.getContents());
		System.out.println("작성자 : "+게시물.getWriter());
		System.out.println("등록 날짜 : "+time1);
		System.out.println("조회수 : "+게시물.getClicks());
		System.out.println("================================");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		String ID;
		String PW;
		String nickName;
		
		String title;
		String contents;
		int id = 4;
		int existFlag = 1;//1.없다, 2.있다
		int clicks = 0;
		String writer = "익명";
		
		list.add(new 게시물("제목1", "내용1", 1, time1, clicks, writer));
		list.add(new 게시물("제목2", "내용2", 2, time1, clicks, writer));
		list.add(new 게시물("제목3", "내용3", 3, time1, clicks, writer));
		
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String user = sc.nextLine();
			
			if(user.equals("article add")) {
				
				System.out.print("게시물 제목을 입력해주세요 : ");
				title = sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요 : ");
				contents = sc.nextLine();
				System.out.println("게시물이 등록되었습니다.");
				list.add(new 게시물(title, contents, id, time1, clicks, writer));
				id++;
			}
			
			if(user.equals("member signup")) {
				System.out.println("======= 회원가입을 진행합니다 =======");
				System.out.print("아이디를 입력해주세요 : ");
				ID = sc.nextLine();
				System.out.print("비밀번호를 입력해주세요 : ");
				PW = sc.nextLine();
				System.out.print("닉네임을 입력해주세요 : ");
				nickName = sc.nextLine();
				memberList.add(new Member(ID, PW, nickName));
				
				System.out.println("======= 회원가입이 완료되었습니다 =======");
				
				
			}
			
			if(user.equals("member signin")) {
				while(true) {
					int f = 1;
					System.out.print("아이디 : ");
					String signId = sc.nextLine();
					System.out.print("비밀번호 : ");
					String signPW = sc.nextLine();
				
					for(int i = 0; i<memberList.size(); i++) {
						Member member = memberList.get(i);
						if (signId.equals(member.getID()) && signPW.equals(member.getPW())) {
							System.out.println(member.getNickName()+"님 환영합니다!");
							f = 0;
						}
					}
					
					if(f==1) {
						System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
					} else {
						break;
					}
				}
			}
			
			if(user.equals("help")) {
				System.out.println("article [add : 게시물 추가 / list : 게시물 목록 조회 / read : 게시물 조회 / search : 검색]");
				System.out.println("member [signup : 회원가입 / signin : 로그인 / findpass : 비밀번호 찾기 / findid : 아이디 찾기 / logout : 로그아웃 / myinfo : 나의정보 확인 및 수정]");
			
				System.out.print("명령어를 입력해주세요 : ");
				if(user.equals("article add")) {
					System.out.println("로그인이 필요한 기능입니다");
				}
			}
			
			if(user.equals("article list")) {
				for(int i = 0; i< list.size(); i++) {
					System.out.println("번호 : "+list.get(i).getId());
					System.out.println("제목 : "+list.get(i).getTitle());
					System.out.println("=======================");
				}
			}
			
			if(user.equals("update")) {
				System.out.print("수정할 게시물 번호 : ");
				int updateId = Integer.parseInt(sc.nextLine());
				
				int index = getArticleIndexById(updateId);
					if(index == -1) {
						System.out.println("잘못된 정보입니다.");
					} else {
						System.out.print("제목 : ");
						String updateTitle = sc.nextLine();
						System.out.print("내용 : ");
						String updateContents = sc.nextLine();
						게시물 게시물수정 = list.get(index);
					
						게시물수정.setTitle(updateTitle);
						게시물수정.setContents(updateContents);
					
						System.out.println("수정이 완료되었습니다.");
						
						for(int j = 0; j< list.size(); j++) {
							System.out.println("번호 : "+list.get(j).getId());
							System.out.println("제목 : "+list.get(j).getTitle());
							System.out.println("=======================");	
						}
					}
			}
			
			if(user.equals("delete")) {
				System.out.print("삭제할 게시물 번호 : ");
				int deleteId = Integer.parseInt(sc.nextLine());
				int index = getArticleIndexById(deleteId);
				if(index == -1) {
					System.out.println("잘못된 정보입니다.");
				} else {
					list.remove(index);
					System.out.println("삭제가 완료되었습니다.");
					for(int j = 0; j< list.size(); j++) {
						System.out.println("번호 : "+list.get(j).getId());
						System.out.println("제목 : "+list.get(j).getTitle());
						System.out.println("=======================");	
					}
				}
			}
			
			if(user.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			if(user.equals("read")) {
				System.out.print("원하는 게시물 번호 : ");
				int readId = Integer.parseInt(sc.nextLine());
				int index = getArticleIndexById(readId);
				if(index == -1) {
					System.out.println("잘못된 정보입니다.");
				} else {
					
					게시물 게시물 = list.get(index);
					clicks = 게시물.getClicks();
					게시물.setClicks(clicks+1);
					printArticle(게시물);
				}
				while(true) {
					System.out.print("상세보기 기능을 선택해주세요(1. 댓글등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
					int readSelect = Integer.parseInt(sc.nextLine());
					if(readSelect == 1) {
						System.out.print("댓글 내용을 입력해주세요 : ");
						String comment = sc.nextLine();
						commentList.add(new Comment(comment, index, "익명", time1));
						System.out.println("댓글이 등록되었습니다.");
					
						게시물 게시물 = list.get(index);
						printArticle(게시물);
						
						System.out.println("------------ 댓글 ------------");
						for(int i = 0; i<commentList.size(); i++) {
							Comment c = commentList.get(i);

							if(index == c.getParentId()) {
								System.out.println("내용 : "+c.getComment());
								System.out.println("작성자 : "+c.getWriter());
								System.out.println("등록 날짜 : "+c.getRegDate());
							}
						}
						
						

					} else if(readSelect == 2){
						System.out.println("[좋아요]");
					} else if(readSelect == 3){
						System.out.print("제목 : ");
						String updateTitle = sc.nextLine();
						System.out.print("내용 : ");
						String updateContents = sc.nextLine();
						게시물 게시물수정 = list.get(index);
						게시물수정.setTitle(updateTitle);
						게시물수정.setContents(updateContents);
						
						System.out.println("수정이 완료되었습니다.");
					} else if(readSelect == 4){
						list.remove(index);
						System.out.println("삭제가 완료되었습니다.");
					} else {
						break;
					}
				}
			
			}
			if(user.equals("search")) {
				System.out.print("검색 항목을 선택해주세요 (1. 제목, 2. 내용, 3, 제목+내용, 4. 작성자) : ");
				int select = Integer.parseInt(sc.nextLine());
				System.out.print("검색 키워드를 입력해주세요 : ");
				String keyword = sc.nextLine();
				switch(select) {
				case 1:
					for(int i = 0; i< list.size(); i++) {
						if(list.get(i).getTitle().contains(keyword)) {
							existFlag = 2;
							System.out.println("번호 : "+list.get(i).getId());
							System.out.println("제목 : "+list.get(i).getTitle());
							System.out.println("=======================");
						}
					}
					if(existFlag == 1) {
						System.out.println("잘못된 정보입니다.");
					}
					break;
				case 2:
					for(int i = 0; i< list.size(); i++) {
						if(list.get(i).getContents().contains(keyword)) {
							existFlag = 2;
							System.out.println("번호 : "+list.get(i).getId());
							System.out.println("제목 : "+list.get(i).getTitle());
							System.out.println("=======================");
						}
					}
					if(existFlag == 1) {
						System.out.println("잘못된 정보입니다.");
					}
					break;
				case 3:
					for(int i = 0; i< list.size(); i++) {
						if(list.get(i).getTitle().contains(keyword) || list.get(i).getContents().contains(keyword)) {
							existFlag = 2;
							System.out.println("번호 : "+list.get(i).getId());
							System.out.println("제목 : "+list.get(i).getTitle());
							System.out.println("=======================");
						}
					}
					if(existFlag == 1) {
						System.out.println("잘못된 정보입니다.");
					}
					break;
				case 4 : 
					for(int i = 0; i< list.size(); i++) {
						if(list.get(i).getWriter().contains(keyword)) {
							existFlag = 2;
							System.out.println("번호 : "+list.get(i).getId());
							System.out.println("제목 : "+list.get(i).getTitle());
							System.out.println("=======================");
						}
					}
					if(existFlag == 1) {
						System.out.println("잘못된 정보입니다.");
					}
					break;
				}
			}
		}
		sc.close();
	}
}

class Comment{
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


class Member{
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

class 게시물{
	private String title;
	private String contents;
	private int id;
	private String writer = "익명";
	private String cal;
	private int clicks = 0;
	
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
