package fr.tp.inf112.robotsim.model;

import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Stroke;
import fr.tp.inf112.projects.canvas.model.impl.BasicRectangle;
import fr.tp.inf112.projects.canvas.model.impl.BasicStroke;
import fr.tp.inf112.projects.canvas.model.impl.RGBColor;

import java.io.Serializable;

/**
 * Classe de base pour tous les composants de l'usine.
 * Implémente Figure pour l'affichage graphique et Serializable pour la persistance.
 */
public abstract class Component implements Figure, Serializable {
    protected String name;
    protected Position position;
    protected int width;
    protected int height;
    protected transient Factory factory; // non sérialisé

    public Component(String name, Position position, int width, int height) {
        this.name = name;
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void behave() {
        // comportement par défaut : rien à faire
    }

    @Override
    public Shape getShape() {
        return new BasicRectangle(width, height);
    }

    @Override
    public Color getBackgroundColor() {
        return new RGBColor(200, 200, 200);
    }

    @Override
    public Stroke getStroke() {
        return new BasicStroke(1, false, new RGBColor(0, 0, 0));
    }

    /**
     * Indique si la position p est recouverte par ce composant (obstacle).
     */
    public boolean overlays(Position p) {
        int x0 = position.getX(), y0 = position.getY();
        return p.getX() >= x0 && p.getX() < x0 + width
            && p.getY() >= y0 && p.getY() < y0 + height;
    }

    @Override
    public String toString() {
        return name + "@" + position;
    }
}
