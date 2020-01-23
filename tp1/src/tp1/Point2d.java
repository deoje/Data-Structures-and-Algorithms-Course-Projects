package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    // Cree un point en 2d avec 2 donnees
    public Point2d(Double x, Double y) {
        super(new Double[]{x,y});
    }

    // Cree un point a partir d'un vecteur de donnees
    public Point2d(Double[] vector) { super(vector.clone()); }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    // Prend un vecteur de donnees et applique la translation.
    @Override
    public Point2d translate(Double[] translateVector) {

        Point2d point = new Point2d(this.vector);

        if (point.vector.length == translateVector.length){
            for (int i = 0; i < point.vector.length ; i++) {
                point.vector[i] += translateVector[i];
            }
        }
        return point;
    }

    // TODO prendre un point et appliquer la translation. // FAIT?
    public Point2d translate(Point2d translateVector) {
        if (this.vector.length == translateVector.vector.length){
            for (int i = 0; i < this.vector.length ; i++) {
                this.vector[i] += translateVector.vector[i];
            }
        }
        return this;
    }

    // Prend un vecteur de donnees et appliquer la rotation.
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        Double[] rotatedVector = new Double[this.vector.length];
        double coordinate;
        // Assuming square matrix
        if (this.vector.length == rotationMatrix.length) {
            for (int i = 0; i < rotationMatrix.length; i++) {
                coordinate = 0;
                for (int j = 0; j < rotationMatrix[i].length; j++) {
                    coordinate += rotationMatrix[i][j] * this.vector[j];
                }
                rotatedVector[i] = coordinate;
            }
            return new Point2d(rotatedVector);
        }
        return this;
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
        Point2d point = new Point2d(this.vector);
        if (divider != 0){
            for (int i = 0; i < point.vector.length; i++) {
                point.vector[i] /= divider;
            }
        }
        return point;
    }

    // Prendre un facteur de multiplication et l'appliquer
    @Override
    public Point2d multiply(Double multiplier) {
        Point2d point = new Point2d(this.vector);

        for (int i = 0; i < point.vector.length ; i++) {
            point.vector[i] *= multiplier;
        }

        return point;
    }

    // TODO prendre un facteur d'addition et l'appliquer. FAIT?
    @Override
    public Point2d add(Double adder) {
        Point2d point = new Point2d(this.vector);
        for (int i = 0; i < point.vector.length; i++) {
            point.vector[i] += adder;
        }
        return point;
    }

    // Creer un nouveau point
    @Override
    public Point2d clone() {
        Point2d objetClone = new Point2d(this.vector);
        return objetClone;
    }
}
