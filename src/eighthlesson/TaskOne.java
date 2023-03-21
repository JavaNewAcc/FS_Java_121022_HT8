package eighthlesson;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskOne {

	public static void main(String[] args) {
		boolean checkResult = false;
		String fileName = "";
		File workFolder = new File(".");
		Scanner scan = new Scanner(System.in);

		while (!checkResult) {
			System.out.println(
					"Введіть назву текстового файлу без розширення (назва може складатись лише з латинських букв або цифр):");
			fileName = scan.nextLine();
			checkResult = checkFileName(fileName);
		}
		createFile(fileName);
		System.out.println("В каталозі є наступні текстові файли:");
		findTXTfiles(workFolder);
		System.out.println(
				"Введіть назву існуючого файла (без розширення), або введіть назву нового файлу для збереження данних:");
		fileName = scan.nextLine();
		editFileContent(fileName);
	}

	public static void createFile(String name) {
		name += ".txt";
		File textEditor = new File(name);
		try {
			textEditor.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkFileName(String name) {
		char[] charArr = name.toLowerCase().toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			if (!(charArr[i] >= '0' && charArr[i] <= '9' || charArr[i] >= 'a' && charArr[i] <= 'z')) {
				return false;
			}
		}
		return true;
	}

	public static void findTXTfiles(File workFolder) {
		int counter = 0;
		File[] files = workFolder.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				if (files[i].getName().contains(".txt")) {
					System.out.println(files[i].getName());
					counter++;
				}
			}
		}
		if (counter == 0) {
			System.out.println("В обраному каталозі немає текстових файлів");
		}
	}

	public static void editFileContent(String name) {
		name += ".txt";
		System.out.println("Введіть данні:");
		Scanner scan = new Scanner(System.in);
		File file = new File(name);
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(scan.nextLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}