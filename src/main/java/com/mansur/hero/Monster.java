package com.mansur.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.mansur.hero.Element;

public class Monster extends Element {
    public Monster(int x, int y){
        super(x,y);
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public void move(Position pos){
        this.position.setX(pos.getX());
        this.position.setY(pos.getY());
    }


}
