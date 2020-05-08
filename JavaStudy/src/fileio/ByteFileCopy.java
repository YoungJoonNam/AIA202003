package fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {

	public static void main(String[] args) throws IOException{

		//InputStream in = new FileInputStream("C:\\Users\\BIT02-19\\Documents\\GitHub\\AIA202003\\JavaStudy\\src\\fileio\\test.txt");
		//OutputStream out = new FileOutputStream("C:\\Users\\BIT02-19\\Documents\\GitHub\\AIA202003\\JavaStudy\\src\\fileio\\copy.txt");
		InputStream in = new FileInputStream("test.txt");
		OutputStream out = new FileOutputStream("copy.txt");
		int copyByte = 0;
		int bData;
		while (true) {
			bData = in.read();
			
			if (bData == -1)
				break;
			out.write(bData);			
			copyByte++;
					
		}
		in.close();
		out.close();
		System.out.println("복사된 바이트 크기 " + copyByte);

	}

}
