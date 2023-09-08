public class RobotFactory {

    public static void main(String[] args) {
        int numberOfWidgets = 500;
        for (int i = 1; i <= numberOfWidgets; i++) {
            checkWidgetQuality(i);
        }
    }

    public static void checkWidgetQuality(int widgetNumber) {
        System.out.println("Checking quality of widget number " + widgetNumber);
    }
}
