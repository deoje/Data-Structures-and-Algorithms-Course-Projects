package tp1;

import java.util.HashSet;
import java.util.Set;

public class Ellipse extends BaseShape {
    // Cree une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        super(ellipseParametricEquationPoints(widthRadius,heightRadius,6.0));
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
    public static Set<Point2d> ellipseParametricEquationPoints(Double widthRadius, Double heightRadius, Double n) {
        HashSet<Point2d> points = new HashSet<>();
        for (int i = 0; i < 2 * Math.PI; i += (2 * Math.PI) / n) {
            points.add(new Point2d(widthRadius * Math.cos(i), heightRadius * Math.sin(i)));
        }
        return points;
    }
}
