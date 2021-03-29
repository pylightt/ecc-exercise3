import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Horse {
	Random random = new Random();

	private String name;
	private int travelDistance;
	private int targetDistance;
	private int leftDistance = travelDistance;
	private boolean isFinished;
	private static List<Optional<String>> listWarCry;
	private String warCry;

	private static int raceDistance;

	public Horse(String name, int travelDistance, int targetDistance) {
		this.name = name;
		this.travelDistance = travelDistance;
		this.targetDistance = targetDistance; 
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	public int leftDistance() {
		if (this.travelDistance < this.targetDistance) {
			this.leftDistance = this.targetDistance - this.travelDistance;
		} else {
			this.leftDistance = 0;
		}
		return leftDistance;
	}
	
	public boolean start() {
		this.travelDistance += random.nextInt(10-1)+1;
		if (isFinished()) {
			this.leftDistance = 0;
			chooseWarCry();
			System.out.printf("%s \t %2d traveled \t %2d left \t warcry: %s\n", this.name, this.travelDistance, leftDistance(),
			 listWarCry.get(random.nextInt(5)).orElse("None"));
		} else {
			System.out.printf("%s \t %2d traveled \t %2d left \n", this.name, this.travelDistance, leftDistance());
		}
		return true;
	}

	public void printResults() {
		System.out.printf("%s \t %2d traveled \n", this.name, this.travelDistance);
	}

	public boolean isFinished() {
		return this.travelDistance >= this.targetDistance;
	}

	public List<Optional<String>> chooseWarCry() {
		List<String> list = new ArrayList<String>();
			list.add("Apples!");
			list.add("Oranges!");
			list.add("Grapes!");
			list.add("Peaches!");
			list.add(null);
		listWarCry = list.stream().map(Optional::ofNullable)
			.collect(Collectors.toList());
			
		return listWarCry;
	} 
}