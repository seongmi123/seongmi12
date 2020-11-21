import java.util.ArrayList;
import java.util.Scanner;

public class App {
	ArrayList<Member> memberList = new ArrayList<>();
	ArticleController ac = new ArticleController();
	MemberController mc = new MemberController();
	
	Scanner sc = new Scanner(System.in);
	
	public void start() {
		Member loginedMember = null;
		while(true) {
			if (loginedMember == null) {
				System.out.print("명령어를 입력해주세요 : ");
			} else {
				System.out.println(
						"명령어를 입력해주세요 [" + loginedMember.getLoginID() + "(" + loginedMember.getNickName() + ")] : ");
			}
			String user = sc.nextLine();

			if (user.equals("help")) {
				ac.help();
			}

			if (user.equals("add")) {
				ac.addArticle();
			}

			if (user.equals("myinfo")) {
				ac.myInfo();
			}

			if (user.equals("signup")) {
				mc.memberSignup();
			}

			if (user.equals("signin")) {
				mc.memberSignin();
			}

			if (user.equals("list")) {
				ac.printArticleList();
			}

			if (user.equals("update")) {
				ac.updateArticle();
			}

			if (user.equals("delete")) {
				ac.deleteArticle();
			}

			if (user.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			if (user.equals("read")) {
				ac.readArticle();
			}

			if (user.equals("search")) {
				ac.searchArticle();
			}
			
		}
		sc.close();
	}
}
