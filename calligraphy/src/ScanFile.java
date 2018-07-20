import java.util.Scanner;

public class ScanFile extends Calligraphy {

	public static void scanFile() throws Exception {

		Scanner in = new Scanner(file);

		String y = "";

		while (in.hasNext()) {
			String s = in.nextLine();

			y = y + s + "\n";

		}

		ta.setText(y);

		in.close();

	}

}
