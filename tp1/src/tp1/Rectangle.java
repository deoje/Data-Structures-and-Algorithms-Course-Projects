package tp1;

import java.util.Set;

public class Rectangle extends BaseShape {
    // Cree un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        super(Set.of(
                new Point2d(width / 2.0, height / 2.0),
                new Point2d(- width / 2.0, height / 2.0),
                new Point2d(- width / 2.0, - height / 2.0),
                new Point2d(width / 2.0, - height / 2.0)
            )
        );
    }

    // Creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions) {
        super(Set.of(
                new Point2d(dimensions.X() / 2.0, dimensions.Y() / 2.0),
                new Point2d(- dimensions.X() / 2.0, dimensions.Y() / 2.0),
                new Point2d(- dimensions.X() / 2.0,  - dimensions.Y() / 2.0),
                new Point2d(dimensions.X() / 2.0, - dimensions.Y() / 2.0)
            )
        );
    }

    private Rectangle(Set<Point2d> coords) {
        super(coords);
    }

    // Appliquer la translation sur la forme
    @Override
    public Rectangle translate(Point2d point) {
        return new Rectangle(super.translate(point).getCoords());
    }

    // Appliquer la rotation sur la forme
    @Override
    public Rectangle rotate(Double angle) {
        return new Rectangle(super.rotate(angle).getCoords());
    }

    // Retourne une nouvelle forme.
    @Override
    public Rectangle clone() {
        return new Rectangle(this.getCoords());
    }
}
