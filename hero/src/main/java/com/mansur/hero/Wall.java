package com.mansur.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.mansur.hero.Element;
import com.mansur.hero.Position;

public class Wall extends Element {

    public Wall(int x, int y){
        super(x,y);
    }

    public Position getPosition(){
        return position;
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(new TerminalPosition(this.position.getX(),this.position.getY()), "@");
    }

}

