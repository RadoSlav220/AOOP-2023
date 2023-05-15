package vue;

/*
!!! The Project is not completed !!!
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    private RouteCipher routeCipher;

    public void initialize(){
        routeCipher = new RouteCipher();
    }

    @FXML
    private TextArea txtInputText;

    @FXML
    private TextArea txtOutputText;

    @FXML
    private Button btnEncrypt;

    @FXML
    private Button btnDecrypt;

    @FXML
    private TextField txtInutNumber;

    @FXML
    private Button btnQuit;

    private void getResult(boolean encryption){
        // !!! verification must be done first (check if input fields are not empty) !!! //
        int key = Integer.parseInt(txtInutNumber.getText());
        String text = txtInputText.getText();
        routeCipher.setKey(key);
        String result = encryption ? routeCipher.encrypt(text) : routeCipher.decrypt(text);
        txtOutputText.setText(result);
    }

    @FXML
    void btnDecryptOnAction(ActionEvent event) {
        getResult(false);
    }

    @FXML
    void btnEncryptOnAction(ActionEvent event) {
        getResult(true);
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }
}
