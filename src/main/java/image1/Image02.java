package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;

public class Image02 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main Title
        Label title = new Label("Vehicle Status");
        title.setFont(new Font("Arial", 30));

        // Car Name
        Label carName = new Label("User's Car");
        carName.setFont(new Font("Arial", 20));

        // Grid for Status Items
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        // Status Labels
        Label speed = createStatusBox("🚗 Speed", "50 km/h");
        Label fuel = createStatusBox("⛽ Fuel Level", "Full");
        Label oilTemp = createStatusBox("🌡 Oil Temp.", "90°C");
        Label battery = createStatusBox("🔋 Battery Life", "85%");
        Label tirePressure = createStatusBox("⚙ Tire Pressure", "34 psi");
        Label lights = createStatusBox("💡 Lights", "Off");
        Label engine = createStatusBox("🛠 Engine", "Running");
        Label maintenance = createStatusBox("🔧 Maintenance","Due");


        // Add to Grid
        grid.add(speed, 0, 0);
        grid.add(fuel, 1, 0);
        grid.add(oilTemp, 0, 1);
        grid.add(battery, 1, 1);
        grid.add(tirePressure, 0, 2);
        grid.add(lights, 1, 2);
        grid.add(engine, 0, 3);
        grid.add(maintenance, 1, 3);

        // Layout
        VBox vbox = new VBox(20, title, carName, grid);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));

        // Scene
        Scene scene = new Scene(vbox, 500, 600);
        primaryStage.setTitle("Vehicle Status");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create a styled status box
    private Label createStatusBox(String title, String value) {
        Label label = new Label(title + "\n" + value);
        label.setFont(new Font("Arial", 16));
        label.setAlignment(Pos.CENTER);
        label.setPrefSize(150, 60);
        label.setPadding(new Insets(10));
        label.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
        return label;
    }

    public static void main(String[] args) {
        launch(args);
}
}