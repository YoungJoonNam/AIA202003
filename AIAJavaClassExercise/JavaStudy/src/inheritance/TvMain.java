package inheritance;

public class TvMain {

	public static void main(String[] args) {

		Tv tv1 = new Tv();
		
		
		
		
		CaptionTv cTv1 = new CaptionTv();
		
		
		Tv tvt = cTv1;
		
		Tv tv2 = new CaptionTv();				

		
		System.out.println(tv2.power);
		tv2.power();
		System.out.println(tv2.power);
		// 오류 케이스 System.out.println(tv2.text);
		tv2.display();
		// 오류 케이스 System.out.println(((CaptionTv)tv1).text);
		System.out.println(((CaptionTv)tv2).text);
		
		((CaptionTv)tv2).display_a();
		
		// 오류케이스 CaptionTv cTvTest = tv2;
		CaptionTv cTvTest = (CaptionTv)tv2;
		
		cTvTest.display_a();
		
		Tv tv3 = new IpTv();
		Tv tv4 = new SmartTv();
		
		tv3.display();
		tv4.display();
		
		Tv[] tvs = new Tv[4];
		tvs[0] = new Tv();
		tvs[1] = new CaptionTv();
		tvs[2] = new IpTv();
		tvs[3] = new SmartTv();
		
		
		
		
	}

}
