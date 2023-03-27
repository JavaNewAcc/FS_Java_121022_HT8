package add.task.one;

import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class AddTaskOne {

	public static void main(String[] args) {
		String text;
		char[] charArr = charArrayFiller('a', 'z');
		int[] counterArr = new int[charArr.length];
		System.out.println("Введіть текст для підрахунку кількості повторів кожної літери та натисніть Enter:");
		Scanner scan = new Scanner(System.in);
		text = scan.nextLine();
		letterCounter(charArr, counterArr, text);
		arraySorter(charArr, counterArr);
		printToFile(charArr, counterArr, "Results.txt");
	}

	public static char[] charArrayFiller(char firstChar, char lastChar) {
		int arrLength = lastChar - firstChar + 1;
		char[] charArr = new char[arrLength];

		for (int i = 0; i < arrLength; i++) {
			charArr[i] = (char) (firstChar + i);
		}
		return charArr;
	}

	public static void letterCounter(char[] charArr, int[] counterArr, String text) {
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < charArr.length; j++) {
				if (text.charAt(i) == charArr[j]) {
					counterArr[j]++;
					continue;
				}
			}
		}
	}

	public static void arraySorter(char[] charArr, int[] counterArr) {
		char tempChar;
		int tempCounter;
		for (int i = counterArr.length - 1; i > 0; i--) {
			for (int j = counterArr.length - 1 - i; j > 0; j--) {
				if (counterArr[j] > counterArr[j - 1]) {
					tempCounter = counterArr[j];
					counterArr[j] = counterArr[j - 1];
					counterArr[j - 1] = tempCounter;
					tempChar = charArr[j];
					charArr[j] = charArr[j - 1];
					charArr[j - 1] = tempChar;
				}
			}
		}
	}

	public static void printToFile(char[] charArr, int[] counterArr, String fileName) {
		try (PrintWriter pw = new PrintWriter(fileName);) {
			pw.println("Буква: кількість повторів");
			for (int i = 0; i < charArr.length; i++) {
				if (counterArr[i] > 0) {
					pw.println(charArr[i] + ": " + counterArr[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
