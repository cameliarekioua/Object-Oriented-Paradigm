package robotsim;

import java.util.ArrayList;

public class Factory {
	
	private String name; 
	private ArrayList<Robot> robots;

	public Factory(String name, ArrayList<Robot> robots) {
		super();
		this.name = name;
		this.robots = robots;
	}

	public boolean addRobot(String name) {
	   
	    for (Robot r : robots) {
	        if (r.getName().equals(name)) {
	            return false;
	        }
	    }
	    
	    Robot newRobot = new Robot(name, 0.0);
	    robots.add(newRobot);
	    return true;
	}
	
	
	private boolean checkRobotName(String name) {
	    for (Robot r : robots) {
	        if (r.getName().equals(name)) { 
	            return false;
	        }
	    }
	    return true; 
	}
	
	public void printToConsole() {
	    System.out.println("Name of the factory: " + name);
	    System.out.println("List of its robots:");

	    if (robots.isEmpty()) {
	        System.out.println("No robots in the factory.");
	    } else {
	        for (Robot r : robots) {
	            System.out.println("Name: " + r.getName() + " (Speed: " + r.getSpeed() + ")");
	        }
	    }
	}



	
}

