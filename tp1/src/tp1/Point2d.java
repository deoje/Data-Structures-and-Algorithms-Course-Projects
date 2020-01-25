package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    // Cree un point en 2d avec 2 donnees
    public Point2d(Double x, Double y) {
        super(new Double[]{x,y});
    }

    // Cree un point a partir d'un vecteur de donnees
    public Point2d(Double[] vector) {
        super(new Double[]{vector[0],vector[1]});
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    // Prend un vecteur de donnees et applique la translation.
    @Override
    public Point2d translate(Double[] translateVector) {

//        Point2d point = new Point2d(vector);
//
//        if (point.vector.length == translateVector.length){
//            for (int i = 0; i < point.vector.length ; i++) {
//                point.vector[i] += translateVector[i];
//            }
//        }
//        return point;

        return new Point2d(PointOperator.translate(vector.clone(),translateVector));

    }

    // Prendre un point et appliquer la translation.
    public Point2d translate(Point2d translateVector) {
//        if (this.vector.length == translateVector.vector.length){
//            for (int i = 0; i < this.vector.length ; i++) {
//                this.vector[i] += translateVector.vector[i];
//            }
//        }
        return translate(translateVector.vector.clone());
    }

    // Prend un vecteur de donnees et appliquer la rotation.
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
//        Double[] rotatedVector = new Double[vector.length];
//        double coordinate;
//        // Assuming square matrix
//        if (vector.length == rotationMatrix.length) {
//            for (int i = 0; i < rotationMatrix.length; i++) {
//                coordinate = 0;
//                for (int j = 0; j < rotationMatrix[i].length; j++) {
//                    coordinate += rotationMatrix[i][j] * vector[j];
//                }
//                rotatedVector[i] = coordinate;
//            }
//            return new Point2d(rotatedVector);
//        }
//        return this;

        return new Point2d(PointOperator.rotate(vector.clone(),rotationMatrix));
    }

    // TODO prendre un angle de rotation, creer une matrice et appliquer la rotation. FAIT?
    public Point2d rotate(Double angle) {
        Double[][] rotationMatrix = new Double[2][2];
        rotationMatrix[0][0] = Math.cos(angle);
        rotationMatrix[0][1] = -Math.sin(angle);
        rotationMatrix[1][0] = Math.sin(angle);
        rotationMatrix[1][1] = Math.cos(angle);
        return rotate(rotationMatrix);
    }

    // Prendre un facteur de division et l'appliquer
    @Override
    public Point2d divide(Double divider) {
//        Point2d point = new Point2d(this.vector);
//        if (divider != 0){
//            for (int i = 0; i < point.vector.length; i++) {
//                point.vector[i] /= divider;
//            }
//        }
//        return point;
        return new Point2d(PointOperator.divide(vector.clone(),divider));
    }

    // Prend un facteur de multiplication et l'applique
    @Override
    public Point2d multiply(Double multiplier) {
        Point2d point = new Point2d(this.vector);
//
//        for (int i = 0; i < point.vector.length ; i++) {
//            point.vector[i] *= multiplier;
//        }
//
//        return point;
        return new Point2d(PointOperator.multiply(vector.clone(),multiplier));
    }

    // Prendre un facteur d'addition et l'applique
    @Override
    public Point2d add(Double adder) {
//        Point2d point = new Point2d(this.vector);
//        for (int i = 0; i < point.vector.length; i++) {
//            point.vector[i] += adder;
//        }
//        return point;
        return new Point2d(PointOperator.add(vector.clone(),adder));
    }

    // Creer un nouveau point
    @Override
    public Point2d clone() {
        return new Point2d(vector.clone());
    }
}
