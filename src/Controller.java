import javafx.beans.value.ObservableValue;
import java.util.function.Consumer;

public class Controller {
    private final SumModel model;

    public Controller(SumModel model) {
        this.model = model ;
    }

    private void SetIntModel(String value, Consumer<Integer> integerSetMethod) {
        if (value != null && !value.equals("")) integerSetMethod.accept(Integer.parseInt(value));
    }

    public void SetX(String value) {
        SetIntModel(value, model::setA);
    }

    public void SetY(String value) {
        SetIntModel(value, model::setB);
    }

    public void IncreaseModelOfX() {
        model.setA(model.getA() + 10);
    }

    public void BindSum(Consumer<ObservableValue<String>> converter) {
        converter.accept(model.sumProperty().asString());
    }

    public void BindX(Consumer<Number> converter) {
        model.aProperty().addListener((observer, oldValue, newValue) -> converter.accept(newValue));
    }

    public void BindY(Consumer<Number> converter) {
        model.bProperty().addListener((observer, oldValue, newValue) -> converter.accept(newValue));
    }
}