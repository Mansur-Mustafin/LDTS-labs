package org.example;


public class StringInverter implements StringTransformer{
    @Override
    public void execute(StringDrink drink){
        String s = drink.getText();
        StringBuilder input1 = new StringBuilder();
        input1.append(s);
        input1.reverse();
        drink.setText(input1.toString());
    }
}
