package sample.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.layout.*;
import sample.ColorSubject;

/**
 * @author Kevin Zellweger
 * @Date 15.09.20
 */
public class MainView extends BorderPane {
    private ColorSubject colorSubject = new ColorSubject();
    private final Menu menu = new Menu();

    private final ColorField colorField = new ColorField(colorSubject);
    private final ColorSliders colorSliders = new ColorSliders(colorSubject);
    private final ColorChooser colorChooser = new ColorChooser(colorSubject);
    private final TextFieldGroup textFieldGroup = new TextFieldGroup(colorSubject);
    private final GridPane gridPane = new GridPane();
    private final ColumnConstraints cGrow = new ColumnConstraints();
    private final ColumnConstraints cNoGrow = new ColumnConstraints();
    private final RowConstraints rGrow = new RowConstraints();
    private final RowConstraints rNoGrow = new RowConstraints();
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
        gridPane.add(colorSliders.getGridPane(),0,0);
        gridPane.add(colorField.getGridPane(),0,1);
        gridPane.add(textFieldGroup.getGridPane(),1,0);
        gridPane.add(colorChooser.getGridPane(),1,1);

        setCenter(gridPane);
    }


}
