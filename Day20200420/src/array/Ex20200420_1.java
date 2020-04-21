package array;

import java.util.Scanner;

public class Ex20200420_1 {

	public static int minValue(int[] arr) { // 최소값 반환
		int nMin = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(nMin > arr[i]) { 
				nMin = arr[i];				
			}
		}		
		return nMin;
	} 
	public static int maxValue(int[] arr) { // 최대값 반환
		int nMax = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(nMax < arr[i]) { 
				nMax = arr[i];				
			}
		}		
		return nMax;
	} 
	
	public static void addOneDArr(int[] arr, int add){
		for (int i=0; i<arr.length; i++)
				arr[i] +=add;
	}
	
	public static void addOneDArr(int[][] arr, int add) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] += add;
			}
		}
		
	}
	
	public static void PrintOneDArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");				 
			}
			System.out.print("\n");
		}
	}
	
	public static void ChangeArray(int[][] arr) {
		int[][] tempArray = new int[arr.length][arr[0].length];
		
		for(int i=0; i<arr.length; i++){
			//arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		    // 배열 src의 srcPos에서 배열 dest의 destPos로 length
            System.arraycopy(arr[i], 0, tempArray[i], 0, arr[i].length);
        }
        			
		System.arraycopy(tempArray[arr.length-1], 0, arr[0], 0, arr[0].length);
			
		for (int j = 0; j < arr.length-1; j++) {
			
			System.arraycopy(tempArray[j], 0, arr[j+1], 0, arr[j].length);
										 
		}
		
	}
	
	public static void main(String[] args) {
//		문제 1.
//		int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
//		그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
//
//		public static int miniValue(int[] arr) { . . . . } // 최소값 반환
//		public static int maxValue(int[] arr) { . . . . } // 최대값 반환
//
//		위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
//		두 매소드 실행을 확인인하기 위한 main 메소드 정의.
//		int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는
//		임의로 결정
		System.out.println("\n[문제1]-----------------\n");
		Scanner scInputUser = new Scanner(System.in);
		int nSizeOfArray=0;
		
		System.out.println("배열의 크기를 정해주세요");
		nSizeOfArray = scInputUser.nextInt();
		
		int[] nArray = new int[nSizeOfArray];
				
		for (int i = 0; i <nSizeOfArray; i++) {
			System.out.println("값을 입력해주세요 "+(i+1)+"/"+nSizeOfArray);
			nArray[i] = scInputUser.nextInt();
		}
		 
		System.out.println("최대값은 : "+maxValue(nArray));
		System.out.println("최소값은 : "+minValue(nArray));

//
//		문제 2.
//		다음 메서드는 int형 1차원 배열에 저장된 값을 두 번째 매개변수로 전달될 
//		값의 크기만큼 전부 증가시킨다.
//
//		public static void addOneDArr(int[] arr, int add){
//		for (int i=0, i<arr.length; i++)
//		arr[i] +=add;
//		}
//
//		이 메서드를 기반으로(이 메서들르 호출하는 형태로)int형 2차원 배열에 
//		저장된 값 전부를 증가시키는 메서드를 다음의 형태로 정의하자.
//		public static void addOneDArr(int[][] arr, int add) { . . . . . }
//		단 위 메서드는 2차원 배열의 가로, 세로 길이에 상관없이 동작해야 하며, 
//		위의 메서드가 제대로 동작하는지 확인하기 위한 main 메서드도 함께 정의해야 한다.
//
		System.out.println("\n[문제2]-----------------\n");
		int[][] arr2={
				{1, 2},
				{3, 4, 5},
				{6, 7, 8, 9}
		};
		
		System.out.println("<before>");
		PrintOneDArr(arr2);
		addOneDArr(arr2,3);
		System.out.println("<after>"+" +"+"3");
		PrintOneDArr(arr2);
//
//
//		문제 3.
//		다음의 형태로 표현된 2차원 배열이 존재한다고 가정해 보자.
//
//		1 2 3
//		4 5 6
//		7 8 9
//
//		이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 
//		다음의 형태로 배열의 구조를 변경시키는 메서드를 정의해 보자.
//
//		7 8 9
//		1 2 3
//		4 5 6
//
//		즉 총 N행으로 이뤄진 2차원 배열이 존재한다면, 메서드 호출 시, 
//		1행은 2행으로 이동이 이뤄져야한다. 이번에도 마찬가지로 배열의 가로, 
//		세로길이에 상관 없이 동작을 하도록 메서드가 정의되어야 하며, 
//		정의된 메서드의 확인을 위한 main메서드도 함께 정의하자.

		System.out.println("\n[문제3]-----------------\n");
		int[][] arr3={
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		System.out.println("<before>");
		PrintOneDArr(arr3);
		ChangeArray(arr3);
		System.out.println("<after>");
		PrintOneDArr(arr3);
		
		int[][] arr4={
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{10, 11, 12},
				{13, 14, 15}
		};
		
		System.out.println("<before>");
		PrintOneDArr(arr4);
		ChangeArray(arr4);
		System.out.println("<after>");
		PrintOneDArr(arr4);
		
	}

}
