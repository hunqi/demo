package path_files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author ray.sun
 *
 */
public class FilesTest {
	
	@Test
	public void test4() throws IOException{
		FileSystem fs = FileSystems.newFileSystem(Paths.get("files.zip"), null);
		Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>(){
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file);
				Scanner in = new Scanner(Files.newInputStream(file));
				while(in.hasNext()){
					System.out.println(in.nextLine());
				}
				return FileVisitResult.CONTINUE;
			}
		});
		
	}
	
	@Ignore
	@Test
	public void test3() throws IOException{
		Path path = Paths.get("test.txt");
		Files.copy(path, Paths.get("test-copy.txt"));
	}
	

	@Ignore
	@Test
	public void test2() throws IOException {
		Path path = Paths.get("D:", "demo", "files", "logs.jsonl");
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(path.toFile()), "UTF-8"));
		String line = null;
		while((line = in.readLine()) != null){
			System.out.println(line);
		}
	}

	@Ignore
	@Test
	public void test1() throws IOException {
		Path path = Paths.get("D:", "demo", "files", "employee.txt");

		byte[] bytes = Files.readAllBytes(path);

		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		for (String l : lines) {
			System.out.println(l);
		}

		Files.write(path, "王五 男 23\n".getBytes(StandardCharsets.UTF_8));
		Files.write(path, "张三 男 22\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
		Files.write(path, "李四 男 26\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

		List<String> newLines = Arrays.asList("张三 男 22", "李四 男 26", "王五 男 23", "赵六 男 29");
		Files.write(path, newLines);

	}

}
