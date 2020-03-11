package UIElements;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class DigitTextField extends TextField {

    public DigitTextField(int maxDigits) {
        super();
        RestrictToDigits(maxDigits);
    }

    private void RestrictToDigits(int maxDigits) {
        this.setTextFormatter(new TextFormatter<Integer>((TextFormatter.Change newValue) ->
                newValue.getControlNewText().matches("\\d{0," + maxDigits + "}") ? newValue : null));
    }
}