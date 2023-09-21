import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureTracker {
    public static void main(String[] args) {
        ArrayList<String> daysOfWeek = new ArrayList<>();
        ArrayList<Double> dailyTemperatures = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            // Populate arrays with day and temperature data
            String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            double[] temperatures = {78.5, 80.2, 82.0, 79.8, 75.5, 77.3, 81.1};

            for (int i = 0; i < weekdays.length; i++) {
                daysOfWeek.add(weekdays[i]);
                dailyTemperatures.add(temperatures[i]);
            }

            // Prompt user for input
            while (true) {
                System.out.println("Enter a day of the week (Monday through Sunday) or 'week' for the entire week:");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("week")) {
                    // Calculate and display weekly average
                    double weeklyAverage = calculateWeeklyAverage(dailyTemperatures);
                    System.out.println("Weekly Average Temperature: " + weeklyAverage);
                    for (int i = 0; i < daysOfWeek.size(); i++) {
                        System.out.println(daysOfWeek.get(i) + ": " + dailyTemperatures.get(i));
                    }
                } else if (daysOfWeek.contains(input)) {
                    // Display temperature for day input by user
                    int index = daysOfWeek.indexOf(input);
                    double temperature = dailyTemperatures.get(index);
                    System.out.println(input + ": " + temperature);
                } else {
                    System.out.println("Invalid input. Please enter a valid day of the week or 'week'.");
                }
            }
        }
    }

    // Calculate weekly average
    private static double calculateWeeklyAverage(ArrayList<Double> dailyTemperatures) {
        double totalTemperature = 0.0;
        for (double temperature : dailyTemperatures) {
            totalTemperature += temperature;
        }
        return totalTemperature / dailyTemperatures.size();
    }
}
