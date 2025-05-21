package fr.tp.inf112.robotsim.model;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Stroke;
import fr.tp.inf112.projects.canvas.model.impl.BasicOval;
import fr.tp.inf112.projects.canvas.model.impl.BasicStroke;
import fr.tp.inf112.projects.canvas.model.impl.RGBColor;

import java.io.Serializable;
import java.util.*;

/**
 * Robot mobile, se déplace en contournant obstacles.
 */
public class Robot extends Component implements Serializable {
    private double speed;
    private List<Component> toVisit = new ArrayList<>();
    private int currentTarget = 0;
    private FactoryPathFinder pathFinder;
    private Queue<Position> currentPath = new LinkedList<>();

    public Robot(String name, Position position, double speed) {
        super(name, position, 1, 1);
        this.speed = speed;
    }

    public void addDestination(Component c) {
        toVisit.add(c);
    }

    public void setPathFinder(FactoryPathFinder finder) {
        this.pathFinder = finder;
    }

    @Override
    public void behave() {
        if (pathFinder == null || toVisit.isEmpty()) return;
        if (currentPath.isEmpty()) {
            Component target = toVisit.get(currentTarget);
            List<Position> path = pathFinder.findPath(this, target, (Factory)factory);
            currentPath.addAll(path);
        }
        Position next = currentPath.poll();
        if (next != null) {
            position = next;
            if (factory != null) factory.notifyObservers();
            if (position.equals(toVisit.get(currentTarget).getPosition())) {
                currentTarget = (currentTarget + 1) % toVisit.size();
                currentPath.clear();
            }
        }
    }

    @Override
    public Shape getShape() {
        return new BasicOval(width, height);
    }

    @Override
    public Color getBackgroundColor() {
        return new RGBColor(0, 128, 255);
    }

    @Override
    public Stroke getStroke() {
        return new BasicStroke(2, false, new RGBColor(0, 0, 0));
    }
}
