package sample.ui;

import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import sample.ColorSubject;
import sample.Observer;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public class ColorChooser extends Observer implements UiComponent {

    private final RadioButton red = new RadioButton("Red");
    private final RadioButton green = new RadioButton("Green");
    private final RadioButton blue = new RadioButton("Blue");
    private final RadioButton yellow = new RadioButton("Yellow");
    private final RadioButton cyan = new RadioButton("Cyan");
    private final RadioButton orange = new RadioButton("Orange");
    private final RadioButton white = new RadioButton("White");
    private final RadioButton black = new RadioButton("Black");
    private final ToggleGroup buttonGroup = new ToggleGroup();

    private final GridPane gridPane = new GridPane();

    public ColorChooser(ColorSubject colorSubject) {
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
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        buttonGroup.getToggles().addAll(red, green, blue, yellow, cyan, orange, white, black);
        red.setUserData(Color.RED);
        green.setUserData(Color.LIME);
        blue.setUserData(Color.BLUE);
        yellow.setUserData(Color.YELLOW);
        cyan.setUserData(Color.CYAN);
        orange.setUserData(Color.ORANGE);
        white.setUserData(Color.WHITE);
        black.setUserData(Color.BLACK);
        gridPane.add(red, 0, 0);
        gridPane.add(green, 0, 1);
        gridPane.add(blue, 0, 2);
        gridPane.add(yellow, 0, 4);
        gridPane.add(cyan, 0, 5);
        gridPane.add(orange, 0, 6);
        gridPane.add(white, 0, 7);
        gridPane.add(black, 0, 8);
    }

    @Override
    public void setupValueChangeListener() {
        buttonGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (buttonGroup.getSelectedToggle() != null) {
                colorSubject.setColor((Color) newValue.getUserData());
            }
        });
    }

    @Override
    public void update() {
        Toggle current = buttonGroup.getToggles().stream()
                .filter(toggle -> colorSubject.getColor().equals(toggle.getUserData()))
                .findFirst().orElse(null);

        buttonGroup.selectToggle(current);

    }
}
