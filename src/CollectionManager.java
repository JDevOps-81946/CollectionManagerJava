import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CollectionManager extends Application {
    public void start(Stage primaryStage) {
        var model = new SumModel(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        var controller = new Controller(model);
        var view = new View(controller);

        var scene = new Scene(view.GetRoot(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
