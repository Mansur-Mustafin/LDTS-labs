package org.example;

public class StringBar extends Bar{
    private boolean flag;

    public StringBar(){
        flag = false;
    }

    @Override
    public boolean isHappyHour(){
        return flag;
    }

    @Override
    public void startHappyHour(){
        flag = true;
        notifyObservers();
    }

    @Override
    public void endHappyHour(){
        flag = false;
        notifyObservers();
    }

    public void order(StringDrink drink, StringRecipe recipe){
        recipe.mix(drink);
    }
}
