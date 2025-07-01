package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.chart.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FinalProject extends Application {

    Stage window;

    // Scenes
    Scene mainMenu, vehicleStatusScene, scheduleScene, alertScene, requestDiagnosticsScene, maintenanceHistoryScene, predictiveAnalyticsScene, shareDataScene, problemReportScene, systemMonitorScene, vehicleAccessScene;

    // Shared Data
    String requestedVehicleId = "";
    String requestedReason = "";

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        // === Main Menu ===
        Button btnVehicleStatus = new Button("Vehicle Status");
        Button btnSchedule = new Button("Schedule Maintenance");
        Button btnCriticalAlert = new Button("Critical Alert");
        Button btnRequestDiagnostics = new Button("Request Diagnostics");
        Button btnMaintenanceHistory = new Button("Maintenance History");
        Button btnPredictiveAnalytics = new Button("Predictive Analytics");
        Button btnShareData = new Button("Share Data with Insurance");
        Button btnProblemReport = new Button("Submit Problem Report");
        Button btnSystemMonitor = new Button("System Monitor");
        Button btnVehicleAccess = new Button("Request Vehicle Access");

        VBox menuLayout = new VBox(15, btnVehicleStatus, btnSchedule, btnCriticalAlert, btnRequestDiagnostics, btnMaintenanceHistory, btnPredictiveAnalytics, btnShareData, btnProblemReport, btnSystemMonitor, btnVehicleAccess);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setPadding(new Insets(20));

        mainMenu = new Scene(menuLayout, 600, 600);

        // === Build All Screens ===
        buildVehicleStatusScreen();
        buildScheduleScreen();
        buildAlertScreen();
        buildRequestDiagnosticsScreen();
        buildMaintenanceHistoryScreen();
        buildPredictiveAnalyticsScreen();
        buildShareDataScreen();
        buildProblemReportScreen();
        buildSystemMonitorScreen();
        buildVehicleAccessScreen();

        // === Button Actions ===
        btnVehicleStatus.setOnAction(e -> window.setScene(vehicleStatusScene));
        btnSchedule.setOnAction(e -> window.setScene(scheduleScene));
        btnCriticalAlert.setOnAction(e -> window.setScene(alertScene));
        btnRequestDiagnostics.setOnAction(e -> window.setScene(requestDiagnosticsScene));
        btnMaintenanceHistory.setOnAction(e -> window.setScene(maintenanceHistoryScene));
        btnPredictiveAnalytics.setOnAction(e -> window.setScene(predictiveAnalyticsScene));
        btnShareData.setOnAction(e -> window.setScene(shareDataScene));
        btnProblemReport.setOnAction(e -> window.setScene(problemReportScene));
        btnSystemMonitor.setOnAction(e -> window.setScene(systemMonitorScene));
        btnVehicleAccess.setOnAction(e -> window.setScene(vehicleAccessScene));

        // Show window
        window.setTitle("Full Vehicle Management System");
        window.setScene(mainMenu);
        window.show();
    }

    private void buildVehicleStatusScreen() {
        Label title = new Label("Vehicle Status 🚗");
        title.setFont(new Font("Arial", 26));

        Label carName = new Label("User's Car");
        carName.setFont(new Font("Arial", 20));

        VBox grid = new VBox(10,
                new Label("🚗 Speed: 50 km/h"),
                new Label("⛽ Fuel Level: Full"),
                new Label("🌡 Oil Temp: 90°C"),
                new Label("🔋 Battery Life: 85%"),
                new Label("⚙ Tire Pressure: 34 psi"),
                new Label("💡 Lights: Off"),
                new Label("🛠 Engine: Running"),
                new Label("🔧 Maintenance: Due")
        );

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainMenu));

        VBox layout = new VBox(20, title, carName, grid, back);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        vehicleStatusScene = new Scene(layout, 600, 500);
    }

    private void buildScheduleScreen() {
        Label title = new Label("Schedule Maintenance");
        title.setFont(new Font("Arial", 26));
        Label appointment = new Label("📅 Appointment");

        DatePicker datePicker = new DatePicker();
        TextField timeField = new TextField();
        timeField.setPromptText("Enter Time (e.g. 12:30)");

        TextField locationField = new TextField();
        locationField.setPromptText("Enter Location");

        Button confirm = new Button("Confirm");
        Button cancel = new Button("Cancel");
        confirm.setPrefWidth(100);
        cancel.setPrefWidth(100);

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainMenu));

        VBox layout = new VBox(15, title, appointment, datePicker, timeField, locationField, confirm, cancel, back);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        scheduleScene = new Scene(layout, 600, 500);
    }

    private void buildAlertScreen() {
        Label alertTitle = new Label("⚠ CRITICAL ALERT");
        alertTitle.setTextFill(Color.WHITE);
        alertTitle.setFont(new Font("Arial", 24));

        Label alertMsg = new Label("High engine temperature detected");
        alertMsg.setTextFill(Color.WHITE);

        Label vehicle = new Label("🚚 Truck 123");
        vehicle.setTextFill(Color.WHITE);

        Label alertTime = new Label("🕒 2024-04-24 14:30");
        alertTime.setTextFill(Color.WHITE);

        VBox layout = new VBox(15, alertTitle, alertMsg, vehicle, alertTime);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainMenu));
        layout.getChildren().add(back);

        alertScene = new Scene(layout, 600, 500);
    }

    private void buildRequestDiagnosticsScreen() {
        Label title = new Label("Request Diagnostics");
        title.setFont(new Font("Arial", 26));

        Label vehicleImage = new Label("🚗 ⚠");
        vehicleImage.setFont(new Font("Arial", 80));

        Label vehicleIdLabel = new Label("Vehicle ID:");
        TextField vehicleIdField = new TextField();
        vehicleIdField.setPromptText("Enter Vehicle ID");

        Label description = new Label("Retrieve diagnostic data for the vehicle,\nincluding current faults, sensor values,\nand system alerts.");
        description.setFont(new Font("Arial", 14));
        description.setWrapText(true);

        Button requestButton = new Button("Request Diagnostics");
        requestButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white;");
        requestButton.setPrefWidth(200);

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainMenu));

        VBox layout = new VBox(20, title, vehicleImage, vehicleIdLabel, vehicleIdField, description, requestButton, back);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        requestDiagnosticsScene = new Scene(layout, 600, 500);
    }

    private void buildMaintenanceHistoryScreen() {
        Label title = new Label("View Maintenance History");
        title.setFont(new Font("Arial", 26));

        Label driver = new Label("Driver: User");

        Label vehicleIdLabel = new Label("Vehicle ID:");
        TextField vehicleIdField = new TextField();
        vehicleIdField.setPromptText("Enter Vehicle ID");

        TableView<String[]> table = new TableView<>();
        table.setPrefHeight(200);

        TableColumn<String[], String> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue()[0]));

        TableColumn<String[], String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue()[1]));

        TableColumn<String[], String> mechanicCol = new TableColumn<>("Mechanic");
        mechanicCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue()[2]));

        TableColumn<String[], String> detailsCol = new TableColumn<>("Details");
        detailsCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue()[3]));

        table.getColumns().addAll(dateCol, typeCol, mechanicCol, detailsCol);

        table.getItems().addAll(
                new String[]{"03/08/2023", "Oil Change", "J. Smith", "Auto Repair"},
                new String[]{"11/22/2022", "Brake Service", "D. Miller", "Downtown Garage"},
                new String[]{"07/15/2022", "Engine Repair", "R. Clark", "City Auto Service"}
        );

        Button exportButton = new Button("Export");
        exportButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white;");
        exportButton.setPrefWidth(200);

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainMenu));

        VBox layout = new VBox(15, title, driver, vehicleIdLabel, vehicleIdField, table, exportButton, back);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        maintenanceHistoryScene = new Scene(layout, 600, 600);
    }

    private void buildPredictiveAnalyticsScreen() {
        Label title = new Label("Predictive Analytics");
        title.setFont(new Font("Arial", 26));
        title.setTextFill(Color.WHITE);

        VBox dataBox = new VBox(15,
                new Label("Recent Data\nData Entries: 1,479\nTracking Days: 180"),
                new Label("Future Predictions\nBrake Life: 12,000 mi\nBattery Replacement: May 2025\nOil Change: In 800 mi")
        );
        dataBox.setAlignment(Pos.CENTER_LEFT);

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainMenu));

        VBox layout = new VBox(20, title, dataBox, back);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        predictiveAnalyticsScene = new Scene(layout, 600, 500);
    }

    private void buildShareDataScreen() {
        Label title = new Label("Share Data with Insurance ✅");
        title.setFont(new Font("Arial", 26));
        title.setAlignment(Pos.CENTER);

        Button shareButton = new Button("Share Data");
        shareButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white;");
        shareButton.setPrefWidth(200);

        VBox layout = new VBox(15, title, shareButton,
                new Label("Sensitive information will be protected and securely transmitted."),
                new Label("• Diagnostics\n• Alerts\n• Maintenance Logs"),
                new Label("Sensitive information will be protected and securely transmitted.")
        );

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainMenu));
        layout.getChildren().add(back);

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        shareDataScene = new Scene(layout, 600, 500);
    }

    private void buildProblemReportScreen() {
        Label title = new Label("Submit Manual Problem Report");
        title.setFont(new Font("Arial", 24));

        Label icon = new Label("📄");
        icon.setFont(new Font("Arial", 80));

        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Enter problem details");

        TextField attachmentField = new TextField();
        attachmentField.setPromptText("Add image or audio (optional)");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white;");
        submitButton.setPrefWidth(200);

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainMenu));

        VBox layout = new VBox(15, title, icon, new Label("Description"), descriptionField, new Label("Attachment"), attachmentField, submitButton, back);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        problemReportScene = new Scene(layout, 600, 500);
    }

    private void buildSystemMonitorScreen() {
        Label title = new Label("System Monitor");
        title.setFont(new Font("Arial", 26));

        ComboBox<String> userType = new ComboBox<>();
        userType.getItems().addAll("Mechanical", "Driver");
        userType.setPromptText("User Type");

        ComboBox<String> errorType = new ComboBox<>();
        errorType.getItems().add("Is not connected");
        errorType.setPromptText("Error Type");

        Button applyButton = new Button("Apply");
        applyButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white;");
        applyButton.setPrefWidth(200);

        TableView<String[]> table = new TableView<>();
        table.getItems().addAll(
                new String[]{"06/10/2023 03:20 PM", "Repeated Fault Detected"},
                new String[]{"06/10/2023 09:17 AM", "User Login (Admin)"},
                new String[]{"07/09/2023 11:45 AM", "Error – Database Connection"}
        );

        TableColumn<String[], String> timeCol = new TableColumn<>("Time");
        timeCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue()[0]));

        TableColumn<String[], String> eventCol = new TableColumn<>("Event");
        eventCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue()[1]));

        table.getColumns().addAll(timeCol, eventCol);

        Button downloadButton = new Button("Download Logs");
        downloadButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white;");
        downloadButton.setPrefWidth(200);

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainMenu));

        VBox layout = new VBox(15, title, new HBox(10, userType, errorType), applyButton, table, downloadButton, back);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        systemMonitorScene = new Scene(layout, 600, 600);
    }

    private void buildVehicleAccessScreen() {
        Label title = new Label("Request Access to Vehicle Data");
        title.setFont(new Font("Arial", 22));

        Label carIcon = new Label("🚗");
        carIcon.setFont(new Font("Arial", 60));

        TextField vehicleIdField = new TextField();
        vehicleIdField.setPromptText("Enter vehicle ID");

        TextField reasonField = new TextField();
        reasonField.setPromptText("Enter reason (optional)");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #007BFF; -fx-text-fill: white;");
        submitButton.setPrefWidth(200);

        VBox formLayout = new VBox(15, title, carIcon, new Label("Vehicle ID"), vehicleIdField, new Label("Request Reason"), reasonField, submitButton);
        formLayout.setAlignment(Pos.CENTER);
        formLayout.setPadding(new Insets(30));

        Scene formScene = new Scene(formLayout, 600, 500);

        Label mechanicIcon = new Label("🧑‍🔧");
        mechanicIcon.setFont(new Font("Arial", 60));

        Label mechanicRequestLabel = new Label();
        mechanicRequestLabel.setFont(new Font("Arial", 16));
        mechanicRequestLabel.setWrapText(true);

        Label reasonDisplayLabel = new Label();
        reasonDisplayLabel.setFont(new Font("Arial", 14));
        reasonDisplayLabel.setWrapText(true);

        Button declineButton = new Button("Decline");
        Button approveButton = new Button("Approve");

        VBox approvalLayout = new VBox(15, mechanicIcon, mechanicRequestLabel, reasonDisplayLabel, new HBox(10, declineButton, approveButton));
        approvalLayout.setAlignment(Pos.CENTER);
        approvalLayout.setPadding(new Insets(30));

        Scene approvalScene = new Scene(approvalLayout, 600, 500);

        submitButton.setOnAction(e -> {
            String vehicleId = vehicleIdField.getText();
            String reason = reasonField.getText();
            mechanicRequestLabel.setText("A mechanic is requesting access to vehicle data for Vehicle ID " + vehicleId);
            reasonDisplayLabel.setText("Reason: " + (reason.isEmpty() ? "No reason provided" : reason));
            window.setScene(approvalScene);
        });

        declineButton.setOnAction(e -> window.setScene(mainMenu));
        approveButton.setOnAction(e -> window.setScene(mainMenu));

        vehicleAccessScene = formScene;
    }

    public static void main(String[] args) {
        launch(args);
}
}