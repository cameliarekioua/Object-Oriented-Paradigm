package fr.tp.inf112.robotsim.app;

import fr.tp.inf112.projects.canvas.view.CanvasViewer;
import fr.tp.inf112.robotsim.controller.SimulatorController;
import fr.tp.inf112.robotsim.model.*;

/**
 * Point d'entrée de l'application.
 */
public class SimulatorApplication {
    public static void main(String[] args) {
        // taille du canevas = taille de l'usine
        Factory factory = new Factory("MyFactory", 10, 10);

        // composants
        Robot r1 = new Robot("R1", new Position(1,1),1.0);
        Robot r2 = new Robot("R2", new Position(2,2),1.0);
        Room room = new Room("Salle1", new Position(5,5),2,2);
        ChargingStation cs = new ChargingStation("Ch1", new Position(8,1));
        ProductionMachine pm = new ProductionMachine("PM1", new Position(3,3));

        // liaisons
        r1.setFactory(factory); r2.setFactory(factory);
        r1.addDestination(room); r1.addDestination(cs);
        r2.addDestination(pm);   r2.addDestination(cs);

        // ajout
        factory.addComponent(r1);
        factory.addComponent(r2);
        factory.addComponent(room);
        factory.addComponent(cs);
        factory.addComponent(pm);

        // gestion d'obstacles
        JGraphTPathFinder pf = new JGraphTPathFinder(10, 10);
        r1.setPathFinder(pf);
        r2.setPathFinder(pf);

        // contrôleur & vue
        SimulatorController ctrl = new SimulatorController(factory);
        CanvasViewer viewer = new CanvasViewer(ctrl);
        viewer.open();
    }
}
