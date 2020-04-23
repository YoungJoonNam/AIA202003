package inheritance;

public class IpTv extends Tv {

	String IpTvName = "daumipTv";
	void display() {
		super.display();
		System.out.println(IpTvName + "  IpTv를 봅니다.");
	}
}
