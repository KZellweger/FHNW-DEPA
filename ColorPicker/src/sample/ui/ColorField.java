package sample.ui;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import sample.Observer;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public class ColorField extends Observer {
    private Rectangle colorField = new Rectangle(120,50);
    @Override
    public void update() {
        colorField.setFill(colorSubject.getColor());
    }
}
