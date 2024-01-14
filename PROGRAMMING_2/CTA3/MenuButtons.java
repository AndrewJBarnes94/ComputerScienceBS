package PROGRAMMING_2.CTA3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuButtons extends Application {
    private static final String DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    private static final String LOG_FILE_PATH = "./log.txt";
    private static final String BACKGROUND_COLOR_STYLE_FORMAT = "-fx-background-color: rgb(0, %d, 0);";
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 300;

    private TextArea textArea;
    private VBox rootLayout;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menu Example");

        initializeComponents();
        Scene scene = new Scene(rootLayout, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeComponents() {
        textArea = new TextArea();
        textArea.setEditable(false);

        MenuItem menuItem1 = new MenuItem("Display Date & Time");
        menuItem1.setOnAction(event -> displayDateTime());

        MenuItem menuItem2 = new MenuItem("Save to 'log.txt'");
        menuItem2.setOnAction(event -> saveToLogFile());

        MenuItem menuItem3 = new MenuItem("Change Background Color");
        menuItem3.setOnAction(event -> changeBackgroundColor());

        MenuItem menuItem4 = new MenuItem("Exit");
        menuItem4.setOnAction(event -> System.exit(0));

        MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3, menuItem4);

        rootLayout = new VBox(10, menuButton, textArea);
        rootLayout.setPadding(new Insets(10));
        rootLayout.setStyle(String.format(BACKGROUND_COLOR_STYLE_FORMAT, 255)); // Default background color
    }

    private void displayDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        LocalDateTime now = LocalDateTime.now();
        textArea.setText(dtf.format(now));
    }

    private void saveToLogFile() {
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH)) {
            writer.write(textArea.getText());
            showAlert("Success", "Log saved successfully to 'log.txt'");
        } catch (IOException e) {
            showAlert("Error", "Failed to save the log.");
        }
    }

    private void changeBackgroundColor() {
        Random random = new Random();
        int greenValue = random.nextInt(256);
        rootLayout.setStyle(String.format(BACKGROUND_COLOR_STYLE_FORMAT, greenValue));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
