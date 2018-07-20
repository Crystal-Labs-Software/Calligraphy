import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.application.Platform;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import javafx.scene.control.RadioMenuItem;

public class Calligraphy extends Application {

	static Stage stage = new Stage();
	static String bg = "#000000", bc = "#00ffff", fc = "#00ffff", fs = "20", ft = "Sans";
	static File file = new File("");
	static File config;
	static TextArea ta = new TextArea();
	static String y = "";

	@Override
	public void start(Stage arg0) throws Exception {

		OpenFile openfile = new OpenFile();

		BorderPane pane = new BorderPane();

		currentpath();

		defaults();

		ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
				+ "; -fx-font-family: " + ft + "; -fx-border-color: " + bc + "; -fx-border-width: 10px;");

		ta.setPadding(new Insets(-10, -10, -10, -10));

		MenuBar menuBar = new MenuBar();

		menuBar.setPadding(new Insets(2, 2, 2, 2));

		Menu menu1 = new Menu("File");
		Menu menu2 = new Menu("Options");
		Menu menu3 = new Menu("Help");

		MenuItem mi0 = new MenuItem("New");
		MenuItem mi1 = new MenuItem("Open");
		MenuItem mi2 = new MenuItem("Save");
		MenuItem mi3 = new MenuItem("Save As");
		MenuItem mi4 = new MenuItem("Exit");

		MenuItem mi5 = new MenuItem("Preferences");
		RadioMenuItem mi6 = new RadioMenuItem("Word Wrap");
		
		MenuItem mi7 = new MenuItem("Feedback");
		MenuItem mi8 = new MenuItem("About");

		menu1.getItems().addAll(mi0, mi1, mi2, mi3, mi4);
		menu2.getItems().addAll(mi5, mi6);
		menu3.getItems().addAll(mi7, mi8);
		menuBar.getMenus().addAll(menu1, menu2, menu3);

		pane.setTop(menuBar);
		pane.setCenter(ta);

		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.F11 && stage.isFullScreen() != true)
				stage.setFullScreen(true);
			else if (e.getCode() == KeyCode.F11 && stage.isFullScreen() == true)
				stage.setFullScreen(false);
			if (e.getCode() == KeyCode.F12 && pane.getTop() != null)
				pane.setTop(null);
			else if (e.getCode() == KeyCode.F12 && pane.getTop() == null)
				pane.setTop(menuBar);
		});

		Scene scene = new Scene(pane, 600, 600);

		stage.setTitle("Calligraphy");
		stage.setScene(scene);
		stage.show();

		pane.requestFocus();

		mi0.setOnAction(e -> {

			new SavePrompt().getPane();

		});
		mi1.setOnAction(e -> {
			openfile.openFile();
		});
		mi2.setOnAction(e -> {
			if (file != null && file.exists())
				LaunchSave.Save();
			else
				LaunchSave.launchSave();
		});
		mi3.setOnAction(e -> {
			LaunchSave.launchSave();
		});
		mi4.setOnAction(e -> {
			exit();
		});
		mi5.setOnAction(e -> {
			Preferences.Pref();
		});

		mi6.setOnAction(e -> {
			if (ta.isWrapText() == false)
				ta.setWrapText(true);
			else
				ta.setWrapText(false);
		});
		
		mi7.setOnAction(e ->{
						
			Desktop desktop = Desktop.getDesktop();  
			            String url = "";  
			            URI mailTo;  
			            try {  
			                 url = "mailTo:aaron@gmail.com" + "?subject=" + "FEEDBACK" 
			                           + "&body=" + "Aaron";  
			                 mailTo = new URI(url);  
			                 desktop.mail(mailTo);  
			            } catch (URISyntaxException e2) {  
			                 e2.printStackTrace();  
			            } catch (IOException e2) {  
			                 e2.printStackTrace();  
			            }  
			
		});
		
		mi8.setOnAction(e -> {
			
			TextArea tx = new TextArea("Calligraphy is a customizable text editor.\r\n" + 
					"\r\n" + 
					"HotKeys\r\n" + 
					"\r\n" + 
					"    F11 Full screen.\r\n" + 
					"\r\n" + 
					"    F12 Hide Menubar\r\n" + 
					"");
			StackPane sp = new StackPane();
			tx.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + ";");
			sp.getChildren().add(tx);
			Stage window = new Stage();

			window.setResizable(false);

			Scene scene2 = new Scene(sp, 600, 270);

			window.initModality(Modality.WINDOW_MODAL);
			window.initOwner(stage);
			window.setTitle("Open");
			window.setScene(scene2);
			window.show();
			
		});
	}

	public static void exit() {

		Platform.exit();
		System.exit(0);
	}

	public static void currentpath() {

		String dir = System.getProperty("user.dir");

		config = new File(dir + "/calligraphy.config");

		if (!config.exists())
			try {
				PrintWriter outStream = new PrintWriter(config);

				outStream.write(ta.getText());
				outStream.close();

			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
	}

	public static void defaults() throws Exception {

		Scanner in = new Scanner(config);

		while (in.hasNext()) {
			String s = in.nextLine();

			y = y + s + "\n";

		}

		if (y.contains("BackGround="))
			bg = y.substring(y.indexOf("BackGround=") + 11, y.indexOf("BackGround=") + 18);

		if (y.contains("BorderColor="))
			bc = y.substring(y.indexOf("BorderColor=") + 12, y.indexOf("BorderColor=") + 19);

		if (y.contains("FontColor="))
			fc = y.substring(y.indexOf("FontColor=") + 10, y.indexOf("FontColor=") + 17);

		if (y.contains("FontSize="))
			fs = y.substring(y.indexOf("FontSize=") + 9, y.indexOf("FontSize=") + 12);

		if (y.contains("FontType="))
			ft = y.substring(y.indexOf("FontType=") + 9);

		in.close();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
