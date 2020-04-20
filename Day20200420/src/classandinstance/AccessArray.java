package classandinstance;

public class AccessArray {

	public static void main(String[] args) {
		
		// int 타입의 정수 데이터를 3개 저장할수 있는 배열 생성
		// 배열의 이름 arr
		
		int[] arr = new int[3];
		
		
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		int sum=arr[0]+arr[1]+arr[2];
		System.out.println(sum);

	}

}
