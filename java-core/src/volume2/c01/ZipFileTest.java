package volume2.c01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.junit.Ignore;
import org.junit.Test;

/**
 * read/write zip file
 * @author ray.sun
 *
 */
public class ZipFileTest {
	
	@Test
	public void run() throws IOException{
		System.out.println(System.getProperty("user.dir"));
//		test2();
//		test3();
	}
	
	void test3() throws IOException{
		ZipFile zf = new ZipFile(Constant.BASE_DIR + "files02.zip");
		Enumeration<?> em = zf.entries();
		while(em.hasMoreElements()){
			ZipEntry ze = (ZipEntry)em.nextElement();
			
			try(Scanner in = new Scanner(zf.getInputStream(ze))){
				while(in.hasNext()){
					System.out.println(in.nextLine());
				}
			}			
		}
		
		zf.close();
	}
	
	void test2() throws IOException{
		FileOutputStream fout = new FileOutputStream(Constant.BASE_DIR + "files02.zip");
		ZipOutputStream zout = new ZipOutputStream(fout);
		
		writeZipFile(zout, "mood.txt", "信念：应无所住而生其心".getBytes("UTF-8"));
		writeZipFile(zout, "schedule.txt", "计划：每天/周一个小目标，每月一个中等目标，每年一个大目标".getBytes("UTF-8"));
		writeZipFile(zout, "hobby.txt", "爱好：跑步/书法/阅读经典".getBytes("UTF-8"));
		
		zout.close();
		
	}
	
	private void writeZipFile(ZipOutputStream zout, String fileName, byte[] data) throws IOException{
		ZipEntry ze = new ZipEntry(fileName);
		zout.putNextEntry(ze);
		zout.write(data);
		zout.closeEntry();
		System.out.println(fileName + " written out.");
	}

	@Ignore
	@Test
	public void test1() throws IOException {

		ZipInputStream zin = new ZipInputStream(new FileInputStream(Constant.BASE_DIR + "files.zip"));
		ZipEntry entry;
		while ((entry = zin.getNextEntry()) != null) {
			// analyze entry
			// read the contends of zin
			Scanner in = new Scanner(zin);
			while(in.hasNextLine()){
				System.out.println(in.nextLine());
			}
			System.out.println("############################################");
			
			zin.closeEntry();
		}
		zin.close();

	}

}
