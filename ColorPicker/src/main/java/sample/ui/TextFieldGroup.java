package sample.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import sample.Observer;



/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public class TextFieldGroup extends Observer implements UiComponent {

    private final Spinner<Integer> red = new Spinner<>(MIN,MAX,DEFAULT);
    private final Spinner<Integer> green = new Spinner<>(MIN,MAX,DEFAULT);
    private final Spinner<Integer> blue = new Spinner<>(MIN,MAX,DEFAULT);

    private final TextField redHEX = new TextField();
    private final TextField greenHEX = new TextField();
    private final TextField blueHEX = new TextField();

    private final GridPane gridPane = new GridPane();

    @Override
    public GridPane getGridPane() {
        return gridPane;
    }

    @Override
    public void initializeControls() {
        redHEX.setEditable(false);
        blueHEX.setEditable(false);
        greenHEX.setEditable(false);
        gridPane.add(red,0,0);
        gridPane.add(green,0,1);
        gridPane.add(blue,0,2);

    }

    @Override
    public void setupValueChangeListener() {
        red.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(!oldValue.equals(newValue))
            colorSubject.setColor(newValue,green.getValue(),blue.getValue());
        });
        green.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(!oldValue.equals(newValue))
            colorSubject.setColor(red.getValue(), newValue,blue.getValue());
        });
        red.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(!oldValue.equals(newValue))
            colorSubject.setColor(red.getValue(),green.getValue(), newValue);
        });
    }

    @Override
    public void update() {
        red.getValueFactory().setValue((int) colorSubject.getColor().getRed());
        green.getValueFactory().setValue((int) colorSubject.getColor().getGreen());
        blue.getValueFactory().setValue((int) colorSubject.getColor().getBlue());
        redHEX.setText(Integer.toHexString((int) colorSubject.getColor().getRed()));
        blueHEX.setText(Integer.toHexString((int) colorSubject.getColor().getGreen()));
        greenHEX.setText(Integer.toHexString((int) colorSubject.getColor().getBlue()));
    }
}
