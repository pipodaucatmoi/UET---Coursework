package com.example;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

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

    @FXML
    private Button submitButton;

    @FXML
    private Button loadButton;

    @FXML
    private ProgressIndicator progressIndicator;

    private ToggleGroup genderGroup;
    private final StudentDAO studentDAO = new StudentDAO();

    @FXML
    public void initialize() {
        majorBox.getItems().addAll("Computer Science", "Information Security", "Software Engineering", "Data Science");

        genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);

        setupRealtimeValidation();
        setupKeyboardEvents();
    }

    private void setupRealtimeValidation() {
        fullNameField.textProperty().addListener((observable, oldValue, newValue) -> validateField(fullNameField, !newValue.isBlank()));
        studentIdField.textProperty().addListener((observable, oldValue, newValue) -> validateField(studentIdField, newValue.matches("\\d*")));
    }

    private void setupKeyboardEvents() {
        fullNameField.setOnAction(event -> studentIdField.requestFocus());
        studentIdField.setOnAction(event -> majorBox.requestFocus());

        resultArea.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.getAccelerators().put(
                        new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN),
                        this::handleSubmit
                );
            }
        });
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

        Task<Void> saveTask = new Task<>() {
            @Override
            protected Void call() {
                studentDAO.save(student);
                return null;
            }
        };

        setLoading(true);

        saveTask.setOnSucceeded(event -> Platform.runLater(() -> {
            setLoading(false);
            resultArea.setText("Saved successfully!\n\n" + student.toDisplayText());
        }));

        saveTask.setOnFailed(event -> Platform.runLater(() -> {
            setLoading(false);
            resultArea.setText("Database error: " + saveTask.getException().getMessage());
        }));

        new Thread(saveTask).start();
    }

    @FXML
    private void handleLoad() {
        Task<String> loadTask = new Task<>() {
            @Override
            protected String call() {
                return studentDAO.loadAll();
            }
        };

        setLoading(true);

        loadTask.setOnSucceeded(event -> Platform.runLater(() -> {
            setLoading(false);
            resultArea.setText(loadTask.getValue());
        }));

        loadTask.setOnFailed(event -> Platform.runLater(() -> {
            setLoading(false);
            resultArea.setText("Database error: " + loadTask.getException().getMessage());
        }));

        new Thread(loadTask).start();
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

        fullNameField.getStyleClass().remove("error-field");
        studentIdField.getStyleClass().remove("error-field");
    }

    private void setLoading(boolean loading) {
        progressIndicator.setVisible(loading);
        submitButton.setDisable(loading);
        loadButton.setDisable(loading);
    }

    private void validateField(TextField field, boolean valid) {
        if (valid) {
            field.getStyleClass().remove("error-field");
        } else if (!field.getStyleClass().contains("error-field")) {
            field.getStyleClass().add("error-field");
        }
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