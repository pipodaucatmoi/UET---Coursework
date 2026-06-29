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
        String error = validateInput();

        if (!error.isEmpty()) {
            resultArea.setText(error);
            return;
        }

        Student student = new Student(
                fullNameField.getText(),
                studentIdField.getText(),
                majorBox.getValue(),
                birthDatePicker.getValue().toString(),
                getGender(),
                getServices()
        );

        resultArea.setText(student.toDisplayText());
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

    private String validateInput() {
        StringBuilder errors = new StringBuilder();

        if (fullNameField.getText().isBlank()) {
            errors.append("Full name is required.\n");
        }

        if (studentIdField.getText().isBlank()) {
            errors.append("Student ID is required.\n");
        } else if (!studentIdField.getText().matches("\\d+")) {
            errors.append("Student ID must contain only numbers.\n");
        }

        if (majorBox.getValue() == null) {
            errors.append("Major is required.\n");
        }

        if (birthDatePicker.getValue() == null) {
            errors.append("Birth date is required.\n");
        }

        if (genderGroup.getSelectedToggle() == null) {
            errors.append("Gender is required.\n");
        }

        return errors.toString();
    }

    private String getGender() {
        if (maleRadio.isSelected()) {
            return "Male";
        }

        if (femaleRadio.isSelected()) {
            return "Female";
        }

        return "Not selected";
    }

    private String getServices() {
        StringBuilder services = new StringBuilder();

        if (libraryCheckBox.isSelected()) {
            services.append("Library Card ");
        }

        if (dormitoryCheckBox.isSelected()) {
            services.append("Dormitory Registration ");
        }

        if (scholarshipCheckBox.isSelected()) {
            services.append("Scholarship Application ");
        }

        if (services.isEmpty()) {
            return "None";
        }

        return services.toString();
    }
}