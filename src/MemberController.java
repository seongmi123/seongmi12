import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	ArrayList<Member> memberList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	int login = 0;
	
	public void memberInit() {
		memberList.add(new Member("uk111", "uk111", "익명1"));
		memberList.add(new Member("uk222", "uk222", "익명2"));
		memberList.add(new Member("uk333", "uk333", "익명3"));
	}
	
	public void memberSignin() {
		memberInit();
		int f = 1;
		System.out.print("아이디 : ");
		String signId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String signPW = sc.nextLine();

		for (int i = 0; i < memberList.size(); i++) {
			Member member = memberList.get(i);
			if (signId.equals(member.getID()) && signPW.equals(member.getPW())) {
				System.out.println(member.getNickName() + "님 환영합니다!");
				f = 0;
				login = 1;
				break;
			}
		}
		if (f == 1) {
			System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
		}
	}
	
	public void memberSignup() {
		System.out.println("======= 회원가입을 진행합니다 =======");
		System.out.print("아이디를 입력해주세요 : ");
		String ID = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String PW = sc.nextLine();
		System.out.print("닉네임을 입력해주세요 : ");
		String nickName = sc.nextLine();
		memberList.add(new Member(ID, PW, nickName));

		System.out.println("======= 회원가입이 완료되었습니다 =======");
	}
}
