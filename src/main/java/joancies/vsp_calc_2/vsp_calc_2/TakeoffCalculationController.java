package joancies.vsp_calc_2.vsp_calc_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class TakeoffCalculationController extends VspCalculationController implements Initializable {
  @FXML
  private CheckBox wetRunwayCheckBox;
  @FXML
  private ChoiceBox<String> flapsTakeoffChoiceBox;
  @FXML
  private TextField v1Field, v2Field, vrField, vfriField, vclmbField, tempField, weightField, altitudeField,windDField,runwayDField,windSpeedField;
  private TextField[] fields;
  private boolean wetRunway;
  private int takeoffFlapsSettings, temperature, weight,altitude, windDegree, runwayDegree, windSpeed;
  private int numberOfFieldsToFillUp;
  private TakeoffSpeedsCalculation calculation;
  private String[] flapsSettings = {"5°", "10°","15°"};
  int[] params = new int[6];

  public void calculateSpeeds(ActionEvent event) {
    resetFieldsStyle();
    setIncorrectFieldValue(false);
    wetRunway = wetRunwayCheckBox.isSelected();
    getParametersToCalculation();
    checkWindAndRunwayValues();

    if (!getIncorrectFieldValue()) {
      makeCalculation();
    } else {
      cleanResultFields();
    }
  }

  public void isWet(ActionEvent event){
    if(wetRunwayCheckBox.isSelected()){
      setFieldsAvailable(windDField);
      setFieldsAvailable(windSpeedField);
      setFieldsAvailable(runwayDField);
    }
    else
    {
      setFieldsNotAvailable(windDField);
      setFieldsNotAvailable(windSpeedField);
      setFieldsNotAvailable(runwayDField);
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    fields = new TextField[] {tempField, weightField, altitudeField,windDField,runwayDField,windSpeedField} ;
    flapsTakeoffChoiceBox.getItems().addAll(flapsSettings);
  }

  @Override
  public void resetFieldsStyle() {
    for (int i = 0; i < fields.length; i++) {
      resetBorderColor(fields[i]);
      if(wetRunwayCheckBox.isSelected()){
        setFieldsAvailable(windDField);
        setFieldsAvailable(windSpeedField);
        setFieldsAvailable(runwayDField);
      }
    }
    resetBorderColor(flapsTakeoffChoiceBox);
  }
  public void getParametersToCalculation(){
    getNumberOfFieldsToFillUp();
    for (int i = 0; i < numberOfFieldsToFillUp; i++) {
      params[i] = getParameterValueFromField(fields[i]);
    }
    takeoffFlapsSettings = getParameterValueFromField(flapsTakeoffChoiceBox);
    temperature = params[0];
    weight = params[1];
    altitude = params[2];
    windDegree = params[3];
    runwayDegree = params[4];
    windSpeed = params[5];
  }
  public void getNumberOfFieldsToFillUp(){
    if (wetRunway) {
      numberOfFieldsToFillUp = 6;
    } else {
      numberOfFieldsToFillUp = 3;
    }
  }
  public void checkWindAndRunwayValues(){
    if(windDegree<0){
      setIncorrectValueFieldStyle(windDField);
      setIncorrectFieldValue(true);
    }
    else if(windSpeed<0){
      setIncorrectValueFieldStyle(windSpeedField);
      setIncorrectFieldValue(true);
    }
    else if(runwayDegree<0){
      setIncorrectValueFieldStyle(runwayDField);
      setIncorrectFieldValue(true);
    }
  }

  public void cleanResultFields(){
    v1Field.setText("");
    v2Field.setText("");
    vrField.setText("");
    vclmbField.setText("");
    vfriField.setText("");
  }
  public void makeCalculation(){

    if (wetRunway) {
      calculation = new TakeoffSpeedsCalculation(takeoffFlapsSettings, temperature, weight, altitude, windDegree, runwayDegree, windSpeed);
    } else {
      calculation = new TakeoffSpeedsCalculation(takeoffFlapsSettings, temperature, weight, altitude);
    }
    v1Field.setText(calculation.getV1() + " kt");
    v2Field.setText(calculation.getV2() + " kt");
    vrField.setText(calculation.getVr() + " kt");
    vclmbField.setText(calculation.getVclmb() + ".0 kt");
    vfriField.setText(calculation.getVfri() + ".0 kt");
  }
}