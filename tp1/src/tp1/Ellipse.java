package tp1;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;

public class Ellipse extends BaseShape {
    // Cree une ellipse avec une largeur et une longueur.
    // FIXME: add more thickness
    public Ellipse(Double widthRadius, Double heightRadius) {
        super();
        for (double i = 0.0; i < 2 * Math.PI; i += (2 * Math.PI) / 100) {
            add(new Point2d(widthRadius * Math.cos(i), heightRadius * Math.sin(i)));
        }
        remove(new Point2d(0.0,0.0));
    }

    private Ellipse(Set<Point2d> coords) {
        super(coords);
    }

    // Applique la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        return new Ellipse(super.translate(point).getCoords());
    }

    // Applique la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        return new Ellipse(super.rotate(angle).getCoords());
    }

    // Retourne une nouvelle forme.
    @Override
    public Ellipse clone() { return new Ellipse(getCoords()); }

    // Returns a set of n points calculated from the parametric equation of an ellipse
    public static Set<Point2d> ellipseParametricEquationPoints(
            double widthRadius, double heightRadius, double numberOfSectors, double from, double upTo) {

        Set<Point2d> coords = new HashSet<>();
        for (double i = from; i < upTo; i += (2 * Math.PI) / numberOfSectors) {
            coords.add(new Point2d(widthRadius * Math.cos(i), heightRadius * Math.sin(i)));
        }
        return coords;

    }
}
