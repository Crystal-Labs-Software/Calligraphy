import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Rectangle;

public class Preferences extends Calligraphy {

	static Text text2 = new Text("Background Color");
	static Text text3 = new Text("Border Color");
	static Text text4 = new Text("Font Color");
	static Text text5 = new Text("Font Size");
	static Text text6 = new Text("Font Style");
	static Text sbg = new Text("Background");
	static Text sfc = new Text("Font Color");
	static Text sbc = new Text("Border Color");

	public static void Pref() {

		Rectangle rectRed = new Rectangle();
		rectRed.setFill(Color.rgb(255, 0, 0));
		rectRed.setHeight(40);
		rectRed.setWidth(40);
		sfc.setStyle("-fx-stroke: " + fc + ";");

		Rectangle rectBlue = new Rectangle();
		rectBlue.setFill(Color.rgb(0, 255, 0));
		rectBlue.setHeight(40);
		rectBlue.setWidth(40);

		Rectangle rectGreen = new Rectangle();
		rectGreen.setFill(Color.rgb(0, 0, 255));
		rectGreen.setHeight(40);
		rectGreen.setWidth(40);

		Rectangle rectBlack = new Rectangle();
		rectBlack.setFill(Color.rgb(0, 0, 0));
		rectBlack.setHeight(40);
		rectBlack.setWidth(40);

		Rectangle rectWhite = new Rectangle();
		rectWhite.setFill(Color.rgb(255, 255, 255));
		rectWhite.setHeight(40);
		rectWhite.setWidth(40);

		Rectangle rectGray1 = new Rectangle();
		rectGray1.setFill(Color.rgb(34, 34, 34));
		rectGray1.setHeight(40);
		rectGray1.setWidth(40);

		Rectangle rectGray2 = new Rectangle();
		rectGray2.setFill(Color.rgb(64, 64, 64));
		rectGray2.setHeight(40);
		rectGray2.setWidth(40);

		Rectangle rectGray3 = new Rectangle();
		rectGray3.setFill(Color.rgb(136, 136, 136));
		rectGray3.setHeight(40);
		rectGray3.setWidth(40);

		Rectangle rectGray4 = new Rectangle();
		rectGray4.setFill(Color.rgb(170, 170, 170));
		rectGray4.setHeight(40);
		rectGray4.setWidth(40);

		Rectangle rectNavy = new Rectangle();
		rectNavy.setFill(Color.rgb(2, 0, 32));
		rectNavy.setHeight(40);
		rectNavy.setWidth(40);

		Rectangle rectMagenta = new Rectangle();
		rectMagenta.setFill(Color.rgb(255, 0, 255));
		rectMagenta.setHeight(40);
		rectMagenta.setWidth(40);

		Rectangle rectPurple = new Rectangle();
		rectPurple.setFill(Color.rgb(128, 0, 128));
		rectPurple.setHeight(40);
		rectPurple.setWidth(40);

		Rectangle rectAqua = new Rectangle();
		rectAqua.setFill(Color.rgb(0, 255, 255));
		rectAqua.setHeight(40);
		rectAqua.setWidth(40);

		Rectangle rectYellow = new Rectangle();
		rectYellow.setFill(Color.rgb(255, 255, 0));
		rectYellow.setHeight(40);
		rectYellow.setWidth(40);

		Rectangle rectOrange = new Rectangle();
		rectOrange.setFill(Color.rgb(255, 165, 0));
		rectOrange.setHeight(40);
		rectOrange.setWidth(40);

		GridPane gp = new GridPane();
		gp.setVgap(5);
		gp.setHgap(5);
		gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");

		gp.setPadding(new Insets(10, 10, 10, 10));

		TextField tfBackground = new TextField(bg);
		TextField tfBorderColor = new TextField(bc);
		TextField tfFontColor = new TextField(fc);
		TextField tfFontSize = new TextField(fs);
		TextField tfFontStyle = new TextField(ft);

		paint();

		Button btnSave = new Button("Save");

		Button btnClose = new Button("Close");

		RadioButton rb1 = new RadioButton();
		rb1.setSelected(true);

		RadioButton rb2 = new RadioButton();

		RadioButton rb3 = new RadioButton();

		ToggleGroup tg = new ToggleGroup();

		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb3.setToggleGroup(tg);

		gp.add(rectRed, 3, 0);
		rectRed.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#ff0000");
			else if (rb3.isSelected())
				tfBorderColor.setText("#ff0000");
			else
				tfFontColor.setText("#ff0000");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(rectBlue, 3, 1);
		rectBlue.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#00ff00");
			else if (rb3.isSelected())
				tfBorderColor.setText("#00ff00");
			else
				tfFontColor.setText("#00ff00");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(rectGreen, 3, 2);
		rectGreen.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#0000ff");
			else if (rb3.isSelected())
				tfBorderColor.setText("#0000ff");
			else
				tfFontColor.setText("#0000ff");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(rectBlack, 3, 4);
		rectBlack.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#000000");
			else if (rb3.isSelected())
				tfBorderColor.setText("#000000");
			else
				tfFontColor.setText("#000000");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(rectOrange, 4, 0);
		rectOrange.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#ffa500");
			else if (rb3.isSelected())
				tfBorderColor.setText("#ffa500");
			else
				tfFontColor.setText("#ffa500");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(rectYellow, 4, 1);
		rectYellow.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#ffff00");
			else if (rb3.isSelected())
				tfBorderColor.setText("#ffff00");
			else
				tfFontColor.setText("#ffff00");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(rectPurple, 3, 3);
		rectPurple.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#800080");
			else if (rb3.isSelected())
				tfBorderColor.setText("#800080");
			else
				tfFontColor.setText("#800080");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(rectAqua, 4, 3);
		rectAqua.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#00ffff");
			else if (rb3.isSelected())
				tfBorderColor.setText("#00ffff");
			else
				tfFontColor.setText("#00ffff");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(rectMagenta, 4, 2);
		rectMagenta.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#ff00ff");
			else if (rb3.isSelected())
				tfBorderColor.setText("#ff00ff");
			else
				tfFontColor.setText("#ff00ff");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(rectWhite, 4, 4);
		rectWhite.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#ffffff");
			else if (rb3.isSelected())
				tfBorderColor.setText("#ffffff");
			else
				tfFontColor.setText("#ffffff");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(rectGray1, 5, 0);
		rectGray1.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#222222");
			else if (rb3.isSelected())
				tfBorderColor.setText("#222222");
			else
				tfFontColor.setText("#222222");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});
		gp.add(rectGray2, 5, 1);
		rectGray2.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#444444");
			else if (rb3.isSelected())
				tfBorderColor.setText("#444444");
			else
				tfFontColor.setText("#444444");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});
		gp.add(rectGray3, 5, 2);
		rectGray3.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#888888");
			else if (rb3.isSelected())
				tfBorderColor.setText("#888888");
			else
				tfFontColor.setText("#888888");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});
		gp.add(rectGray4, 5, 3);
		rectGray4.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#aaaaaa");
			else if (rb3.isSelected())
				tfBorderColor.setText("#aaaaaa");
			else
				tfFontColor.setText("#aaaaaa");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});
		gp.add(rectNavy, 5, 4);
		rectNavy.setOnMouseClicked(e -> {
			if (rb1.isSelected())
				tfBackground.setText("#020020");
			else if (rb3.isSelected())
				tfBorderColor.setText("#020020");
			else
				tfFontColor.setText("#020020");
			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		gp.add(text2, 0, 0);
		gp.add(text3, 0, 1);
		gp.add(rb1, 6, 0);
		gp.add(sbg, 7, 0);
		gp.add(rb2, 6, 1);
		gp.add(sfc, 7, 1);
		gp.add(rb3, 6, 2);
		gp.add(sbc, 7, 2);
		gp.add(text4, 0, 2);
		gp.add(text5, 0, 3);
		gp.add(text6, 0, 4);

		gp.add(tfBackground, 1, 0);
		gp.add(tfBorderColor, 1, 1);
		gp.add(tfFontColor, 1, 2);
		gp.add(tfFontSize, 1, 3);
		gp.add(tfFontStyle, 1, 4);
		gp.add(btnSave, 1, 5);
		gp.add(btnClose, 0, 5);

		Stage window = new Stage();

		window.setResizable(false);

		Scene scene = new Scene(gp, 600, 270);

		window.initModality(Modality.WINDOW_MODAL);
		window.initOwner(stage);
		window.setTitle("Open");
		window.setScene(scene);
		window.show();

		btnSave.setOnAction(e -> {

			bg = tfBackground.getText();
			bc = tfBorderColor.getText();
			fc = tfFontColor.getText();
			fs = tfFontSize.getText();
			ft = tfFontStyle.getText();
			ta.setStyle("-fx-control-inner-background:" + bg + "; -fx-text-fill: " + fc + "; -fx-font-size: " + fs
					+ "; -fx-font-family: '" + ft + "'; -fx-border-color: " + bc + "; -fx-border-width: 10px;");
			gp.setStyle("-fx-background-color: " + bg + "; -fx-border-color: " + bc + ";");
			paint();

			try {
				writeConfigs();
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			}
		});

		btnClose.setOnAction(e -> {
			window.close();
		});

	}

	public static void paint() {

		sbg.setStyle("-fx-stroke: " + fc + ";");
		sfc.setStyle("-fx-stroke: " + fc + ";");
		sbc.setStyle("-fx-stroke: " + fc + ";");
		text2.setStyle("-fx-stroke: " + fc + ";");
		text3.setStyle("-fx-stroke: " + fc + ";");
		text4.setStyle("-fx-stroke: " + fc + ";");
		text5.setStyle("-fx-stroke: " + fc + ";");
		text6.setStyle("-fx-stroke: " + fc + ";");
	}

	public static void writeConfigs() throws FileNotFoundException {

		y = "BackGround=" + bg + "\nBorderColor=" + bc + "\nFontColor=" + fc + "\nFontSize=" + fs + "\nFontType=" + ft;

		PrintWriter output = new PrintWriter(config);
		output.print(y);

		output.close();

	}

}
