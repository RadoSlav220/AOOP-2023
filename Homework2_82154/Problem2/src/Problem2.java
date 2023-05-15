import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Problem2 extends Application {
    private static final double SCENE_SIZE = 500;
    private static final double OFFSET = 50;

    //Half the count of horizontal lines (which is equal to the count of vertical lines)
    private static final int LINES_COUNT = 5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, SCENE_SIZE, SCENE_SIZE);

        double distanceBetweenLines = (SCENE_SIZE - OFFSET * 2) / (LINES_COUNT * 2);

        //First horizontal lines
        for (int i=0; i<LINES_COUNT; ++i){
            Line line = new Line(
                                OFFSET + i * distanceBetweenLines,
                               OFFSET + i * distanceBetweenLines,
                               SCENE_SIZE - OFFSET - i * distanceBetweenLines,
                               OFFSET + i * distanceBetweenLines);
            line.setStroke(Color.RED);
            group.getChildren().add(line);
        }

        //Second horizontal lines
        for (int i=0; i<LINES_COUNT; ++i){
            Line line = new Line(
                    OFFSET + i * distanceBetweenLines,
                    SCENE_SIZE - OFFSET - i * distanceBetweenLines,
                    SCENE_SIZE - OFFSET - (i + 1) * distanceBetweenLines,
                    SCENE_SIZE - OFFSET - i * distanceBetweenLines);
            line.setStroke(Color.RED);
            group.getChildren().add(line);
        }

        //First vertical lines
        for (int i=0; i<LINES_COUNT; ++i){
            Line line = new Line(
                                OFFSET + i * distanceBetweenLines,
                               OFFSET + i * distanceBetweenLines,
                               OFFSET + i * distanceBetweenLines,
                               SCENE_SIZE - OFFSET - i * distanceBetweenLines);
            line.setStroke(Color.RED);
            group.getChildren().add(line);
        }

        //Second vertical lines
        for (int i=0; i<LINES_COUNT; ++i){
            Line line = new Line(
                    SCENE_SIZE - OFFSET - (i + 1) * distanceBetweenLines,
                    OFFSET + (i + 1) * distanceBetweenLines,
                    SCENE_SIZE - OFFSET - (i + 1) * distanceBetweenLines,
                    SCENE_SIZE - OFFSET - i * distanceBetweenLines);
            line.setStroke(Color.RED);
            group.getChildren().add(line);
        }

        stage.setTitle("Draw square shaped spiral");
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}