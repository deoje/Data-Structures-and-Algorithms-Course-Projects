package tp1;

import java.lang.reflect.Array;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rectangle extends BaseShape {
    // Cree un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        super();
        for (double i =  - width / 2; i < width / 2; i++) {
            for (double j =  - height / 2; j < height / 2; j++) {
                add(new Point2d(i,j));
            }
        }
    }

    // Creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions) {
        super();
        for (double i = - dimensions.X() / 2; i < dimensions.X() / 2; i++){
            for (double j = - dimensions.Y() / 2; j < dimensions.Y() / 2; j++){
                add(new Point2d(i,j));
            }
        }
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
