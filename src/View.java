import UIElements.DigitTextField;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class View {
    private TextField GUIx;
    private TextField GUIy;
    private Label GUISum;
    private Button GUIButton;

    private Controller controller;

    public View(Controller controller, GridPane rootPane) {
        this.controller = controller;

        GUIPane(rootPane);
        setupViewToModelUpdates();
        setupModelToViewUpdates();
    }

    private void setupModelToViewUpdates() {
        controller.BindX((value) -> GUIx.setText(value.toString()));
        controller.BindY((value) -> GUIy.setText(value.toString()));
        controller.BindSum((value) -> GUISum.textProperty().bind(value));
    }

    private void setupViewToModelUpdates() {
        GUIx.textProperty().addListener((o, oldText, newText) -> controller.SetX(newText));
        GUIy.textProperty().addListener((o, oldText, newText) -> controller.SetY(newText));
        GUIButton.setOnAction((o) -> controller.IncreaseModelOfX());
    }

    private void GUIPane(GridPane pane) {
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(5);

        var leftCol = new ColumnConstraints();
        leftCol.setHalignment(HPos.RIGHT);
        leftCol.setHgrow(Priority.NEVER);

        var rightCol = new ColumnConstraints();
        rightCol.setHalignment(HPos.LEFT);
        rightCol.setHgrow(Priority.NEVER);

        pane.getColumnConstraints().addAll(leftCol, rightCol);

        GUIButton = new Button("+10");

        GUIx = new DigitTextField(6);
        GUIy = new DigitTextField(6);
        GUISum = new Label();

        pane.addRow(0, new Label("Increase X:"), GUIButton);
        pane.addRow(1, new Label("X:"), GUIx);
        pane.addRow(2, new Label("Y:"), GUIy);
        pane.addRow(3, new Label("Sum:"), GUISum);
    }
}