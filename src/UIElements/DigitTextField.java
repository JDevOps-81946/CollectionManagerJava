package UIElements;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class DigitTextField extends TextField {

    public DigitTextField(int maxDigits) {
        super();
        GUIRestrictToDigits(maxDigits);
    }

    private void GUIRestrictToDigits(int maxDigits) {
        this.setTextFormatter(new TextFormatter<Integer>((TextFormatter.Change newValue) ->
                newValue.getControlNewText().matches("\\d{0,6}") ? newValue : null));
    }
}