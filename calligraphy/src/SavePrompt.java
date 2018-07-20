import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class SavePrompt extends Calligraphy {

	Stage stage = new Stage();
	Text text = new Text();
	Button save = new Button("Save");
	Button discard = new Button("Discard");

	public GridPane getPane() {

		GridPane pane = new GridPane();

		pane.setAlignment(Pos.CENTER);
		pane.setHgap(20);

		text.setText("Save Current Project?");
		text.setStyle("-fx-stroke: " + fc + ";");

		pane.add(text, 0, 0);
		pane.add(discard, 1, 0);
		pane.add(save, 2, 0);

		pane.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");

		Scene scene = new Scene(pane, 400, 100);

		stage.setScene(scene);

		stage.show();

		save.setOnAction(e -> {

			if (file != null && file.exists())
				LaunchSave.Save();
			else
				LaunchSave.launchSave();

			if (!ta.getText().trim().isEmpty()) {
				ta.clear();
				if (file.exists())
					file = new File("");
			}
			stage.close();

		});

		discard.setOnAction(e -> {

			if (!ta.getText().trim().isEmpty()) {
				ta.clear();
				if (file.exists())
					file = new File("");
				stage.close();
			}

			stage.close();

		});

		return pane;
	}

}
