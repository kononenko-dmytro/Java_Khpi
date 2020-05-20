package ua.khpi.oop.kononenko16;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class EditorController {
    private boolean add = true;
    StringBuilder stringBuilder = new StringBuilder();
    private ArrayList<Station> stations = new ArrayList<>();
    private ObservableList<Station> data = FXCollections.observableArrayList();
    Trip trip = new Trip();

    @FXML
    private TextArea listArea;

    @FXML
    private TextField numberField;

    @FXML
    private TextField sitsField;

    @FXML
    private TextField timeField;

    @FXML
    private TextField daysField;

    @FXML
    private TextField stationField;

    @FXML
    private TextField timeSTField;

    @FXML
    private Button listAdd;

    @FXML
    private Button addAll;

    @FXML
    void addElem(ActionEvent event) { }

    @FXML
    void addList(ActionEvent event) {

        try {
            if (!stationField.getText().isEmpty() && !timeSTField.getText().isEmpty()) {
                Station temp = new Station();
                temp.setName(stationField.getText());
                temp.setTime(parser(timeSTField.getText()));
                stationField.setText("");
                timeSTField.setText("");
                listArea.setText(stringBuilder.append(temp.toString() + "\n").toString());
                stations.add(temp);
            }
        } catch (Exception e) {
            System.err.println(e.getCause());
        }
    }

    private static MyDate parser(String input) {
        MyDate output = new MyDate();

        String[] arrOfStr = input.split(":");

        output.setHours(Integer.parseInt(arrOfStr[0]));
        output.setMinutes(Integer.parseInt(arrOfStr[1]));

        return output;
    }

    @FXML
    void initialize() {

        addAll.setOnAction(actionEvent -> {

            StringBuilder sb = new StringBuilder();
            boolean add = true;
            int i = 1;
            String number = numberField.getText();
            String time = timeField.getText();
            String days = daysField.getText();
            String sits = sitsField.getText();


            if (!Regex.checkNum(number)) {
                add = false;
                sb.append(i++).append(") Error in Number(xxxxFF).\n");
            }

            if (!Regex.checkTime(time)) {
                add = false;
                sb.append(i++).append(") Error in Time\n");
            }
            if (!Regex.checkDays(days)) {
                add = false;
                sb.append(i++).append(") Error in Days\n");
            }
            if (!Regex.checkSits(sits)) {
                add = false;
                sb.append(i++).append(") Error in Sits\n");
            }


            try {
                if (add) {
                    trip.setDays(days);
                    trip.setDeparture(parser(time));
                    trip.setNumTrip(number);
                    trip.setSits(Integer.parseInt(sits));
                    trip.setStorage(stations);
                    System.out.println(trip);
                    Collections.list.add(trip);
                    Collections.tripObservableList.add(trip);
                    addAll.getScene().getWindow().hide();
                }
            } catch (Exception e) {
                System.err.println(e.getCause());
            }
        });

    }
}