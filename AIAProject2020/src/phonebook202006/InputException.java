package phonebook202006;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputException {

	Map<String, String> map;
	static Scanner sc;	
	
	private InputException(){
		sc = new Scanner(System.in);
		map = new HashMap<>();
	}
	
	private static InputException manager = new InputException();
	
	public static InputException getInstance() {
		return manager;
	}
	
	//[사용법]******************************************************************
	//제한하고 싶은 값을 입력하면, 그외의 값을 입력할 경우 재입력을 요구함
	//예) inputStr = userInputData("1","2");  --> 1,2 이외의 값은 재입력 요구
	//	
	//제한하고 싶은 값이 없는 경우, "none"를 입력	
	//예) String job = userInputData("none");
	//
	//int 형을 받고 싶은 경우, "int"를 입력
	//예) int mgr = Integer.parseInt(userInputData("int"));	
	//
	//double 형을 받고 싶은 경우, "double"를 입력
	//
	//date 형을 입력 받고 싶은 경우, "data"를 입력
	//예) System.out.print("hiredate : (2020-11-5) 형식으로 입력해주세요");
	//     String hiredate = userInputData("date");
	//**************************************************************************
	public String userInputData(String ...exceptS) {
		
		int count=1;
		String key=null;
		String input=null;
				
		map.clear();
		
		for(String str : exceptS) {
			
			if(str.equals("int")) {
				map.put("int","int");
				break;				
			}
			else if(str.equals("double")) {
				map.put("double","double");
				break;				
			}
			else if(str.equals("none")) {
				map.put("none","none");
				break;				
			}
			else if(str.equals("date")) {
				map.put("date","date");
				break;				
			}
			else {
				key = "k"+count;
				map.put(key, str);
				count++;				
			}
		}
			
		
		while(true) {
			System.out.print(">>  ");
					
			input=InputDataException(map);
			
			if(input != null) { //
				break;
			}
			else { //적합하지 않은 값이 입력된 경우
				System.out.println("적합하지 않은 값이 입력되었습니다. ");
				continue;
			}			
		}
				
		return input;		
	}
	//map : 허용값
	//허용값에 적합할 경우 입력받은 String을 리턴
	//허용값에 적합하지 않을 경우, null을 리턴
	private String InputDataException(Map<String, String> map){
		String str = sc.nextLine();
		int size = map.size();
		boolean check = false;
		
		try {	// 주관식 문항 : 입력값이 측정가능 숫자로 들어와야하는 경우
			if(map.containsKey("int")) {
				Integer.parseInt(str);
				check = true;
			}
			else if(map.containsKey("double")) { //20200512
				Double.parseDouble(str);				
				check = true;
			}
			else if(map.containsKey("none")) {
				check = true;
			}
			else if(map.containsKey("date")) {				
				Date d = Date.valueOf(str);
				check = true;
			}	
			else {	// 객관식 문항 : 입력값이 정수로 들어와야하는 경우
				for(int i=1; i<=size; i++) {
					//if(map.containsKey("k"+i))
					if(map.get("k"+i)!=null) {
						if(map.get("k"+i).equals(str)) {
							check = true;
							break;
						}
						else {	// 정상 작동시 입력값 리턴
						}
					}
				}
			}
			if(check == false) {
				OptionInputException excpt = new OptionInputException();
				throw excpt;
			}
		} catch(OptionInputException e) {
			str = null;
//			e.printStackTrace();
		} catch(NumberFormatException e) {
			str = null;
//			e.printStackTrace();
		} catch(Exception e) {
			str = null;
		}
		
		return str;
	}
	
	public void Close() {
		sc.close();
	}
}



class OptionInputException extends Exception {

	public OptionInputException() {
		
	}

}

