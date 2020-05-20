package ua.khpi.oop.kononenko16;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class LoadController {
    private String path;
    @FXML
    private TextField LoadField;

    @FXML
    private Button LoadButton;

    @FXML
    void initialize() {

        LoadButton.setOnAction(actionEvent -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Load file");
            File defaultDirectory = new File(".");
            chooser.setInitialDirectory(defaultDirectory);
            File selectedFile = chooser.showOpenDialog((((Button) actionEvent.getSource()).getScene().getWindow()));
            try {
                if (selectedFile.getName().endsWith(".xml")) {
                    path = selectedFile.getPath();
                    LoadField.setText(path);
                }
            } catch (NullPointerException ignored) {

            }

            if (new File(path).exists()) {
                Collections.list.clear();
                Collections.tripObservableList.clear();
                Collections.list.addAll(Serialization.LongTermPersistenceRead(path));
                Collections.tripObservableList.addAll(Collections.list);
                LoadButton.getScene().getWindow().hide();
            }
        });
    }

}
