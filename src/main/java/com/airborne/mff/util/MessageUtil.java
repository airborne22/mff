package com.airborne.mff.util;

import com.airborne.mff.model.Type;
import net.dv8tion.jda.core.EmbedBuilder;
import org.apache.commons.lang3.StringUtils;

public class MessageUtil {

    public static void setColor(EmbedBuilder embedBuilder, String name) {
        Type type = Type.getTypeByName(name);
        if (type != null) {
            embedBuilder.setColor(type.getColor());
        }
    }

    public static void addField(EmbedBuilder embedBuilder, String key, String value, boolean inline) {
        if (StringUtils.isNoneBlank(key, value)) {
            embedBuilder.addField(key, value, inline);
        }
    }

    public static void addDescription(EmbedBuilder embedBuilder, boolean hasValue, String value) {
        if (hasValue) {
            embedBuilder.appendDescription(value);
            embedBuilder.appendDescription(" - ");
        }
    }
}
