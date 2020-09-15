package sample.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.layout.*;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public class MainView extends BorderPane {
    private Menu menu = new Menu();
    private ColorField colorField = new ColorField();
    private ColorSliders colorSliders = new ColorSliders();
    private ColorChooser colorChooser = new ColorChooser();
    private TextFieldGroup textFieldGroup = new TextFieldGroup();

    private GridPane gridPane = new GridPane();
    private ColumnConstraints cGrow = new ColumnConstraints();
    private ColumnConstraints cNoGrow = new ColumnConstraints();
    private RowConstraints rGrow = new RowConstraints();
    private RowConstraints rNoGrow = new RowConstraints();
    public MainView (){
        layoutControls();
    }

    private void layoutControls(){
        setMinHeight(400);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        setPadding(new Insets(5));
        cGrow.setHgrow(Priority.ALWAYS);
        cNoGrow.setHgrow(Priority.NEVER);
        rGrow.setVgrow(Priority.ALWAYS);
        rNoGrow.setVgrow(Priority.NEVER);
        gridPane.add(colorSliders,0,0);
        gridPane.add(colorField,0,1);
        gridPane.add(textFieldGroup,1,0);
        gridPane.add(colorChooser,1,1);

        setCenter(gridPane);
    }


}
