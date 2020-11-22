import java.util.ArrayList;
import java.util.Scanner;

public class App {
	ArrayList<Member> memberList = new ArrayList<>();
	ArticleController ac = new ArticleController();
	MemberController mc = new MemberController();
	ArticleDao articleDao = new ArticleDao();
	
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		ac.init();
		mc.memberInit();
		
		while(true) {
			Member loginedMember = mc.getLoginedMember();
			ac.setLoginedMember(loginedMember);
			
			if (loginedMember == null) {
				System.out.print("명령어를 입력해주세요 : ");
			} else {
				System.out.print(
						"명령어를 입력해주세요 [" + loginedMember.getID() + "(" + loginedMember.getNickName() + ")] : ");
			}
			String user = sc.nextLine();
			
			String[] userBits = user.split(" ");

			if(userBits.length < 2) {
				System.out.println("잘못된 명령어입니다.");
				continue;
			}
			String module = userBits[0]; // article
		    String func = userBits[1]; // list add

			if(module.equals("article")) {
				ac.doCommand(func);				
			} else if(module.equals("member")) {				
				mc.doCommand(func);
			}

			if (user.equals("help")) {
				System.out.println("article [add : 게시물 추가 / list : 게시물 목록 조회 / read : 게시물 조회 / search : 검색]");
				System.out.println(
						"member [signup : 회원가입 / signin : 로그인 / findpass : 비밀번호 찾기 / findid : 아이디 찾기 / logout : 로그아웃 / myinfo : 나의정보 확인 및 수정]");

			}

			if (user.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}
		sc.close();
	}
}
