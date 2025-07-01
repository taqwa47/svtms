package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Image06 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title
        Label title = new Label("View Maintenance History");
        title.setFont(new Font("Arial", 26));

        // Driver Name
        Label driverLabel = new Label("Driver: User");
        driverLabel.setFont(new Font("Arial", 18));

        // Vehicle ID Input
        Label vehicleIdLabel = new Label("Vehicle ID:");
        vehicleIdLabel.setFont(new Font("Arial", 18));

        TextField vehicleIdField = new TextField();
        vehicleIdField.setPromptText("Enter Vehicle ID");

        // Maintenance History Title
        Label historyTitle = new Label("Maintenance History");
        historyTitle.setFont(new Font("Arial", 20));

        // Table
        TableView<String[]> table = new TableView<>();
        table.setPrefHeight(200);

        TableColumn<String[], String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()[0]));

        TableColumn<String[], String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()[1]));

        TableColumn<String[], String> mechanicColumn = new TableColumn<>("Mechanic");
        mechanicColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()[2]));

        TableColumn<String[], String> detailsColumn = new TableColumn<>("Details");
        detailsColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()[3]));

        table.getColumns().addAll(dateColumn, typeColumn, mechanicColumn, detailsColumn);

        // Sample data
        table.getItems().addAll(
                new String[]{"03/08/2023", "Oil Change", "J. Smith", "Auto Repair"},
                new String[]{"11/22/2022", "Brake Service", "D. Miller", "Downtown Garage"},
                new String[]{"07/15/2022", "Engine Repair", "R. Clark", "City Auto Service"}
        );

        // Export Button
        Button exportButton = new Button("Export");
        exportButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white; -fx-font-size: 14;");
        exportButton.setPrefWidth(200);

        // Layout
        VBox vbox = new VBox(20, title, driverLabel, vehicleIdLabel, vehicleIdField, historyTitle, table, exportButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));

        // Scene
        Scene scene = new Scene(vbox, 600, 600);
        primaryStage.setTitle("Maintenance History");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
}
}