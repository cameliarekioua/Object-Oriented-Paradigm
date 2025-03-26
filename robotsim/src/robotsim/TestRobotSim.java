package robotsim;

import java.util.ArrayList;

import fr.tp.inf112.robotsim.model.Robot;

public class TestRobotSim {

	public static void main(String[] args) {
		Robot myRobot = new Robot("Robot 1", 5);
		System.out.println(myRobot);
		
		Factory myFactory = new Factory("Factory 1", new ArrayList<>());
			 
		boolean added1 = myFactory.addRobot("Robot1");
		        
		boolean added2 = myFactory.addRobot("Robot2");
		     
		myFactory.printToConsole();

	}

}
