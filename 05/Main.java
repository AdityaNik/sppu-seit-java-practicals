/*
 * Name: Aditya Nikam
 * Roll No: 3098
 * Problem Statement: Design and develop a context for given case study and implement an interface for Vehicles Consider the example of vehicles like bicycle, car and bike. 
 *      All Vehicles have common functionalities such as   Gear Change, Speed up and apply breaks. 
 *      Make an interface and put all these common functionalities. Bicycle, Bike, Car classes should be implemented for all these functionalities in their own class in their own way.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nChoose a vehicle: ");
        System.out.println("1- Bicycle");
        System.out.println("2- Bike");
        System.out.println("3- Car");
        System.out.println("4- Exit\n");
        int choice = scanner.nextInt();
        Vehicle vehicle = null;

        if (choice == 1) {
            vehicle = new Bicycle();
        } else if (choice == 2) {
            vehicle = new Bike();
        } else if (choice == 3) {
            vehicle = new Car();
        } else if (choice == 4) {
            System.out.println("Code Exited");
            return;
        } else {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        while (true) {
            System.out.println("\n\nSelect an action :");
            System.out.println("1- Gear Change");
            System.out.println("2- Speed Up");
            System.out.println("3- Apply Brakes");
            System.out.println("4- Exit\n");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.println("Enter the new gear: ");
                    int newGear = scanner.nextInt();
                    vehicle.gearChange(newGear);
                    break;
                case 2:
                    System.out.println("Enter the speed increment: ");
                    int increment = scanner.nextInt();
                    vehicle.speedUp(increment);
                    break;
                case 3:
                    System.out.println("Enter the brake decrement: ");
                    int decrement = scanner.nextInt();
                    vehicle.applyBrakes(decrement);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid action. Exiting.");
                    System.exit(0);
            }
        }
    }
}