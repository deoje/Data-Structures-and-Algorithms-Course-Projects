package tp1;

import java.util.*;

public final class PointOperator {
    // TODO appliquer la translation sur le vecteur d'entree.
    public static Double[] translate(Double[] vector, Double[] translateVector)
    {
        if (vector.length == translateVector.length){
            for (int i = 0; i < vector.length ; i++) {
                vector[i] += translateVector[i];
            }
            return vector;
        }
        return null;
    }

    // TODO appliquer la rotation sur le vecteur d'entree.
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
        return null;
    }

    // TODO appliquer le facteur de division sur le vecteur d'entree.
    public static Double[] divide(Double[] vector, Double divider) {
        return null;
    }

    // TODO appliquer le facteur de multiplication sur le vecteur d'entree.
    public static Double[] multiply(Double[] vector, Double multiplier) {
        return null;
    }

    // TODO appliquer le facteur d'addition sur le vecteur d'entree.
    public static Double[] add(Double[] vector, Double adder) {
        return null;
    }

    // TODO retourne la coordonnee avec les plus grandes valeurs en X et en Y.
    public static Point2d getMaxCoord(Collection<Point2d> coords) {
        return null;
    }

    // TODO retourne la coordonnee avec les plus petites valeurs en X et en Y.
    public static Point2d getMinCoord(Collection<Point2d> coords) {
        return null;
    }
}
