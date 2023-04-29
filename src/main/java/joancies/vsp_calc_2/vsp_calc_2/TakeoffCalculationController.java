package joancies.vsp_calc_2.vsp_calc_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class TakeoffCalculationController implements Initializable {
  @FXML
  private CheckBox wetRunwayCheckBox;
  @FXML
  private ChoiceBox<String> flapsTakeoffChoiceBox;
  @FXML
  private TextField v1Field, v2Field, vrField, vfriField, vclmbField, tempField, weightField, altitudeField,windDField,runwayDField,windSpeedField;
  @FXML
  private Button calculateTOButton;

  private boolean wetRunway;
  private boolean incorrectFieldsValues;
  private int flapsTO, temperature, weight,altitude, windDegree, runwayDegree, windSpeed;
  private int[] params = new int[6];
  private int numberOfFieldsToFillUp;

  private TextField[] fields;

  private TakeoffSpeedsCalculation calculation;

  private String[] flapsSettings = {"5°", "10°","15°"};

  public void calculateTO(ActionEvent event){
    incorrectFieldsValues =false;

    flapsTakeoffChoiceBox.setStyle("-fx-border-color:none");

    for (int i = 0; i < fields.length; i++) {
        fields[i].setStyle("-fx-border-color:none; ");
      if(wetRunwayCheckBox.isSelected()){
        windDField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4) ");
        runwayDField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4) ");
        windSpeedField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4) ");}
    }

    wetRunway= wetRunwayCheckBox.isSelected();

    try {
      flapsTO = Integer.parseInt(flapsTakeoffChoiceBox.getValue().substring(0,flapsTakeoffChoiceBox.getValue().length()-1));
    }
    catch (Exception e){
      flapsTakeoffChoiceBox.setStyle("-fx-border-color:red;");
      incorrectFieldsValues =true;
    }

    if(wetRunway) {
      numberOfFieldsToFillUp =6;
    }
    else{
    numberOfFieldsToFillUp =3;
      }

    for (int i = 0; i < numberOfFieldsToFillUp; i++) {
      try {
        params[i] = Integer.parseInt(fields[i].getCharacters().toString());
      } catch (Exception e) {
        fields[i].setStyle("-fx-border-color:red; -fx-background-color: rgba(255, 255, 255, 0.4)");
        incorrectFieldsValues = true;
      }
    }
    temperature = params[0];
    weight= params[1];
    altitude= params[2];
    windDegree =params[3];
    runwayDegree =params[4];
    windSpeed=params[5];

    if(!incorrectFieldsValues) {
      for (int i = 1; i < params.length; i++) {
        if (params[i]>=0){
          if (wetRunway) {
            calculation = new TakeoffSpeedsCalculation(flapsTO, temperature, weight, altitude, windDegree, runwayDegree, windSpeed);
          } else {
            calculation = new TakeoffSpeedsCalculation( flapsTO, temperature, weight, altitude);
          }
          v1Field.setText(calculation.calculateV1()+" kt");
          v2Field.setText(calculation.calculateV2()+" kt");
          vrField.setText(calculation.calculateVr()+" kt");
          vclmbField.setText(calculation.getVclmb()+".0 kt");
          vfriField.setText(calculation.getVfri()+".0 kt");
        }
        else {
          fields[i].setStyle("-fx-border-color:red; -fx-background-color: rgba(255, 255, 255, 0.4)");

        }

      }

    }

  }
  public void isWet(ActionEvent event){
    if(wetRunwayCheckBox.isSelected()){
    windDField.setEditable(true);
    windDField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4) ");
    runwayDField.setEditable(true);
    runwayDField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4) ");
    windSpeedField.setEditable(true);
    windSpeedField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4) ");}
    else
    {
      windDField.setEditable(false);
      windDField.setText("");
      windDField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.1)");
      runwayDField.setEditable(false);
      runwayDField.setText("");
      runwayDField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.1) ");
      windSpeedField.setEditable(false);
      windSpeedField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.1) ");
      windSpeedField.setText("");
    }
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    fields = new TextField[] {tempField, weightField, altitudeField,windDField,runwayDField,windSpeedField} ;
    flapsTakeoffChoiceBox.getItems().addAll(flapsSettings);

  }
}