import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javafx.stage.FileChooser;

public class LaunchSave extends Calligraphy {

	public static void launchSave() {

		FileChooser filechooser = new FileChooser();
		
		file = filechooser.showSaveDialog(stage);
		
		try {
			
			if(file != null) {
			PrintWriter outStream = new PrintWriter(file);

			outStream.write(ta.getText());
			outStream.close();
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public static void Save() {

		System.out.println(file);

		if (file != null)
			try {
				PrintWriter outStream = new PrintWriter(file);

				outStream.write(ta.getText());
				outStream.close();

			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}

	}

}
