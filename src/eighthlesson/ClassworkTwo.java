package eighthlesson;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class ClassworkTwo {

	public static void main(String[] args) {
		File file = new File("Report.csv");
		String[] names = new String[] { "Oreo", "Tik-tak", "Snickers", "Bonaqua" };
		int[] quantity = new int[] { 50, 60, 45, 30 };
		int[] price = new int[] { 20, 30, 50, 20 };
		String separator = ",";
		saveToCSVfile(file, names, quantity, price, separator);
	}

	public static void saveToCSVfile(File file, String[] name, int[] qtty, int[] price, String separator) {
		try (PrintWriter pw = new PrintWriter(file)) {
			for (int i = 0; i < name.length; i++) {
				pw.println(name[i] + separator + qtty[i] + separator + price[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}