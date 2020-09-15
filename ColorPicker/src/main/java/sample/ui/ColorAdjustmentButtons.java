package sample.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import sample.ColorSubject;
import sample.Observer;

/**
 * @author Kevin Zellweger
 * @Date 17.09.20
 */
public class ColorAdjustmentButtons extends Observer implements UiComponent {
    private GridPane gridPane = new GridPane();
    private Button brighter = new Button("Brighter");
    private Button darker = new Button("Darker");

    public ColorAdjustmentButtons(ColorSubject colorSubject) {
        this.colorSubject = colorSubject;
        colorSubject.attach(this);
        initializeControls();
        addActionListener();
    }

    @Override
    public void addActionListener() {
        brighter.setOnAction(event -> {
            colorSubject.setColor(colorSubject.getColor().brighter());
        });
        darker.setOnAction(event -> {
            colorSubject.setColor(colorSubject.getColor().darker());
        });
    }

    @Override
    public GridPane getGridPane() {
        return gridPane;
    }

    @Override
    public void initializeControls() {
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(brighter,0,0);
        gridPane.add(darker,0,1);

    }

    @Override
    public void update() {
        double brightness = colorSubject.getColor().getBrightness();
        if(brightness == 0.0){
            darker.disableProperty().setValue(true);
            brighter.disableProperty().set(false);
        }else if(brightness == 1.0){
            darker.disableProperty().setValue(false);
            brighter.disableProperty().set(true);
        }else{
            darker.disableProperty().setValue(false);
            brighter.disableProperty().setValue(false);
        }


    }
}
