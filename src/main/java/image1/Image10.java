package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Image10 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title
        Label title = new Label("System Monitor");
        title.setFont(new Font("Arial", 26));
        title.setAlignment(Pos.CENTER);

        // Filter section
        ComboBox<String> userTypeComboBox = new ComboBox<>();
        userTypeComboBox.getItems().addAll("Mechanical", "Driver");
        userTypeComboBox.setPromptText("User Type");

        ComboBox<String> errorTypeComboBox = new ComboBox<>();
        errorTypeComboBox.getItems().addAll("Is not connected");
        errorTypeComboBox.setPromptText("Error Type");

        Button applyButton = new Button("Apply");
        applyButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white; -fx-font-size: 14;");
        applyButton.setPrefWidth(200);

        HBox filterBox = new HBox(10, userTypeComboBox, errorTypeComboBox);
        filterBox.setAlignment(Pos.CENTER);

        VBox filterSection = new VBox(10, filterBox, applyButton);
        filterSection.setAlignment(Pos.CENTER);

        // Event Logs Title
        Label logsTitle = new Label("Event Logs");
        logsTitle.setFont(new Font("Arial", 20));
        logsTitle.setAlignment(Pos.CENTER);

        // Event Logs Table
        TableView<String[]> eventLogsTable = new TableView<>();
        eventLogsTable.setPrefHeight(200);

        TableColumn<String[], String> timeColumn = new TableColumn<>("Time");
        timeColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()[0]));

        TableColumn<String[], String> eventColumn = new TableColumn<>("Event");
        eventColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue()[1]));

        eventLogsTable.getColumns().addAll(timeColumn, eventColumn);

        // Sample data
        eventLogsTable.getItems().addAll(
                new String[]{"06/10/2023 03:20 PM", "Repeated Fault Detected"},
                new String[]{"06/10/2023 09:17 AM", "User Login (Admin)"},
                new String[]{"07/09/2023 11:45 AM", "Error – Database Connection"}
        );

        // Download Button
        Button downloadButton = new Button("Download Logs");
        downloadButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white; -fx-font-size: 14;");
        downloadButton.setPrefWidth(200);

        // Layout
        VBox vbox = new VBox(20, title, filterSection, logsTitle, eventLogsTable, downloadButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(30));

        // Scene
        Scene scene = new Scene(vbox, 600, 600);
        primaryStage.setTitle("System Monitor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
}
}