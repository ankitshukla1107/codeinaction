import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrepSolution {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("abc.txt");
		Scanner input = new Scanner(file);
		while(input.hasNext()) {
			searchAndPrint(input.next(), "test");
		}

	}
	
	public static void searchAndPrint(String line, String pivot) {
		if(line.contains(pivot)) {
			
		}else {
			
		}
	}
	


}
