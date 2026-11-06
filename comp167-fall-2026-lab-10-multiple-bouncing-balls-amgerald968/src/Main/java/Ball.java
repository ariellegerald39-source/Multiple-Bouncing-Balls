import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
    private int speed = 5;

    private double direction = 200;
    private static final double TWO_PI = Math.PI*2;

    public Ball( int xLoc, int yLoc ) {
        this.setCenterX( xLoc );
        this.setCenterY( yLoc );
        this.setRadius( 15 );

        this.setStroke(Color.RED);
        this.setFill(Color.RED);
    }

    public void move() {
        this.setCenterX(this.getCenterX() +
                getSpeed() * Math.cos(Math.toRadians(getDirection())));

        this.setCenterY(this.getCenterY() +
                getSpeed() * Math.sin(Math.toRadians(getDirection())));
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
}
