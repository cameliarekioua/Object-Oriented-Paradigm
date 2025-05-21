package fr.tp.inf112.robotsim.controller;

import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.model.Observer;
import fr.tp.inf112.robotsim.model.Factory;

/**
 * Contrôleur MVC pour démarrer/arrêter la simulation.
 */
public class SimulatorController implements CanvasViewerController {
    private Factory factory;

    public SimulatorController(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void startAnimation() {
        new Thread(factory::startSimulation).start();
    }

    @Override
    public void stopAnimation() {
        factory.stopSimulation();
    }

    @Override
    public boolean isAnimationRunning() {
        return factory.isSimulationRunning();
    }

    @Override
    public void addObserver(Observer o) {
        factory.addObserver(o);
    }

    @Override
    public void removeObserver(Observer o) {
        factory.removeObserver(o);
    }
}
