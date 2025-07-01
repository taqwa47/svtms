import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Image05 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main Title
        Label title = new Label("Request Diagnostics");
        title.setFont(new Font("Arial", 26));

        // Vehicle "Image" Placeholder with Emoji
        Label vehicleImage = new Label("🚗 ⚠");
        vehicleImage.setFont(new Font("Arial", 80));

        // Vehicle ID Input
        Label vehicleIdLabel = new Label("Vehicle ID:");
        vehicleIdLabel.setFont(new Font("Arial", 18));

        TextField vehicleIdField = new TextField();
        vehicleIdField.setPromptText("Enter Vehicle ID");

        // Description Text
        Label description = new Label("Retrieve diagnostic data for the vehicle,\nincluding current faults, sensor values,\nand system alerts.");
        description.setFont(new Font("Arial", 14));
        description.setWrapText(true);
        description.setAlignment(Pos.CENTER);

        // Request Button
        Button requestButton = new Button("Request Diagnostics");
        requestButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white; -fx-font-size: 14;");
        requestButton.setPrefWidth(200);

        // Layout
        VBox vbox = new VBox(20, title, vehicleImage, vehicleIdLabel, vehicleIdField, description, requestButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));

        // Scene
        Scene scene = new Scene(vbox, 400, 500);
        primaryStage.setTitle("Request Diagnostics");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
}
}