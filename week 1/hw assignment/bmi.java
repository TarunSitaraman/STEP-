import java.util.Scanner;

public class bmi {
    public static String getBMIStatus(double bmi) {
        if (bmi < 18.4) return "Underweight";
        else if (bmi >= 18.5 && bmi <= 24.9) return "Normal";
        else if (bmi >= 25.0 && bmi <= 39.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            double weight = sc.nextDouble();
            System.out.print("Height (cm): ");
            double heightCm = sc.nextDouble();
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            String status = getBMIStatus(bmi);
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", heightCm, weight, bmi, status);
        }
    }
}