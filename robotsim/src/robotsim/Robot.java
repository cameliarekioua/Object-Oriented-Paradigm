package robotsim;

public class Robot {
	
	private String name;
	private double speed;
	
	public Robot(String name, double speed) {
		super();
		this.name = name;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "My name is " + name + " and I move at " + speed + " km/h.";
	}

}
