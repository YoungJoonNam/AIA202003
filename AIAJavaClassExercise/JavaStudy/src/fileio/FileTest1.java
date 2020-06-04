package fileio;

import java.io.File;

public class FileTest1 {

	public static void main(String[] args) {
	
		//File myFile = new File("c:\\myJava\\test.txt");
		//File myFile = new File("c:\\myJava","test.txt");
		File myFile = new File("c:"+File.separator+"myJava","test.txt");
		if(myFile.exists()==false) {
			System.out.println("파일이 존재하지 않습니다.");
			return;
		} else {
			System.out.println("파일이 존재합니다.");
		}
		
		
		// 새로운 폴더 경로 생성
		File reDir = new File("c:\\yourJava");
		reDir.mkdir();
		File reFile = new File(reDir,"new.txt");
		myFile.renameTo(reFile);
		if(reFile.exists()==true) {
			System.out.println("파일 이동에 성공하였습니다");			
		}
		else {
			System.out.println("파일 이동에 실패하였습니다.");
		}
		
	

	}

}
