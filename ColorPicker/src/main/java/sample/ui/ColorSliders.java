package sample.ui;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import sample.ColorSubject;
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

    public ColorSliders(ColorSubject colorSubject) {
        this.colorSubject = colorSubject;
        this.colorSubject.attach(this);
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
                colorSubject.setColor(newValue.intValue(), colorSubject.intFromFactor(colorSubject.getColor().getGreen()), colorSubject.intFromFactor(colorSubject.getColor().getBlue()));
            }
        });
        sliderGreen.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(!oldValue.equals(newValue)){
                colorSubject.setColor(colorSubject.intFromFactor(colorSubject.getColor().getRed()), newValue.intValue(), colorSubject.intFromFactor(colorSubject.getColor().getBlue()));
            }
        });
        sliderBlue.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(!oldValue.equals(newValue)){
                colorSubject.setColor(colorSubject.intFromFactor(colorSubject.getColor().getRed()), colorSubject.intFromFactor(colorSubject.getColor().getGreen()), newValue.intValue());
            }
        });

    }

    @Override
    public void update() {
        sliderRed.setValue(colorSubject.intFromFactor(colorSubject.getColor().getRed()));
        sliderGreen.setValue(colorSubject.intFromFactor(colorSubject.getColor().getGreen()));
        sliderBlue.setValue(colorSubject.intFromFactor(colorSubject.getColor().getBlue()));
    }

}