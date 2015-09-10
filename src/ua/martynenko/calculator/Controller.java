package ua.martynenko.calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    double number = 0;
    private String operator = "+";
    public TextField text;
    private Model model = new Model();
    boolean start = true;

    // set number to text field
    public void numberButtonClicked(ActionEvent e){
        if (start) {
            text.setText("0");
            start = false;
        }
        String a;
        a = ((Button)e.getSource()).getText();
        text.setText(text.getText() + a);
        text.positionCaret(text.getText().length());
    }

    public void operationButtonClicked(ActionEvent e){
        String operation;
        operation = ((Button)e.getSource()).getText();

        if (!operation.equals("=")) {
            if (!operator.isEmpty() && text.getText().split(" ").length < 2) {
                number = Double.parseDouble(text.getText().split(" ")[0]);
                text.setText(number + " " + operator + " ");
            }
            if (!operator.isEmpty() && text.getText().split(" ").length > 2) {
                double result = model.calculate(number, Double.parseDouble(text.getText().split(" ")[2]), operator);
                text.setText(String.valueOf(result));
            }
            operator = operation;
            number = Double.parseDouble(text.getText().split(" ")[0]);
            text.setText(number + " " + operator + " ");
        }
        else {
            if (operator.isEmpty()) return;
            System.out.println(text.getText().split(" ")[2]);
            double result = model.calculate(number, Double.parseDouble(text.getText().split(" ")[2]), operator);
            text.setText(String.valueOf(result));
            start = true;
            number = result;
            operator = "";
        }
    }

    public void cosButtonClicked(){
        int x = (int)Math.cos(Double.parseDouble(text.getText()));
        text.setText(x + "");
    }

    public void sinButtonClicked(){
        int x = (int)Math.sin(Double.parseDouble(text.getText()));
        text.setText(x + "");    }

    // something wrong
    public void changeValue(){
        if (operator.equals("+")) {
            number = Integer.valueOf(text.getText());
            text.setText("-" + number);
            operator = "-";
        } else
            number = Integer.valueOf(text.getText());
            text.setText("+" + number);
            operator = "+";
    }
    public void clearButtonClicked(){
        number = 0;
        operator = "";
        text.setText("0");
    }

}