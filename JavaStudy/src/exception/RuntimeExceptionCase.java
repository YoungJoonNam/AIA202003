package exception;

public class RuntimeExceptionCase {

	public static void main(String[] args) {
		try {
			int[] arr = new int[3];
			arr[3] = 20;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		
		
		try {
			Object obj = new int[10];
			String str = (String) obj;
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
			
		try {
			int[] arr1 = new int[-10];
		} catch (NegativeArraySizeException e) {
			System.out.println(e.getMessage());
		}
		try {
			String str = null;
			int len = str.length();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
			
	}

}
