import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class DoStuff {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);

	private List<Horse> healthyHorses = new ArrayList<>();

	private int targetDistance;
	private int leftDistance = targetDistance;
	private int travelDistance = 0;
	Horse horse = new Horse(healthyHorses, travelDistance, targetDistance); 


	public void targetDistance() {
		System.out.print("Input race distance: ");
		targetDistance = scan.nextInt();
	}

	public List<String> nameHorses() {
		System.out.print("Input horse count: ");
		
		List<Object> count = IntStream.rangeClosed(1, scan.nextInt())
			.boxed().collect(Collectors.toList());
		
		List<String>horseNames = count.stream()
			.map(s -> "horse" + String.valueOf(s))
			.collect(Collectors.toList());
 
        return horseNames;
	}

	public List<String> filterHealthy(List<Horse> horseNames) {
		Predicate<Object> isHealthy = o -> {
			return random.nextBoolean();
		};
		
		healthyHorses = horseNames.stream()
			.filter(isHealthy).map(horse -> horse.get)
			.collect(Collectors.toList());
			return healthyHorses;
	}

	public List<Horse> start() {
	List<Horse> startRace = horse.parallelStream()
		.forEach(Horse::race)
		.filter(Horse::isFinished)
		.collect(Collectors.toList());
		return startRace;
	}

}