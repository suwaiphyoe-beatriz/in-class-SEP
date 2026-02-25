import java.util.Scanner;

public class SpeedConverter {

    public static double calculateSpeed(double distance, double time) {
        if (time <= 0) throw new IllegalArgumentException("Time must be greater than 0");
        return distance / time;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter distance in meters: ");
        double distance = scanner.nextDouble();

        System.out.print("Enter time in seconds: ");
        double time = scanner.nextDouble();

        try {
            double speed = calculateSpeed(distance, time);
            System.out.println("The speed is: " + speed + " m/s");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}