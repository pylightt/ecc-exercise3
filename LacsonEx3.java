import java.util.*;
public class LacsonEx3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Input number of horses: ");
		int horseCount = Integer.parseInt(scan.next());
		System.out.print("Input race distance: ");
		int targetDistance = Integer.parseInt(scan.next());
		Race run = new Race(horseCount, targetDistance);

		while (run.getHealthyCount() < 2) {
			System.out.println("\nHealthy horses are less than 2, cannot start the race.");
			System.out.print("Input new number of horses: ");
			horseCount = Integer.parseInt(scan.next());
			System.out.print("Input race distance: ");
			targetDistance = Integer.parseInt(scan.next());
			run = new Race(horseCount, targetDistance);
		} 

		System.out.println("START RACE");
		run.startRace();

		System.out.println("\nTOTAL DISTANCE TRAVELED PER HORSE");
		run.printRace();

	}
}