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
    private GridPane rootPane;
    private TextField xValue;
    private TextField yValue;
    private Label sum;
    private Button increaseXButton;

    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        this.rootPane = new GridPane();

        createView();
        setupModelToViewUpdates();
        setupViewToModelUpdates();
    }

    private void createView() {
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(5);

        var leftCol = new ColumnConstraints();
        leftCol.setHalignment(HPos.RIGHT);
        leftCol.setHgrow(Priority.NEVER);

        var rightCol = new ColumnConstraints();
        rightCol.setHalignment(HPos.LEFT);
        rightCol.setHgrow(Priority.NEVER);

        rootPane.getColumnConstraints().addAll(leftCol, rightCol);

        increaseXButton = new Button("+10");
        xValue = new DigitTextField(6);
        yValue = new DigitTextField(6);
        sum = new Label();

        rootPane.addRow(0, new Label("Increase X:"), increaseXButton);
        rootPane.addRow(1, new Label("X:"), xValue);
        rootPane.addRow(2, new Label("Y:"), yValue);
        rootPane.addRow(3, new Label("Sum:"), sum);
    }

    private void setupModelToViewUpdates() {
        controller.BindX((value) -> xValue.setText(value.toString()));
        controller.BindY((value) -> yValue.setText(value.toString()));
        controller.BindSum((value) -> sum.textProperty().bind(value));
    }

    private void setupViewToModelUpdates() {
        xValue.textProperty().addListener((o, oldText, newText) -> controller.SetX(newText));
        yValue.textProperty().addListener((o, oldText, newText) -> controller.SetY(newText));
        increaseXButton.setOnAction((o) -> controller.IncreaseModelOfX());
    }

    public GridPane GetRoot() {
        return rootPane;
    }
}