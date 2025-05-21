package fr.tp.inf112.robotsim.model;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Stroke;
import fr.tp.inf112.projects.canvas.model.impl.BasicRectangle;
import fr.tp.inf112.projects.canvas.model.impl.BasicStroke;
import fr.tp.inf112.projects.canvas.model.impl.RGBColor;

import java.io.Serializable;

/** Station de recharge. */
public class ChargingStation extends Component implements Serializable {
    public ChargingStation(String name, Position position) {
        super(name, position, 1, 1);
    }

    @Override
    public Shape getShape() {
        return new BasicRectangle(width, height);
    }

    @Override
    public Color getBackgroundColor() {
        return new RGBColor(102, 255, 102);
    }

    @Override
    public Stroke getStroke() {
        return new BasicStroke(1, false, new RGBColor(0, 0, 0));
    }
}
