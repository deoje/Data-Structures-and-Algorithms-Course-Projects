package tp1;

import java.util.*;

public final class PointOperator {
    // Applique la translation sur le vecteur d'entree.
    public static Double[] translate(Double[] vector, Double[] translateVector)
    {
        if (vector.length == translateVector.length){
            for (int i = 0; i < vector.length ; i++) {
                vector[i] += translateVector[i];
            }
            return vector;
        }
        return vector;
    }

    // Applique la rotation sur le vecteur d'entree.
    public static Double[] rotate(Double[] vector, Double[][] rotationMatrix) {

        Double[] rotatedVector = new Double[vector.length];
        double coordinate;
        // Assuming square matrix
        if (vector.length == rotationMatrix.length) {
            for (int i = 0; i < rotationMatrix.length; i++) {
                coordinate = 0;
                for (int j = 0; j < rotationMatrix[i].length; j++) {
                    coordinate += rotationMatrix[i][j] * vector[j];
                }
                rotatedVector[i] = coordinate;
            }

            return rotatedVector;
        }
        return vector;
    }

    // Applique le facteur de division sur le vecteur d'entree.
    public static Double[] divide(Double[] vector, Double divider) {

        if (divider != 0){
            for (int i = 0; i < vector.length; i++) {
                vector[i] /= divider;
            }
        }
        return vector;
    }

    // Applique le facteur de multiplication sur le vecteur d'entree.
    public static Double[] multiply(Double[] vector, Double multiplier) {

        for (int i = 0; i < vector.length ; i++) {
                vector[i] *= multiplier;
        }

        return vector;
    }

    // Applique le facteur d'addition sur le vecteur d'entree.
    public static Double[] add(Double[] vector, Double adder) {

        for (int i = 0; i < vector.length; i++) {
            vector[i] += adder;
        }
        return vector;
    }

    // Retourne la coordonnee avec les plus grandes valeurs en X et en Y.
    public static Point2d getMaxCoord(Collection<Point2d> coords) {

        Double maxX;
        Double maxY;

        Iterator<Point2d> it = coords.iterator();

        Point2d point = it.next();

        maxX = point.X();
        maxY = point.Y();

        while (it.hasNext()){
            point = it.next();
            if (point.X() > maxX) {
                maxX = point.X();
            }
            if (point.Y() > maxY){
                maxY = point.Y();
            }
        }
        return new Point2d(maxX,maxY);
    }

    // Retourne la coordonnee avec les plus petites valeurs en X et en Y.
    public static Point2d getMinCoord(Collection<Point2d> coords) {

        Double minX;
        Double minY;

        Iterator<Point2d> it = coords.iterator();

        Point2d point = it.next();

        minX = point.X();
        minY = point.Y();

        while (it.hasNext()){
            point = it.next();
            if (point.X() < minX) {
                minX = point.X();
            }
            if (point.Y() < minY){
                minY = point.Y();
            }
        }
        return new Point2d(minX,minY);
    }
}
