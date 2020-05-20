package ua.khpi.oop.kononenko16;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Controller {

    @FXML
    private AnchorPane daysRadioButton;

    @FXML
    private TableView<Trip> table;

    @FXML
    private TableColumn<Trip, String> NumberColumn;

    @FXML
    private TableColumn<Trip, Integer> SitsColumn;

    @FXML
    private TableColumn<Trip, String> TimeColumn;

    @FXML
    private TableColumn<Trip, String> DaysColumn;

    @FXML
    private TableColumn<Trip, String> StationsColumn;

    @FXML
    private Button signUpButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button sortButton;

    @FXML
    private Button searchButton;

    @FXML
    private RadioButton numberSortRadio;

    @FXML
    private ToggleGroup sort;

    @FXML
    private RadioButton sitsSortRadio;

    @FXML
    private RadioButton timeSortRadio;

    @FXML
    private RadioButton numberRadioSearch;

    @FXML
    private ToggleGroup search;

    @FXML
    private RadioButton StationRadioSearch;

    @FXML
    private RadioButton daysRadioSearch;

    @FXML
    private TextField searchPredicateField;

    @FXML
    private TextField countOfGeneratedField;

    @FXML
    private Button generateButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button loadDataButton;

    @FXML
    private Button saveDataButton;

    @FXML
    private Button removeButton;

    private int extractInt(String s) {
        String num = s.replaceAll("\\D", "");
        // return 0 if no digits found
        return num.isEmpty() ? 0 : Integer.parseInt(num);
    }

    @FXML
    void initialize() {

        NumberColumn.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getNumTrip()));
        SitsColumn.setCellValueFactory(cellDataFeatures -> new SimpleIntegerProperty(cellDataFeatures.getValue().getSits()).asObject());
        DaysColumn.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getDays()));
        TimeColumn.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getDeparture().toString()));


        StationsColumn.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getStorage().stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"))));
        table.setItems(Collections.tripObservableList);

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



        searchButton.setOnAction(actionEvent -> {
            Collections.tripObservableList.clear();
            String searchPredicate = searchPredicateField.getText();
            if (daysRadioSearch.isSelected()) {
                for (Trip e : Collections.list) {
                    if((e.getDays().contains(searchPredicate))){
                        Collections.tripObservableList.add(e);
                    }
                }
            } else if (StationRadioSearch.isSelected()) {
                for (Trip e : Collections.list) {
                    if((e.getStorage().toString().contains(searchPredicate))){
                        Collections.tripObservableList.add(e);
                    }
                }
            } else {
                for (Trip e : Collections.list) {
                    if (e.getNumTrip().contains(searchPredicate)) {
                        Collections.tripObservableList.add(e);
                    }
                }
            }
        });

        removeButton.setOnAction(actionEvent ->{
            ObservableList<Trip> accountsSelected = table.getSelectionModel().getSelectedItems();
            ArrayList<Trip> items =  new ArrayList<>(table.getSelectionModel().getSelectedItems());
            Collections.tripObservableList.removeAll(accountsSelected);
            table.getSelectionModel().clearSelection();
            Collections.list.removeAll(items);
        });

        sortButton.setOnAction(actionEvent -> {
            if (numberSortRadio.isSelected()) {
                Collections.tripObservableList.sort(Comparator.comparingInt(o -> extractInt(o.getNumTrip())));
            } else if (timeSortRadio.isSelected()) {
                Collections.tripObservableList.sort(Comparator.comparingInt(p -> p.getDeparture().getToCompare()));
            } else {
                Collections.tripObservableList.sort(Comparator.comparingInt(p -> p.getSits()));
            }
        });

        generateButton.setOnAction(actionEvent -> {
            int count = Integer.parseInt(countOfGeneratedField.getText());
            Collections.tripObservableList.clear();
            Collections.list.clear();
            Collections.list.addAll(Generator.generator(count));
            Collections.tripObservableList.addAll(Collections.list);
        });

        resetButton.setOnAction(actionEvent -> {
            Collections.tripObservableList.clear();
            Collections.tripObservableList.addAll(Collections.list);
        });

        signUpButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("res/editor.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        exitButton.setOnAction(actionEvent -> {
            exitButton.getScene().getWindow().hide();
        });



        clearButton.setOnAction(actionEvent -> {
            Collections.list.clear();
            Collections.tripObservableList.clear();
        });

        loadDataButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("res/load.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();
        });

        saveDataButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("res/save.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();
        });

    }
}
