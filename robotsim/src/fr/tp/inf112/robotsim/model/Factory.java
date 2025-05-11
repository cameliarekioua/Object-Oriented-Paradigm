package fr.tp.inf112.robotsim.model;


import java.util.ArrayList;
import java.util.List;

public class Factory {

    private String name;
    private List<Component> components;

    public Factory(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public boolean addComponent(Component c) {
        for (Component existing : components) {
            if (existing.getName().equalsIgnoreCase(c.getName())) {
                return false; // Nom déjà utilisé
            }
        }
        components.add(c);
        return true;
    }

    public boolean checkComponentName(String name) {
        return components.stream().noneMatch(c -> c.getName().equalsIgnoreCase(name));
    }

    public void printToConsole() {
        System.out.println("Nom de l’usine : " + name);
        System.out.println("Liste des composants de l’usine :");

        if (components.isEmpty()) {
            System.out.println("Aucun composant enregistré.");
        } else {
            for (Component c : components) {
                System.out.println("- " + c);
            }
        }
    }

    public List<Component> getComponents() {
        return new ArrayList<>(components); // Protection contre modification externe
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
