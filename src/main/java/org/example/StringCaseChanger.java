package org.example;

import java.util.Arrays;

public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink){
        String s = drink.getText();
        char[] arr = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length() ; i++){
            if(Character.isLowerCase(s.charAt(i))){
                stringBuilder.append(Character.toUpperCase(arr[i]));
            }else{
                stringBuilder.append(Character.toLowerCase(arr[i]));
            }
        }
        drink.setText(stringBuilder.toString());
    }
}
