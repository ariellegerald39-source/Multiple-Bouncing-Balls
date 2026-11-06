
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class BouncePane extends Pane {

    private ArrayList<Ball> balls = new ArrayList<>();
    private MyTimer timer = new MyTimer();

    public BouncePane() {

        addNewBall();
        addNewBall();
        addNewBall();

        setOnMousePressed(e -> {
            double x = e.getX();
            double y = e.getY();

            for (int i = 0; i < balls.size(); i++) {

                Ball ball = balls.get(i);

                if (insideBall(ball, x, y)) {

                    changeBall(ball);
                    break;
                }
            }
        });

        timer.start();
    }

    public void addNewBall() {

        Random rand = new Random();

        int x = rand.nextInt(400) + 50;
        int y = rand.nextInt(400) + 50;

        Ball ball = new Ball(x, y);

        changeBall(ball);

        balls.add(ball);
        getChildren().add(ball);
    }

    public void changeBall(Ball ball) {

        Random rand = new Random();

        ball.setRadius(rand.nextInt(26) + 5);
        ball.setSpeed(rand.nextInt(10) + 1);
        ball.setDirection(rand.nextInt(360));

        Color color = Color.rgb(
                rand.nextInt(256),
                rand.nextInt(256),
                rand.nextInt(256)
        );

        ball.setFill(color);
        ball.setStroke(color);
    }

    public void scramble() {

        for (int i = 0; i < balls.size(); i++) {

            Ball ball = balls.get(i);

            changeBall(ball);
        }
    }

    public void moveBalls() {

        for (int i = 0; i < balls.size(); i++) {

            Ball ball = balls.get(i);

            ball.move();
            checkCollision(ball);
        }
    }

    public void checkCollision(Ball ball) {

        if (ball.getCenterY() + ball.getRadius() > getHeight()) {
            ball.setCenterY(getHeight() - ball.getRadius() - 1);
            ball.setDirection(360 - ball.getDirection());
        }

        if (ball.getCenterY() - ball.getRadius() < 0) {
            ball.setCenterY(ball.getRadius() + 1);
            ball.setDirection(360 - ball.getDirection());
        }

        if (ball.getCenterX() + ball.getRadius() > getWidth()) {
            ball.setCenterX(getWidth() - ball.getRadius() - 1);
            ball.setDirection(180 - ball.getDirection());
        }

        if (ball.getCenterX() - ball.getRadius() < 0) {
            ball.setCenterX(ball.getRadius() + 1);
            ball.setDirection(180 - ball.getDirection());
        }
    }

    private boolean insideBall(Ball ball, double x, double y) {

        double xDistance = x - ball.getCenterX();
        double yDistance = y - ball.getCenterY();

        double distance = Math.sqrt(
                xDistance * xDistance + yDistance * yDistance
        );

        if (distance < ball.getRadius()) {
            return true;
        }

        return false;
    }

    private class MyTimer extends AnimationTimer {

        @Override
        public void handle(long current) {

            moveBalls();
        }
    }
}
