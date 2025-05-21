package fr.tp.inf112.robotsim.model;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Stroke;
import fr.tp.inf112.projects.canvas.model.impl.BasicRectangle;
import fr.tp.inf112.projects.canvas.model.impl.BasicStroke;
import fr.tp.inf112.projects.canvas.model.impl.RGBColor;

import java.io.Serializable;

/** Salle rectangulaire. */
public class Room extends Component implements Serializable {
    public Room(String name, Position position, int width, int height) {
        super(name, position, width, height);
    }

    @Override
    public Shape getShape() {
        return new BasicRectangle(width, height);
    }

    @Override
    public Color getBackgroundColor() {
        return new RGBColor(255, 255, 204);
    }

    @Override
    public Stroke getStroke() {
        return new BasicStroke(1, false, new RGBColor(0, 0, 0));
    }
}
