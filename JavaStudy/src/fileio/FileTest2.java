package fileio;

import java.io.File;

public class FileTest2 {

	public static void main(String[] args) {

		File myDir = new File("c:\\myJava");
		String[] fNames = myDir.list();
		
//		for (int i = 0; i < fNames.length; i++) {
//			System.out.println(fNames[i]);
//		}
		
		File[] files = myDir.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			
			if(files[i].isDirectory()) {
				System.out.print("[DIR]  ");
			}
			else {
				System.out.print("<FILE>  ");
			}
			
			System.out.println(files[i].getName());
		}

	}

}
