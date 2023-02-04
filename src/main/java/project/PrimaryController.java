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
        }
        else if (actionEvent.getSource() == btnToDo) {
            paneToDo.toFront();
        }
        else if (actionEvent.getSource() == btnGoals) {
            paneGoals.toFront();
        }
    }
}