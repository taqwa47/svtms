package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Image08 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title with emoji
        Label title = new Label("Share Data\nwith Insurance ✅");
        title.setFont(new Font("Arial", 26));
        title.setAlignment(Pos.CENTER);

        // Share Data Button
        Button shareButton = new Button("Share Data");
        shareButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white; -fx-font-size: 14;");
        shareButton.setPrefWidth(200);

        // Description
        Label infoText = new Label("Sensitive information will be\nprotected and securely transmitted.");
        infoText.setFont(new Font("Arial", 14));
        infoText.setWrapText(true);
        infoText.setAlignment(Pos.CENTER);

        // Bullet Points
        Label point1 = new Label("• Diagnostics");
        point1.setFont(new Font("Arial", 14));

        Label point2 = new Label("• Alerts");
        point2.setFont(new Font("Arial", 14));

        Label point3 = new Label("• Maintenance Logs");
        point3.setFont(new Font("Arial", 14));

        // Footer Note
        Label footerNote = new Label("Sensitive information will be protected\nand securely transmitted.");
        footerNote.setFont(new Font("Arial", 12));
        footerNote.setTextFill(Color.GRAY);
        footerNote.setAlignment(Pos.CENTER);

        // Layout
        VBox vbox = new VBox(20, title, shareButton, infoText, point1, point2, point3, footerNote);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));

        // Scene
        Scene scene = new Scene(vbox, 400, 500);
        primaryStage.setTitle("Share Data");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
}
}