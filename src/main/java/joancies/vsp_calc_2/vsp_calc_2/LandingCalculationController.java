package joancies.vsp_calc_2.vsp_calc_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LandingCalculationController extends VspCalculationController implements Initializable {

  @FXML
  private ChoiceBox<String> flapsLandingChoiceBox;
  @FXML
  private TextField vappField, vgaField, vrefField, landingWeightField,  zeroFuelWeightField, landingFuelField;

  private int landingFlapsSettings;
  private int landingFuel;
  private int zeroFuelWeight;
  private LandingSpeedsCalculation calculation;
  private String[] flapsSettings = {"5°", "10°","15°","35°"};

  public void calculateSpeeds(ActionEvent event){
    resetFieldsStyle();
    setIncorrectFieldValue(false);
    getParametersToCalculation();
    checkWeightsValues();

    if (!getIncorrectFieldValue()){
      makeCalculation();
    } else {
      cleanResultFields();
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    flapsLandingChoiceBox.getItems().addAll(flapsSettings);
  }

  @Override
  public void resetFieldsStyle() {
    resetBorderColor(zeroFuelWeightField);
    resetBorderColor(landingFuelField);
    resetBorderColor(flapsLandingChoiceBox);
  }
  public void getParametersToCalculation(){
    zeroFuelWeight= getParameterValueFromField(zeroFuelWeightField);
    landingFuel= getParameterValueFromField(landingFuelField);
    landingFlapsSettings= getParameterValueFromField(flapsLandingChoiceBox);
  }
  public void checkWeightsValues(){
    if(landingFuel<0) {
      setIncorrectValueFieldStyle(landingFuelField);
      setIncorrectFieldValue(true);
    }
    else if(zeroFuelWeight<=0) {
      setIncorrectValueFieldStyle(zeroFuelWeightField);
      setIncorrectFieldValue(true);
    }
  }
  public void cleanResultFields(){
    landingWeightField.setText("");
    vappField.setText("");
    vrefField.setText("");
    vgaField.setText("");
  }

  public void makeCalculation(){
    calculation = new LandingSpeedsCalculation(landingFlapsSettings, landingFuel, zeroFuelWeight);
    landingWeightField.setText(calculation.getLandingWeight()+".0 kg");
    vappField.setText(calculation.getVappChosenArray()+".0 kt");
    vrefField.setText(calculation.getVrefChosenArray()+".0 kt");
    vgaField.setText( calculation.getVgaChosenArray()+".0 kt");
  }

}