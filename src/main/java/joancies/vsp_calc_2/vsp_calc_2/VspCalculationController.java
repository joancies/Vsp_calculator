package joancies.vsp_calc_2.vsp_calc_2;


import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public abstract class VspCalculationController {
    boolean incorrectFieldValue = false ;
    int param ;

    public void resetBorderColor(Control control){
        control.setStyle("-fx-border-color:none");
    }
    public void setFieldsAvailable(TextField textField){
        textField.setEditable(true);
        textField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4) ");
    }
    public void setFieldsNotAvailable(TextField textField){
        textField.setEditable(false);
        textField.setText("");
        textField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.1)");
    }
    public void setIncorrectValueFieldStyle(Control control){
        control.setStyle("-fx-border-color:red; -fx-background-color: rgba(255, 255, 255, 0.4)");
    }
    public int getParameterValueFromField(Control control) {

        try {
            if(control instanceof TextField){
                param = Integer.parseInt(((TextField) control).getCharacters().toString());
            } else if(control instanceof ChoiceBox<?>){
                param = Integer.parseInt(((ChoiceBox<String>) control).getValue().substring(0, ((ChoiceBox<String>) control).getValue().length() - 1));
            }

        } catch (Exception e) {
            setIncorrectValueFieldStyle(control);
            incorrectFieldValue = true;
        }
        return param;
    }
    public boolean getIncorrectFieldValue(){
        return incorrectFieldValue;
    }

    public void setIncorrectFieldValue(boolean incorrectFieldValue){
        this.incorrectFieldValue = incorrectFieldValue;
    }

    public abstract void calculateSpeeds(ActionEvent event);
    public abstract void resetFieldsStyle();
    public abstract void getParametersToCalculation();
    public abstract void cleanResultFields();
    public abstract void makeCalculation();

}
