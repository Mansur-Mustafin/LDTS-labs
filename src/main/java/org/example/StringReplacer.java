package org.example;

public class StringReplacer implements StringTransformer{

    private char old;
    private char novo;

    public StringReplacer(char s1, char s2){
        old = s1;
        novo = s2;
    }

    @Override
    public void execute(StringDrink drink){
        String s = drink.getText();
        String s1 = s.replace(old, novo);
        drink.setText(s1);
    }

    @Override
    public void undo(StringDrink drink){
        String s = drink.getText();
        String s1 = s.replace(novo, old);
        drink.setText(s1);
    }
}
