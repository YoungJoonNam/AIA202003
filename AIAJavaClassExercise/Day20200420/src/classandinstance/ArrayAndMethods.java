package classandinstance;

public class ArrayAndMethods {

	public static void main(String[] args) {
		
		// 원본 배열 생성
		int[] arr = { 1, 2, 3, 4, 5 };
		
		// 결과 저장할 배열 선언
		int[] ref;
		
		// 메서드 호출 후 결과를 ref에 저장
		ref = addAllArray(arr, 7);
		
		if (arr == ref)
			System.out.println("동일 배열 참조");
		else
			System.out.println("다른 배열 참조");
		
		for (int i = 0; i < ref.length; i++)
			System.out.print(arr[i] + " ");
		
		
		System.out.println("\n\n"+"주소값 출력 : arr , ref => "+arr+" , "+ref);

	}


	// 배열을 전달 받고, 증가시킬 정수값도 입력 받음
	// 모든 배열의 요소에 더해줌, 전달 받은 배열을 반환
	public static int[] addAllArray(int[] ar, int addVal) {
		for (int i = 0; i < ar.length; i++)
			ar[i] += addVal;
		return ar;
	}

}
