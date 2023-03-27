package eighthlesson;

import java.io.File;

public class TaskThree {

	public static void main(String[] args) {
		printFolderNames(".");
	}

	public static void printFolderNames(String folderName) {
		File folder = new File(folderName);
		int counter = 0;
		System.out.println("У дректорії " + folder.getAbsolutePath() + " знаходяться наступні директорії:");
		File[] folderElements = folder.listFiles();
		for (int i = 0; i < folderElements.length; i++) {
			if (folderElements[i].isDirectory()) {
				System.out.println(folderElements[i].getName());
				counter++;
			}
		}
		if (counter <= 0) {
			System.out.println("У вказаній директорії немає інших директорій");
		}
	}
}