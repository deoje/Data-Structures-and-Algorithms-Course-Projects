package tp1;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class BaseShape {
    // Vous aller apprendre plus en details le fonctionnement d'un Set lors
    // du cours sur les fonctions de hashage, vous pouvez considerez ceci comme une liste normale.
    private Set<Point2d> coords;

    // TODO Initialiser les points.
    public BaseShape() {
        coords = new HashSet<>();
        coords.add(new Point2d(0.0, 0.0));
    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        this.coords = new HashSet<>();
        this.coords.add(new Point2d(0.0, 0.0));
        this.coords.addAll(coords);
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public void add(Point2d coord) {
        coords.add(coord);
    }
    public void add(BaseShape shape) {
        coords.addAll(shape.coords);
    }
    public void addAll(Collection<Point2d> coords) {
        this.coords.addAll(coords);
    }
    public void remove(Point2d coord) {
        coords.remove(coord);
    }
    public void remove(BaseShape shape) {
        coords.removeAll(shape.coords);
    }
    public void removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(coords);
    }

    // TODO retourne les coordonnees de la liste.
    public Set<Point2d> getCoords() {
        return new HashSet<>(this.coords);
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        coords.iterator().next().translate(point);
        return this;
    }

    // TODO appliquer la translation sur la liste.
    public Set<Point2d> translateAll(Point2d point) {
        Iterator<Point2d> it = coords.iterator();

        while (it.hasNext()){
            it.next().translate(point);
        }
        return new HashSet<>(coords);
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        coords.iterator().next().rotate(angle);
        return this;
    }

    // TODO appliquer la rotation sur la liste.
    public Set<Point2d> rotateAll(Double angle) {
        Iterator<Point2d> it = coords.iterator();
        while (it.hasNext()){
            it.next().rotate(angle);
        }
        return new HashSet<>(coords);
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        return new BaseShape(coords);
    }
}
