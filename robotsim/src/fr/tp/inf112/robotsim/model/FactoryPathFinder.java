package fr.tp.inf112.robotsim.model;

import java.util.List;

/**
 * Interface pour déterminer un chemin en tenant compte des obstacles.
 */
public interface FactoryPathFinder {
    List<Position> findPath(Component source, Component target, Factory factory);
}
