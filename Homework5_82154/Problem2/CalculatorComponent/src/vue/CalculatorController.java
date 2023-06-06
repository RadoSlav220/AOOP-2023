package vue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CalculatorController extends AnchorPane {

    @FXML
    private Button offButton;

    public CalculatorController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vue/calculatorScene.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void offButtonOnAction(ActionEvent event) {
        System.exit(0);
    }

}
