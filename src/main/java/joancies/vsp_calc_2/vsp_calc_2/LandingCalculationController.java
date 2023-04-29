package joancies.vsp_calc_2.vsp_calc_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LandingCalculationController implements Initializable {

  @FXML
  private ChoiceBox<String> flapsLandingChoiceBox;
  @FXML
  private TextField vappField, vgaField, vrefField, landingWeightField,  zeroFuelWeightField, landingFuelField;
  @FXML
  private Button calculateLButton;


  private boolean incorrectFieldSValues;
  private int landingFlapsSettings;
  private int landingFuel;
  private int zeroFuelWeight;

  private LandingSpeedsCalculation calculation;

  private String[] flapsSettings = {"5°", "10°","15°","35°"};

  public void calculateLandingSpeeds(ActionEvent event){
    incorrectFieldSValues =false;
    zeroFuelWeightField.setStyle("-fx-border-color:none; ");
    landingWeightField.setStyle("-fx-border-color:none; ");
    flapsLandingChoiceBox.setStyle("-fx-border-color:none;");


    try {
      landingFlapsSettings = Integer.parseInt(flapsLandingChoiceBox.getValue().substring(0, flapsLandingChoiceBox.getValue().length()-1));
    }
    catch (Exception e){
      flapsLandingChoiceBox.setStyle("-fx-border-color:red;");
      incorrectFieldSValues =true;
    }



    try {
      zeroFuelWeight = Integer.parseInt(zeroFuelWeightField.getCharacters().toString());
    } catch (Exception e) {
      zeroFuelWeightField.setStyle("-fx-border-color:red; ");
      incorrectFieldSValues = true;
    }

    try {
      landingFuel = Integer.parseInt(landingFuelField.getCharacters().toString());
    } catch (Exception e) {
      landingFuelField.setStyle("-fx-border-color:red;");
      incorrectFieldSValues = true;
    }

    if(!incorrectFieldSValues) {

      if(landingFuel>=0 && zeroFuelWeight>0){
        calculation = new LandingSpeedsCalculation(landingFlapsSettings, landingFuel, zeroFuelWeight);

        landingWeightField.setText(calculation.getLandingWeight()+".0 kg");
        vappField.setText(calculation.getVapp()+".0 kt");
        vrefField.setText(calculation.getVref()+".0 kt");
        vgaField.setText( calculation.getVga()+".0 kt");
      }
      else{
        if(landingFuel<0){
          landingFuelField.setStyle("-fx-border-color:red;");
        }
        else{
          zeroFuelWeightField.setStyle("-fx-border-color:red;");
        }
      }


    }

  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    flapsLandingChoiceBox.getItems().addAll(flapsSettings);

  }
}