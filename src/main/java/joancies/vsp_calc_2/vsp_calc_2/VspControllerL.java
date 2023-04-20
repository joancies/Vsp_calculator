package joancies.vsp_calc_2.vsp_calc_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class VspControllerL implements Initializable {

  @FXML
  private ChoiceBox<String> flapsLChoiceBox;
  @FXML
  private TextField vappField, vgaField, vrefField, landingWeightField,  zeroFuelWeightField, landingFuelField;
  @FXML
  private Button calculateLButton;


  private boolean ex;
  private int flapsL;
  private int landingFuel;
  private int zeroFuelWeight;

  private SpeedCalculationL calculation;

  private String[] flaps = {"5°", "10°","15°","35°"};

  public void calculateL(ActionEvent event){
    ex=false;
    zeroFuelWeightField.setStyle("-fx-border-color:none; ");
    landingWeightField.setStyle("-fx-border-color:none; ");
    flapsLChoiceBox.setStyle("-fx-border-color:none;");


    try {
      flapsL = Integer.parseInt(flapsLChoiceBox.getValue().substring(0,flapsLChoiceBox.getValue().length()-1));
    }
    catch (Exception e){
      flapsLChoiceBox.setStyle("-fx-border-color:red;");
      ex=true;
    }



    try {
      zeroFuelWeight = Integer.parseInt(zeroFuelWeightField.getCharacters().toString());
    } catch (Exception e) {
      zeroFuelWeightField.setStyle("-fx-border-color:red; ");
      ex = true;
    }

    try {
      landingFuel = Integer.parseInt(landingFuelField.getCharacters().toString());
    } catch (Exception e) {
      landingFuelField.setStyle("-fx-border-color:red;");
      ex = true;
    }

    if(!ex) {

      if(landingFuel>=0 && zeroFuelWeight>0){
        calculation = new SpeedCalculationL(flapsL, landingFuel, zeroFuelWeight);

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

    flapsLChoiceBox.getItems().addAll(flaps);

  }
}