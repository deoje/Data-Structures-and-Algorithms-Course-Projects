package tp1;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class BaseShape {
    // Vous aller apprendre plus en details le fonctionnement d'un Set lors
    // du cours sur les fonctions de hashage, vous pouvez considerez ceci comme une liste normale.
    private Set<Point2d> coords;

    // Initialise les points.
    public BaseShape() {
        coords = new HashSet<>();
        coords.add(new Point2d(0.0, 0.0));
    }

    // Prend une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        this.coords = new HashSet<>();
        this.addAll(coords);
    }

    // FIXME:Ajoute ou retire des coordonnees a la liste de points.
    public void add(Point2d coord) {
        coords.add(new Point2d(coord.X(),coord.Y()));
    }
    public void add(BaseShape shape) {
        addAll(shape.getCoords());
    }
    public void addAll(Collection<Point2d> coords) {
        this.coords.addAll(new HashSet<>(coords));
    }
    public void remove(Point2d coord) {
         coords.remove(new Point2d(coord.X(),coord.Y()));
    }
    public void remove(BaseShape shape) {
        removeAll(shape.getCoords());
    }
    public void removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(new HashSet<>(coords));
    }

    // TODO retourne les coordonnees de la liste
    public Set<Point2d> getCoords() {
        return new HashSet<>(coords);
    }

    // Appliquer la translation sur la forme
    public BaseShape translate(Point2d point) {
        return new BaseShape(this.translateAll(point));
    }

    // TODO appliquer la translation sur la liste.
    public Set<Point2d> translateAll(Point2d point) {
        Set<Point2d> translatedCoords = getCoords();
        Iterator<Point2d> it = translatedCoords.iterator();
        while (it.hasNext()){
            it.next().translate(point);
        }
        return translatedCoords;
    }

    // Applique la rotation sur la forme
    public BaseShape rotate(Double angle) {
        return new BaseShape(this.rotateAll(angle));
    }

    // Applique la rotation sur la liste
    public Set<Point2d> rotateAll(Double angle) {
        Set<Point2d> rotatedCoords = getCoords();
        Iterator<Point2d> it = rotatedCoords.iterator();
        while (it.hasNext()){
            it.next().rotate(angle);
        }
        return rotatedCoords;
    }

    // Retourne une nouvelle forme
    public BaseShape clone() {
        return new BaseShape(coords);
    }
}
