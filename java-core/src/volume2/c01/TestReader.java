package volume2.c01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class TestReader {
	
	public static void main(String[] args) {		
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constant.BASE_DIR + "employee.txt"), "UTF-8"));
				String line = null;
				while((line = in.readLine()) != null){
					System.out.println(line);
				}
			in.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
