import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

public class SumModel {
    private final IntegerProperty a;
    private final IntegerProperty b;
    private final ReadOnlyIntegerWrapper sum = new ReadOnlyIntegerWrapper();

    public SumModel(IntegerProperty a, IntegerProperty b)
    {
        this.a = a;
        this.b = b;
        sum.bind(this.a.add(this.b));
    }

    public final IntegerProperty aProperty() {
        return this.a;
    }
    public final int getA() {
        return this.aProperty().get();
    }
    public final void setA(final int a) { this.aProperty().set(a); }

    public final IntegerProperty bProperty() {
        return this.b;
    }
    public final int getB() {
        return this.bProperty().get();
    }
    public final void setB(final int b) {
        this.bProperty().set(b);
    }

    public final ReadOnlyIntegerWrapper sumProperty() {
        return this.sum;
    }
}