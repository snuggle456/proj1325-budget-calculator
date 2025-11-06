import java.util.Scanner;

public class UserInput {
    private Scanner input = new Scanner(System.in);

    private String name;
    private int age;
    private char gender;
    private double weight;   // stored in kg
    private double height;   // stored in cm
    private int activityLevel;
    private int goal;
    private int unitChoice;  // 1 = Imperial, 2 = Metric

    public void collectUserInfo() {
        System.out.println("=====================================");
        System.out.println("   Welcome to the Calorie Budget Calculator!");
        System.out.println("=====================================");
        System.out.println("Let's start by collecting some basic information.\n");

        System.out.print("Enter your name: ");
        name = input.nextLine();

        //  Unit selection 
        while (true) {
            System.out.println("\nChoose your measurement system:");
            System.out.println("1. Imperial (lbs, inches)");
            System.out.println("2. Metric (kg, cm)");
            System.out.print("Enter your choice (1 or 2): ");
            if (input.hasNextInt()) {
                unitChoice = input.nextInt();
                if (unitChoice == 1 || unitChoice == 2) break;
                else System.out.println("  Please enter 1 for Imperial or 2 for Metric.");
            } else {
                System.out.println("  Invalid input! Please enter a number.");
                input.next();
            }
        }

        // Age input with validation loop 
        while (true) {
            System.out.print("\nEnter your age (5–120): ");
            if (input.hasNextInt()) {
                age = input.nextInt();
                if (age >= 5 && age <= 120) break;
                else System.out.println("  Please enter a valid age between 5 and 120.");
            } else {
                System.out.println("  Invalid input! Please enter a number.");
                input.next();
            }
        }

        while (true) {
            System.out.print("Enter your gender (M/F): ");
            String inputStr = input.next();

        if (inputStr.length() > 0) {
            gender = Character.toUpperCase(inputStr.charAt(0)); // normalize to uppercase
            if (gender == 'M' || gender == 'F') {
                break;
            }   
        }
            System.out.println("Invalid input! Please enter 'M' or 'F'.");
        }

        // Weight + Height with unit handling 
        if (unitChoice == 1) { // Imperial
            System.out.print("Enter your weight (lbs): ");
            double pounds = input.nextDouble();
            weight = pounds * 0.453592; // convert to kg

            System.out.print("Enter your height (inches): ");
            double inches = input.nextDouble();
            height = inches * 2.54; // convert to cm
        } else { // Metric
            System.out.print("Enter your weight (kg): ");
            weight = input.nextDouble();

            System.out.print("Enter your height (cm): ");
            height = input.nextDouble();
        }

        //  Activity Level; will be used to determine resting calories
        while (true) {
            System.out.println("\nSelect your activity level:");
            System.out.println("1. Sedentary");
            System.out.println("2. Lightly active");
            System.out.println("3. Moderately active");
            System.out.println("4. Very active");
            System.out.print("Choice: ");
            if (input.hasNextInt()) {
                activityLevel = input.nextInt();
                if (activityLevel >= 1 && activityLevel <= 4) break;
                else System.out.println("  Please choose a number between 1 and 4.");
            } else {
                System.out.println("  Invalid input! Please enter a number.");
                input.next();
            }
        }

        //  Goal selection , number tied to desired outcome
        while (true) {
            System.out.println("\nSelect your goal:");
            System.out.println("1. Lose weight");
            System.out.println("2. Maintain weight");
            System.out.println("3. Gain weight");
            System.out.print("Choice: ");
            if (input.hasNextInt()) {
                goal = input.nextInt();
                if (goal >= 1 && goal <= 3) break;
                else System.out.println("  Please choose 1, 2, or 3.");
            } else {
                System.out.println("  Invalid input! Please enter a number.");
                input.next();
            }
        }

        System.out.println("\nThanks, " + name + "! Passing your data to the calculator...\n");
    }

    // Getters
    //these will allow collaborators to obtain fields in this file
    public String getName() { return name; } 
    public int getAge() { return age; }
    public char getGender() { return gender; }
    public double getWeight() { return weight; }
    public double getHeight() { return height; }
    public int getActivityLevel() { return activityLevel; }
    public int getGoal() { return goal; }
    public int getUnitChoice() { return unitChoice; }
}
