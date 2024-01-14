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
    private static final String LOG_FILE_PATH = "log.txt";
    private static final String BACKGROUND_COLOR = "-fx-background-color: rgb(0, %d, 0);";
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 150;

    private TextField textBox;
    private VBox verticalLayout;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CTA3 Menu Buttons");

        initializeComponents();
        Scene scene = new Scene(verticalLayout, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeComponents() {
        textBox = new TextField();
        textBox.setEditable(false);

        MenuItem menuButton1 = new MenuItem("Display Date & Time");
        menuButton1.setOnAction(event -> displayDateTime());

        MenuItem menuButton2 = new MenuItem("Save to 'log.txt'");
        menuButton2.setOnAction(event -> saveToLogFile());

        MenuItem menuButton3 = new MenuItem("Change Background Color");
        menuButton3.setOnAction(event -> changeBackgroundColor());

        MenuItem menuButton4 = new MenuItem("Exit");
        menuButton4.setOnAction(event -> System.exit(0));

        MenuButton mainMenuButton = new MenuButton("Menu", null, menuButton1, menuButton2, menuButton3, menuButton4);

        verticalLayout = new VBox(10, mainMenuButton, textBox);
        verticalLayout.setPadding(new Insets(10));
        verticalLayout.setStyle(String.format(BACKGROUND_COLOR, 255));
    }

    private void displayDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        LocalDateTime now = LocalDateTime.now();
        textBox.setText(dtf.format(now));
    }

    private void saveToLogFile() {
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH)) {
            writer.write(textBox.getText());
            showAlert("Success", "Log saved to 'log.txt'");
        } catch (IOException e) {
            showAlert("Error", "Failed to save the log.");
        }
    }

    private void changeBackgroundColor() {
        Random random = new Random();
        int greenValue = random.nextInt(256);
        verticalLayout.setStyle(String.format(BACKGROUND_COLOR, greenValue));
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
