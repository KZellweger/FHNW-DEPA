package sample.ui;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import sample.ColorSubject;
import sample.Observer;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public class ColorField extends Observer implements UiComponent {
    private final Rectangle colorField = new Rectangle(120, 50);
    private final GridPane gridPane = new GridPane();

    public ColorField(ColorSubject colorSubject)
    {
        this.colorSubject = colorSubject;
        this.colorSubject.attach(this);
        initializeControls();
    }

    @Override
    public GridPane getGridPane() {
        return gridPane;
    }

    @Override
    public void initializeControls() {
        gridPane.add(colorField, 0, 0);
    }

    @Override
    public void update() {
        colorField.setFill(colorSubject.getColor());
    }
}
