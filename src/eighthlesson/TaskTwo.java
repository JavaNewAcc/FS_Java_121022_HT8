package eighthlesson;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskTwo {

	public static void main(String[] args) {
		int[][] array = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Scanner scan = new Scanner(System.in);
		System.out.println("Введіть формат файлу для збереження данних (txt або csv):");
		String fileFormat = scan.nextLine().toLowerCase();

		saveArrayToFile(array, fileFormat);
	}

	public static void saveArrayToFile(int[][] array, String fileFormat) {
		File file = new File("Array." + fileFormat);
		String separator = ",";
		try (PrintWriter pw = new PrintWriter(file)) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					pw.print(array[i][j]);
					if (!(i == array.length - 1 && j == array[i].length - 1)) {
						pw.print(separator);
					}
				}
				pw.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}