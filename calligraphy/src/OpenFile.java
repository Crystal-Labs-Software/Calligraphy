import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.stage.FileChooser;

public class OpenFile extends Calligraphy {

	public void openFile() {

		FileChooser filechooser = new FileChooser();
		file = filechooser.showOpenDialog(stage);

		ta.clear();

		try {
			if (file != null) {
				Scanner input = new Scanner(file);

				while (input.hasNext()) {
					ta.appendText(input.nextLine() + '\n');
				}
				input.close();
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
}
