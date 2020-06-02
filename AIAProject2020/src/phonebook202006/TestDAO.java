package phonebook202006;

public class TestDAO {

	public static void main(String[] args) {
		PhoneBDAO pd = new PhoneBDAO();
		
		String r=null;
		pd.Init();
		r=pd.getSeq();
		
		System.out.println("Result : "+r);
		
	}

}
