package fr.tp.inf112.robotsim.persistence;

import fr.tp.inf112.projects.canvas.controller.impl.AbstractCanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.controller.impl.FileCanvasChooser;
import fr.tp.inf112.projects.canvas.model.Canvas;

import java.io.*;

/**
 * Persistance de l'usine sur disque.
 */
public class FilePersistenceManager extends AbstractCanvasPersistenceManager {
    public FilePersistenceManager() {
        super(new FileCanvasChooser(".factory"));
    }

    @Override
    public void persist(Canvas model) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(model.getName() + ".factory"))) {
            out.writeObject(model);
        }
    }

    @Override
    public Canvas read(Canvas model) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(model.getName() + ".factory"))) {
            return (Canvas) in.readObject();
        }
    }

    @Override
    public void delete(Canvas model) throws IOException {
        File f = new File(model.getName() + ".factory");
        if (!f.delete()) throw new IOException("Impossible de supprimer le fichier");
    }
}
