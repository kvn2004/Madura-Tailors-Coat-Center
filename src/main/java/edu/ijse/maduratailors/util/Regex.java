package edu.ijse.maduratailors.util;

import edu.ijse.maduratailors.Enum.TextField;
import javafx.scene.control.TextArea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean isTextFieldValid(TextField textField, String text){
        String filed = "";
        switch (textField){
            case NAME:
                filed = "^[A-Za-z]+(?: [A-Za-z]+)*$";
                break;
            case EMAIL:
                filed = "^([A-z])([A-z0-9.]){1,}[@]([A-z0-9]){1,10}[.]([A-z]){2,5}$";
                break;
            case ADDRESS:
                filed = "^([A-z0-9]|[-\\,.@+]|\\\\s){4,}$";
                break;
            case CONTACT:
                filed = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
                break;
            case PASSWORD:
                //filed = "^(?=.[a-zA-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$";
                filed = "^\\d{4}$";
                break;
            case QTY:
                filed = "^[1-9]\\d*$";
                break;
            case DATE:
                filed ="^(19|20)\\d\\d-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";
                break;
            case PRICE:
                filed ="^([0-9]){1,}[.]([0-9]){1,}$";
                break;
            case DESCRIPTION:
                filed = "^[A-Za-z0-9\\s!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$";
                break;
            case  AMOUNT:
                filed = "^[A-Za-z0-9\\s!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$";
                break;
            case BANK:
                filed ="^[A-Za-z ]+$";;
                break;
            case MEASUREMENT:
                filed = "^([0-9]){1,}[.]([0-9]){1,}$";
                break;


        }
        Pattern pattern = Pattern.compile(filed);
        if (text != null){
            if (text.trim().isEmpty()){
                return false;
            }
        }else {
            return true;
        }
        Matcher matcher  = pattern.matcher(text);
        if (matcher.matches()){
            return true;
        }else {
            return  false;
        }
    }
    public static boolean setTextColor(TextField location, javafx.scene.control.TextField textField){
        if (Regex.isTextFieldValid(location, textField.getText())){
           // textField.setStyle("-fx-background-color: rgba(255,255,255,0); -fx-border-color: #7367F0; -fx-border-width: 0 0 1px 0;;-fx-border-color: #7367F0");
            textField.setStyle(
                    "-fx-background-color: transparent;" +
                            "-fx-border-color: transparent transparent rgba(0,255,21,0) transparent;" +
                            "-fx-border-width: 0 0 2px 0;"
            );

            return true;
        }else {
            textField.setStyle(
                    "-fx-background-color: transparent;" +
                            "-fx-border-color: transparent transparent #ff0000 transparent;" +
                            "-fx-border-width: 0 0 2px 0;"
            );
            return false;
        }
    }
    public static boolean setTextColorTxtArea(TextField location, TextArea textArea){
        if (Regex.isTextFieldValid(location, textArea.getText())){
            textArea.setStyle("-fx-border-color: #00FF00;-fx-background-color: #e7dbc0;");
            return true;
        }else {
            textArea.setStyle("-fx-border-color: red;-fx-border-radius: 5;-fx-border-width: 3;-fx-background-color: #e7dbc0;");
            return false;
        }
    }
}

