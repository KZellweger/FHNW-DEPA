package sample.ui;

import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import sample.ColorSubject;
import sample.Observer;


/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public class TextFieldGroup extends Observer implements UiComponent {

    private final Spinner<Integer> red = new Spinner<>(MIN, MAX, DEFAULT);
    private final Spinner<Integer> green = new Spinner<>(MIN, MAX, DEFAULT);
    private final Spinner<Integer> blue = new Spinner<>(MIN, MAX, DEFAULT);

    private final TextField redHEX = new TextField();
    private final TextField greenHEX = new TextField();
    private final TextField blueHEX = new TextField();

    private final GridPane gridPane = new GridPane();

    public TextFieldGroup(ColorSubject colorSubject) {
        this.colorSubject = colorSubject;
        this.colorSubject.attach(this);
        initializeControls();
        setupValueChangeListener();
    }

    @Override
    public GridPane getGridPane() {
        return gridPane;
    }

    @Override
    public void initializeControls() {
        red.setEditable(true);
        blue.setEditable(true);
        green.setEditable(true);
        redHEX.setEditable(false);
        blueHEX.setEditable(false);
        greenHEX.setEditable(false);
        gridPane.add(red, 0, 0);
        gridPane.add(green, 0, 1);
        gridPane.add(blue, 0, 2);
        gridPane.add(redHEX, 1, 0);
        gridPane.add(greenHEX, 1, 1);
        gridPane.add(blueHEX, 1, 2);

    }

    @Override
    public void setupValueChangeListener() {
        red.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!oldValue.equals(newValue))
                colorSubject.setColor(newValue, colorSubject.intFromFactor(colorSubject.getColor().getGreen()), colorSubject.intFromFactor(colorSubject.getColor().getBlue()));
        });
        green.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!oldValue.equals(newValue))
                colorSubject.setColor(colorSubject.intFromFactor(colorSubject.getColor().getRed()), newValue, colorSubject.intFromFactor(colorSubject.getColor().getBlue()));
        });
        blue.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!oldValue.equals(newValue))
                colorSubject.setColor(colorSubject.intFromFactor(colorSubject.getColor().getRed()), colorSubject.intFromFactor(colorSubject.getColor().getGreen()), newValue);
        });
    }

    @Override
    public void update() {
        red.getValueFactory().setValue(colorSubject.intFromFactor(colorSubject.getColor().getRed()));
        green.getValueFactory().setValue(colorSubject.intFromFactor(colorSubject.getColor().getGreen()));
        blue.getValueFactory().setValue(colorSubject.intFromFactor(colorSubject.getColor().getBlue()));
        redHEX.setText(Integer.toHexString(colorSubject.intFromFactor(colorSubject.getColor().getRed())));
        greenHEX.setText(Integer.toHexString(colorSubject.intFromFactor(colorSubject.getColor().getGreen())));
        blueHEX.setText(Integer.toHexString(colorSubject.intFromFactor(colorSubject.getColor().getBlue())));
    }
}
