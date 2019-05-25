package com.airborne.mff.model;

import com.airborne.mff.util.Constants;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;

public enum Type {

    COMBAT("combat", Color.RED),
    BLAST("blast", Color.BLUE),
    SPEED("speed", Color.GREEN),
    UNIVERSAL("universal", Constants.PURPLE);

    String name;
    Color color;

    Type(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static Type getTypeByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        if (StringUtils.equals(name, Type.COMBAT.name)) {
            return Type.COMBAT;
        } else if (StringUtils.equals(name, Type.BLAST.name)) {
            return Type.BLAST;
        } else if (StringUtils.equals(name, Type.SPEED.name)) {
            return Type.SPEED;
        } else if (StringUtils.equals(name, Type.UNIVERSAL.name)) {
            return Type.UNIVERSAL;
        }
        return null;
    }
}
