package eighthlesson;

import java.io.File;
import java.io.IOException;

public class ClassworkOne {

	public static void main(String[] args) {
		File file1 = new File("test.txt");

		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File folder1 = new File("ABC");

		folder1.mkdirs();

		File file2 = new File(folder1, "ttt.docx");

		try {
			file2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		file1.delete();
		file2.delete();
		folder1.delete();

		File workFolder = new File(".");

		File[] files = workFolder.listFiles();
		for (int i = 0; i < files.length; i++) {

			String type = "File";
			if (files[i].isDirectory()) {
				type = "Folder";
			}

			System.out.println(files[i] + "   " + type + "   " + files[i].length());
		}

	}

}
