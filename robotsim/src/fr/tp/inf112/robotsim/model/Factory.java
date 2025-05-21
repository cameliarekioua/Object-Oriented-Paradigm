package fr.tp.inf112.robotsim.model;

import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.controller.Observable;
import fr.tp.inf112.projects.canvas.model.Observer;

import java.io.Serializable;
import java.util.*;

/**
 * Modèle de l'usine, observable et persistant.
 */
public class Factory extends Component implements Canvas, Observable, Serializable {
    private List<Component> components = new ArrayList<>();
    private transient List<Observer> observers = new ArrayList<>();
    private transient boolean simulationRunning = false;

    public Factory(String name, int width, int height) {
        super(name, new Position(0,0), width, height);
    }

    public boolean addComponent(Component c) {
        for (Component e : components) {
            if (e.getName().equalsIgnoreCase(c.getName())) return false;
        }
        c.setFactory(this);
        components.add(c);
        return true;
    }

    @Override
    public void behave() {
        for (Component c : components) {
            c.behave();
        }
    }

    public void startSimulation() {
        simulationRunning = true;
        while (simulationRunning) {
            behave();
            notifyObservers();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopSimulation() {
        simulationRunning = false;
    }

    public boolean isSimulationRunning() {
        return simulationRunning;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.modelChanged();
        }
    }

    @Override
    public Collection<Figure> getFigures() {
        return (Collection<Figure>)(Collection<?>) components;
    }
}
