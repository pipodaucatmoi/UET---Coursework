package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class StudentFormController {
    @FXML
    private TextField fullNameField;

    @FXML
    private TextField studentIdField;

    @FXML
    private ComboBox<String> majorBox;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private RadioButton maleRadio;

    @FXML
    private RadioButton femaleRadio;

    @FXML
    private CheckBox libraryCheckBox;

    @FXML
    private CheckBox dormitoryCheckBox;

    @FXML
    private CheckBox scholarshipCheckBox;

    @FXML
    private TextArea resultArea;

    private ToggleGroup genderGroup;

    @FXML
    public void initialize() {
        majorBox.getItems().addAll("Computer Science", "Information Security", "Software Engineering", "Data Science");

        genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
    }

    @FXML
    private void handleSubmit() {
        String gender = "Not selected";

        if (maleRadio.isSelected()) {
            gender = "Male";
        } else if (femaleRadio.isSelected()) {
            gender = "Female";
        }

        String services = "";

        if (libraryCheckBox.isSelected()) {
            services += "Library ";
        }

        if (dormitoryCheckBox.isSelected()) {
            services += "Dormitory ";
        }

        if (scholarshipCheckBox.isSelected()) {
            services += "Scholarship ";
        }

        if (services.isEmpty()) {
            services = "None";
        }

        resultArea.setText(
                "Full name: " + fullNameField.getText() + "\n"
                        + "Student ID: " + studentIdField.getText() + "\n"
                        + "Major: " + majorBox.getValue() + "\n"
                        + "Birth date: " + birthDatePicker.getValue() + "\n"
                        + "Gender: " + gender + "\n"
                        + "Services: " + services
        );
    }

    @FXML
    private void handleClear() {
        fullNameField.clear();
        studentIdField.clear();
        majorBox.setValue(null);
        birthDatePicker.setValue(null);
        genderGroup.selectToggle(null);
        libraryCheckBox.setSelected(false);
        dormitoryCheckBox.setSelected(false);
        scholarshipCheckBox.setSelected(false);
        resultArea.clear();
    }
}