package image1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Image07 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title
        Label title = new Label("Predictive Analytics");
        title.setFont(new Font("Arial", 26));
        title.setTextFill(Color.WHITE);

        // Prediction Trends Chart (Line Chart)
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Prediction Trends");
        lineChart.setLegendVisible(false);
        lineChart.setPrefSize(250, 200);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(0, 20));
        series.getData().add(new XYChart.Data<>(1, 30));
        series.getData().add(new XYChart.Data<>(2, 40));
        series.getData().add(new XYChart.Data<>(3, 50));
        series.getData().add(new XYChart.Data<>(4, 60));
        series.getData().add(new XYChart.Data<>(5, 70));
        lineChart.getData().add(series);

        // Mile by Day Chart (Bar Chart)
        CategoryAxis xAxisBar = new CategoryAxis();
        NumberAxis yAxisBar = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxisBar, yAxisBar);
        barChart.setTitle("Mile by Day");
        barChart.setLegendVisible(false);
        barChart.setPrefSize(250, 200);

        XYChart.Series<String, Number> barSeries = new XYChart.Series<>();
        barSeries.getData().add(new XYChart.Data<>("S", 10));
        barSeries.getData().add(new XYChart.Data<>("M", 15));
        barSeries.getData().add(new XYChart.Data<>("T", 20));
        barSeries.getData().add(new XYChart.Data<>("W", 25));
        barSeries.getData().add(new XYChart.Data<>("T", 30));
        barSeries.getData().add(new XYChart.Data<>("F", 35));
        barSeries.getData().add(new XYChart.Data<>("S", 40));
        barChart.getData().add(barSeries);

        VBox chartBox = new VBox(20, lineChart, barChart);
        chartBox.setAlignment(Pos.CENTER_LEFT);

        // Recent Data
        Label recentData = new Label("Recent Data\n\nData Entries: 1,479\nTracking Days: 180");
        recentData.setFont(new Font("Arial", 16));
        recentData.setTextFill(Color.WHITE);

        // Future Predictions
        Label futurePredictions = new Label("Future Predictions\n\nBrake Life: 12,000 mi\nBattery Replacement: May 2025\nOil Change: In 800 mi");
        futurePredictions.setFont(new Font("Arial", 16));
        futurePredictions.setTextFill(Color.WHITE);

        VBox dataBox = new VBox(30, recentData, futurePredictions);
        dataBox.setAlignment(Pos.CENTER_LEFT);

        HBox contentBox = new HBox(30, chartBox, dataBox);
        contentBox.setAlignment(Pos.CENTER);

        // Buttons
        Button openAnalytics = new Button("Open Analytics");
        Button filterData = new Button("Filter Data");

        HBox buttonBox = new HBox(20, openAnalytics, filterData);
        buttonBox.setAlignment(Pos.CENTER);

        // Navigation Bar
        Button homeBtn = new Button("🚗 Home");
        Button alertBtn = new Button("🔔 Alert");
        Button locationBtn = new Button("📍 Location");
        Button maintenanceBtn = new Button("🛠 Maintenance");
        Button infoBtn = new Button("ℹ Info");

        homeBtn.setPrefWidth(100);
        alertBtn.setPrefWidth(100);
        locationBtn.setPrefWidth(100);
        maintenanceBtn.setPrefWidth(100);
        infoBtn.setPrefWidth(100);

        HBox navBar = new HBox(10, homeBtn, alertBtn, locationBtn, maintenanceBtn, infoBtn);
        navBar.setAlignment(Pos.CENTER);
        navBar.setPadding(new Insets(20, 0, 0, 0));

        // Main Layout
        VBox mainLayout = new VBox(20, title, contentBox, buttonBox, navBar);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        // Scene
        Scene scene = new Scene(mainLayout, 700, 600);
        primaryStage.setTitle("Predictive Analytics");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
}
}