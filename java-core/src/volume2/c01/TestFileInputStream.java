package volume2.c01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
	
	public static void main(String[] args) {
		String fileSeparator = File.separator;
		System.out.println("File.separator=" + fileSeparator);		
		
		try {
			FileInputStream fin = new FileInputStream(String.format(
					"C:%sUsers%sray.sun%sJavaHub%siotest01.txt", 
					fileSeparator, fileSeparator, fileSeparator, fileSeparator));
			int available = fin.available();
			
			if(available > 0){
				byte[] buffer = new byte[available]; 
				fin.read(buffer);
				fin.close();
				System.out.println(new String(buffer));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
