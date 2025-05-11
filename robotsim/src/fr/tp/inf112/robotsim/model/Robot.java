package fr.tp.inf112.robotsim.model;

public class Robot extends Component {
	
	private String name;
	private double speed;
	
	public Robot(String name, double speed) {
		super(name, position, height, height);
		this.name = name;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "My name is " + name + " and I move at " + speed + " km/h.";
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public double getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}


}
