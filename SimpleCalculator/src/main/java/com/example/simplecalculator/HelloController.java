package com.example.simplecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static java.lang.Math.sqrt;


public class HelloController {
    @FXML
    private TextField textField;
    @FXML
    private double num1 = 0, num2 = 0, result = 0;
    @FXML
    private char operator;

    @FXML
    private void buttonClicked(ActionEvent event) {
        Button source = (Button) event.getSource();
        String buttonText = source.getText();
        if (isNumeric(buttonText)) {
            textField.setText(textField.getText().concat(String.valueOf(buttonText)));
        }
        else if(buttonText.equals(".")){
            textField.setText((textField.getText().concat(".")));
        }
        else if(buttonText.equals("+")){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        else if(buttonText.equals("-")){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        else if(buttonText.equals("*")){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        else if(buttonText.equals("/")){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        else if(buttonText.equals("(√)")){
                double temp = Double.parseDouble(textField.getText());
                temp = sqrt(temp);
                textField.setText(String.valueOf(temp));

        }
        else if(buttonText.equals("(-)")){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
        else if(buttonText.equals("C")){
            textField.setText("");
        }
        else if(buttonText.equals("=")){
            num2 = Double.parseDouble(textField.getText());
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

    }


    private boolean isNumeric(String buttonText) {
        try {
            int number = Integer.parseInt(buttonText);
            return (number >= 0 && number <= 9);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
