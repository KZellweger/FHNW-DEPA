package sample.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import sample.Observer;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public class ColorSliders extends Observer implements UiComponent {
    private final Slider sliderRed = new Slider(MIN, MAX, DEFAULT);
    private final Slider sliderGreen = new Slider(MIN, MAX, DEFAULT);
    private final Slider sliderBlue = new Slider(MIN, MAX, DEFAULT);
    private final GridPane gridPane = new GridPane();

    public ColorSliders() {
        initializeControls();
        setupValueChangeListener();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void initializeControls() {
        gridPane.add(sliderRed, 0, 0);
        gridPane.add(sliderGreen, 0, 1);
        gridPane.add(sliderBlue, 0, 2);
    }

    public void setupValueChangeListener() {
        sliderRed.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(!oldValue.equals(newValue)){
                colorSubject.setColor(newValue.intValue(), sliderGreen.valueProperty().intValue(), sliderBlue.valueProperty().intValue());
            }
        });
        sliderGreen.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(!oldValue.equals(newValue)){
                colorSubject.setColor(sliderRed.valueProperty().intValue(), newValue.intValue(), sliderBlue.valueProperty().intValue());
            }
        });
        sliderBlue.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(!oldValue.equals(newValue)){
                colorSubject.setColor(sliderRed.valueProperty().intValue(), sliderGreen.valueProperty().intValue(), newValue.intValue());
            }
        });
    }

    @Override
    public void update() {
        sliderRed.setValue(colorSubject.getColor().getRed());
        sliderGreen.setValue(colorSubject.getColor().getGreen());
        sliderBlue.setValue(colorSubject.getColor().getBlue());
    }
}
