package joancies.vsp_calc_2.vsp_calc_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class VspControllerTO implements Initializable {
  @FXML
  private CheckBox wetRunwayCheckBox;
  @FXML
  private ChoiceBox<String> flapsTOChoiceBox;
  @FXML
  private TextField v1Field, v2Field, vrField, vfriField, vclmbField, tempField, weightField, altitudeField,windDField,runwayDField,windSpeedField;
  @FXML
  private Button calculateTOButton;

  private boolean wetRunway;
  private boolean ex;
  private int flapsTO,temp, weight,altitude, windD,runwayD, windSpeed;
  private int[] params = new int[6];
  private int fieldsL;

  private TextField[] fields;

  private SpeedCalculationTO calculation;

  private String[] flaps = {"5°", "10°","15°"};

  public void calculateTO(ActionEvent event){
    ex=false;

    flapsTOChoiceBox.setStyle("-fx-border-color:none");

    for (int i = 0; i < fields.length; i++) {
        fields[i].setStyle("-fx-border-color:none; ");
      if(wetRunwayCheckBox.isSelected()){
        windDField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4) ");
        runwayDField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4) ");
        windSpeedField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4) ");}
    }

    wetRunway= wetRunwayCheckBox.isSelected();

    try {
      flapsTO = Integer.parseInt(flapsTOChoiceBox.getValue().substring(0,flapsTOChoiceBox.getValue().length()-1));
    }
    catch (Exception e){
      flapsTOChoiceBox.setStyle("-fx-border-color:red;");
      ex=true;
    }

    if(wetRunway) {
      fieldsL=6;
    }
    else{
    fieldsL=3;
      }

    for (int i = 0; i < fieldsL; i++) {
      try {
        params[i] = Integer.parseInt(fields[i].getCharacters().toString());
      } catch (Exception e) {
        fields[i].setStyle("-fx-border-color:red; -fx-background-color: rgba(255, 255, 255, 0.4)");
        ex = true;
      }
    }
    temp= params[0];
    weight= params[1];
    altitude= params[2];
    windD=params[3];
    runwayD=params[4];
    windSpeed=params[5];

    if(!ex) {
      for (int i = 1; i < params.length; i++) {
        if (params[i]>=0){
          if (wetRunway) {
            calculation = new SpeedCalculationTO(flapsTO, temp, weight, altitude, windD, runwayD, windSpeed);
          } else {
            calculation = new SpeedCalculationTO( flapsTO, temp, weight, altitude);
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
    flapsTOChoiceBox.getItems().addAll(flaps);

  }
}