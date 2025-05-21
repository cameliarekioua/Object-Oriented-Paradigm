package fr.tp.inf112.robotsim.model;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.*;

/**
 * Implémentation de FactoryPathFinder avec JGraphT.
 */
public class JGraphTPathFinder implements FactoryPathFinder {
    private int gridX, gridY;

    public JGraphTPathFinder(int gridX, int gridY) {
        this.gridX = gridX;
        this.gridY = gridY;
    }

    @Override
    public List<Position> findPath(Component source, Component target, Factory factory) {
        DefaultDirectedGraph<Position, DefaultEdge> graph =
            new DefaultDirectedGraph<>(DefaultEdge.class);

        // ajouter tous les sommets
        for (int x = 0; x < gridX; x++) {
            for (int y = 0; y < gridY; y++) {
                graph.addVertex(new Position(x, y));
            }
        }

        // arêtes entre voisins non-obstrués
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (Position p : graph.vertexSet()) {
            for (int[] d : dirs) {
                Position q = new Position(p.getX()+d[0], p.getY()+d[1]);
                if (graph.containsVertex(q) && !factory.getFigures().stream()
                        .filter(f->((Component)f).overlays(q)).findAny().isPresent()) {
                    graph.addEdge(p, q);
                }
            }
        }

        // Dijkstra
        Position start = source.getPosition();
        Position end   = target.getPosition();
        DijkstraShortestPath<Position, DefaultEdge> dsp =
            new DijkstraShortestPath<>(graph);
        List<DefaultEdge> edges = dsp.getPath(start, end).getEdgeList();

        // convertir en positions
        List<Position> path = new ArrayList<>();
        path.add(start);
        for (DefaultEdge e : edges) {
            path.add(graph.getEdgeTarget(e));
        }
        return path;
    }
}
