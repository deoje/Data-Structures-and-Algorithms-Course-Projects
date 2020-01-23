package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    // TODO creer un point en 2d avec 2 donnees // FAIT?
    public Point2d(Double x, Double y) {
        super(new Double[]{x,y});
    }

    // TODO creer un point a partir d'un vecteur de donnees // FAIT?
    public Point2d(Double[] vector) {
        super(vector);
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    // TODO prendre un vecteur de donnees et appliquer la translation. // FAIT
    @Override
    public Point2d translate(Double[] translateVector) {
        if (this.vector.length == translateVector.length){
            for (int i = 0; i < this.vector.length ; i++) {
                this.vector[i] += translateVector[i];
            }
        }
        return this;
    }

    // TODO prendre un point et appliquer la translation. // FAIT
    public Point2d translate(Point2d translateVector) {
        if (this.vector.length == translateVector.vector.length){
            for (int i = 0; i < this.vector.length ; i++) {
                this.vector[i] += translateVector.vector[i];
            }
        }
        return this;
    }

    // TODO prendre un vecteur de donnees et appliquer la rotation. // FAIT?
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
            Point2d rotatedVectorEnd = new Point2d(rotatedVector);
            return rotatedVectorEnd;
        }
        return this;
    }

    // TODO prendre un angle de rotation, creer une matrice et appliquer la rotation. FAIT?
    public Point2d rotate(Double angle) {
        Double[][] rotationMatrix = new Double[2][2];
        rotationMatrix[0][0] = Math.cos(angle);
        rotationMatrix[0][1] = Math.sin(angle);
        rotationMatrix[1][0] = -Math.sin(angle);
        rotationMatrix[1][1] = Math.cos(angle);
        return rotate(rotationMatrix);
    }

    // TODO prendre un facteur de division et l'appliquer. FAIT?
    @Override
    public Point2d divide(Double divider) {
        if (divider != 0){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] /= divider;
            }
        }
        return this;
    }

    // TODO prendre un facteur de multiplication et l'appliquer. FAIT?
    @Override
    public Point2d multiply(Double multiplier) {
        for (int i = 0; i < this.vector.length ; i++) {
            this.vector[i] *= multiplier;
        }

        return this;
    }

    // TODO prendre un facteur d'addition et l'appliquer. FAIT?
    @Override
    public Point2d add(Double adder) {
        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] += adder;
        }
        return this;
    }

    // TODO creer un nouveau point. FAIT?
    @Override
    public Point2d clone() {
        Point2d objetClone = this;
        return objetClone;
    }
}
