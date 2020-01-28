package tp1;

import java.util.HashSet;
import java.util.Set;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 10;

    public static BaseShape create_H() {
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftVerticalStripe = mainStripe.translate(new Point2d(- halfMaxWidth, 0.0));
        BaseShape horizontalStripe = new Rectangle(stripeThickness, maxWidth).rotate(Math.toRadians(90));
        BaseShape rightVerticalStripe = mainStripe.translate(new Point2d(halfMaxWidth, 0.0));
        leftVerticalStripe.add(horizontalStripe);
        leftVerticalStripe.add(rightVerticalStripe);
        return leftVerticalStripe;
    }

    public static BaseShape create_e() {
        BaseShape ellipse = new Ellipse(maxWidth / 2.0, halfMaxHeight);
        ellipse.removeAll(Ellipse.ellipseParametricEquationPoints(
                maxWidth / 2.0, halfMaxHeight, 100.0, 0.0, 0.125*Math.PI
                ));
        BaseShape horizontalStripe = new Rectangle(stripeThickness / 2.0, halfMaxHeight).rotate(Math.toRadians(90));
        ellipse.add(horizontalStripe);
        return ellipse;
    }

    public static BaseShape create_l()
    {
        return new Rectangle(stripeThickness, maxHeight);
    }

    public static BaseShape create_o() {
        return new Ellipse(maxWidth / 2.0, halfMaxHeight);
    }

    // On vous donne la lettre W comme exemple.
    public static BaseShape create_W() {
        Double degrees15 = Math.toRadians(8);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.rotate(-degrees15).translate(new Point2d(-spacing, 0.0));
        BaseShape middleLeftStripe = mainStripe.rotate(degrees15).translate(new Point2d(-spacing / 3, 0.0));
        BaseShape middleRightStripe = mainStripe.rotate(-degrees15).translate(new Point2d(spacing / 3, 0.0));
        BaseShape rightStripe = mainStripe.rotate(degrees15).translate(new Point2d(spacing, 0.0));
        leftStripe.add(middleLeftStripe);
        leftStripe.add(middleRightStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }
    
    public static BaseShape create_r() {
        BaseShape ellipse = new Ellipse(maxWidth / 2.0, halfMaxHeight / 2.0);
        ellipse.removeAll(Ellipse.ellipseParametricEquationPoints(
                maxWidth / 2.0,halfMaxHeight / 2.0, 100, 0, Math.PI));
        ellipse = ellipse.translate(new Point2d(0.0, - maxHeight / 5.0));
        BaseShape verticalStripe = new Rectangle(stripeThickness, maxHeight).translate(new Point2d(- maxWidth / 2.5, 0.0));
        ellipse.add(verticalStripe);
        return ellipse;
    }

    public static BaseShape create_d() {
        BaseShape leftCircle = new Circle(halfMaxHeight / 2.0).translate(new Point2d(0.0, halfMaxHeight / 3));
        BaseShape rightVerticalStripe = new Rectangle(stripeThickness,maxHeight).translate(new Point2d(halfMaxWidth,0.0));
        leftCircle.add(rightVerticalStripe);
        return leftCircle;
    }
}
