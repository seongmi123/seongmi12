import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class 게시판1 {
	static ArrayList<게시물> list = new ArrayList<>();
	static ArrayList<String> commentList = new ArrayList<>();
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy.MM.dd");
		Date time = new Date();		
		String time1 = format1.format(time);
	
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
			if(user.equals("add")) {
				System.out.print("게시물 제목을 입력해주세요 : ");
				title = sc.nextLine();
				System.out.print("게시물 내용을 입력해주세요 : ");
				contents = sc.nextLine();
				System.out.println("게시물이 등록되었습니다.");
				list.add(new 게시물(title, contents, id, time1, clicks, writer));
				id++;
			}
			
			if(user.equals("list")) {
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
						///수정필요
						list.set(index, new 게시물(updateTitle, updateContents, index, list.get(index).getCal(), list.get(index).getClicks(), list.get(index).getWriter()));
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
					System.out.println("========== "+list.get(index).getId()+"번 게시물 ==========");
					System.out.println("번호 : "+list.get(index).getId());
					System.out.println("제목 : "+list.get(index).getTitle());
					System.out.println("내용 : "+list.get(index).getContents());
					System.out.println("작성자 : "+list.get(index).getWriter());
					System.out.println("등록 날짜 : "+time1);
					System.out.println("조회수 : "+list.get(index).getClicks());
					System.out.println("================================");
				}
				while(true) {
					System.out.print("상세보기 기능을 선택해주세요(1. 댓글등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
					int readSelect = Integer.parseInt(sc.nextLine());
					if(readSelect == 1) {
						System.out.print("댓글 내용을 입력해주세요 : ");
						String comment = sc.nextLine();
						commentList.add(comment);
						System.out.println("댓글이 등록되었습니다.");
					
						System.out.println("========== "+list.get(index).getId()+"번 게시물 ==========");
						System.out.println("번호 : "+list.get(index).getId());
						System.out.println("제목 : "+list.get(index).getTitle());
						System.out.println("내용 : "+list.get(index).getContents());
						System.out.println("작성자 : "+list.get(index).getWriter());
						System.out.println("등록 날짜 : "+time1);
						System.out.println("조회수 : "+list.get(index).getClicks());
						System.out.println("================================");
					
						System.out.println("------------ 댓글 ------------");
						for(int i = 0; i<commentList.size(); i++) {
							System.out.println("내용 : "+commentList.get(i));
							System.out.println("작성자 : 익명");
							System.out.println("등록 날짜 : "+time1);
						}

					} else if(readSelect == 2){
						System.out.println("[좋아요]");
					} else if(readSelect == 3){
						System.out.print("제목 : ");
						String updateTitle = sc.nextLine();
						System.out.print("내용 : ");
						String updateContents = sc.nextLine();
						list.set(index, new 게시물(updateTitle, updateContents, index, list.get(index).getCal(), list.get(index).getClicks(), list.get(index).getWriter()));
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

class 게시물{
	private String title;
	private String contents;
	private int id;
	private String writer = "익명";
	private String cal;
	private int clicks = 0;
	
	public int getClicks() {
		clicks++;
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
