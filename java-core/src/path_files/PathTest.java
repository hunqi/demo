package path_files;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Ignore;
import org.junit.Test;

public class PathTest {
	
	@Test
	public void test2(){
		
		Path p = Paths.get("D:", "demo", "employee.txt");
		System.out.println(p);
		System.out.println(p.getParent());
		System.out.println(p.getFileName());
		System.out.println(p.getRoot());
		System.out.println(p.toFile());
		
		System.out.println("getFileName of empty=" + Paths.get("").getFileName());
	}
	
	@Ignore
	@Test
	public void test1(){
		Path absolute = Paths.get("D:", "demo", "file", "employees.txt");
		System.out.println(absolute);
		
		Path basePath = Paths.get("D:", "demo");
		Path workRelative = Paths.get("work");
		Path workPath = basePath.resolve("work");
		System.out.println(workPath);
		Path tempPath = workPath.resolveSibling("temp");
		System.out.println(tempPath);
		Path  relativePath = workPath.relativize(tempPath);
		System.out.println("relativePath=" + relativePath);
		Path  relativePath2 = tempPath.relativize(workPath);
		System.out.println("relativePath2=" + relativePath2);
		Path  relativePath3 = tempPath.relativize(basePath);
		System.out.println("relativePath3=" + relativePath3);
		
		System.out.println(basePath.resolve(tempPath));
		System.out.println(tempPath.resolve(basePath));
	}
	
	
}
