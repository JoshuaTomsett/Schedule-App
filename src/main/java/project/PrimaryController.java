package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class PrimaryController {

    @FXML
    private Button btnSchedule;

    @FXML
    private Button btnToDo;

    @FXML
    private Button btnGoals;

    @FXML
    private Pane paneSchedule;

    @FXML
    private Pane paneToDo;

    @FXML
    private Pane paneGoals;

    public void handleClicks(ActionEvent actionEvent) {

        if (actionEvent.getSource() == btnSchedule) {
            paneSchedule.toFront(); // set pane to visable (in front of the others)
            btnSchedule.getStyleClass().clear(); // remove current styles
            btnSchedule.getStyleClass().add("buttonActive"); // button active class

            btnToDo.getStyleClass().clear();
            btnToDo.getStyleClass().add("button");

            btnGoals.getStyleClass().clear();
            btnGoals.getStyleClass().add("button");
        }

        else if (actionEvent.getSource() == btnToDo) {
            paneToDo.toFront();
            btnToDo.getStyleClass().add("buttonActive");
            btnToDo.getStyleClass().remove("button");

            btnSchedule.getStyleClass().clear();
            btnSchedule.getStyleClass().add("button");

            btnGoals.getStyleClass().clear();
            btnGoals.getStyleClass().add("button");
        }

        else if (actionEvent.getSource() == btnGoals) {
            paneGoals.toFront();
            btnGoals.getStyleClass().add("buttonActive");
            btnGoals.getStyleClass().remove("button");

            btnToDo.getStyleClass().clear();
            btnToDo.getStyleClass().add("button");

            btnSchedule.getStyleClass().clear();
            btnSchedule.getStyleClass().add("button");
        }
    }
}