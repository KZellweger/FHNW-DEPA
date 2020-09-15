package sample.ui;

import javafx.scene.layout.GridPane;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public interface UiComponent {
    Integer DEFAULT = 0;
    Integer MAX = 255;
    Integer MIN = 0;
    default void addActionListener() {
    }

    GridPane getGridPane();

    void initializeControls();

    default void setupValueChangeListener() {

    }
}
