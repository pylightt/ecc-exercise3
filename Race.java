import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Race {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);

	private List<Horse> healthyHorses;
	private List<Horse> finishedHorses;
	private int targetDistance;


	public Race(int horseCount, int targetDistance) {
		
		int travelDistance = 0;
		
		healthyHorses = Stream.generate(nameHorses(travelDistance, targetDistance))
			.limit(horseCount).collect(Collectors.toList());

		Predicate<Object> isHealthy = o -> {
			return random.nextBoolean();
		};

		healthyHorses = healthyHorses.stream().filter(isHealthy).collect(Collectors.toList());
	}


	public Supplier<Horse> nameHorses(int travelDistance, int targetDistance) {
		return () -> new Horse("horse-"+(random.nextInt(900)+100),travelDistance,targetDistance);

	}

	public int getHealthyCount() {
		return this.healthyHorses.size();
	}

	public boolean startRace() {

		List<Horse> leftHorses = getUnfinishedHorses();

		while (!leftHorses.isEmpty()) {
			System.out.println("\nTURN");
			leftHorses = getUnfinishedHorses();
			leftHorses.parallelStream().forEach(horse -> {
				horse.setName(horse.getName().toUpperCase());
				horse.start();
				});
		}
		return leftHorses.size() > 0;
	}

	public List<Horse> getUnfinishedHorses() {
		finishedHorses = this.healthyHorses.stream().filter(horse -> horse.isFinished())
			.collect(Collectors.toList());
		return this.healthyHorses.stream().filter(horse -> !horse.isFinished())
			.collect(Collectors.toList());
	}

	public void printRace() {
		finishedHorses.stream().forEach(done -> done.printResults());
	}
}
