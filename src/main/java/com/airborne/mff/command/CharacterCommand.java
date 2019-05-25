package com.airborne.mff.command;

import com.airborne.mff.model.Character;
import com.airborne.mff.model.CharacterType;
import com.airborne.mff.service.CharacterService;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.airborne.mff.util.Constants.*;
import static com.airborne.mff.util.MessageUtil.addDescription;
import static com.airborne.mff.util.MessageUtil.addField;
import static com.airborne.mff.util.MessageUtil.setColor;

@Component
public class CharacterCommand extends Command {

    @Autowired
    CharacterService characterService;

    public CharacterCommand() {
        this.name = "char";
        this.cooldown = 2;
    }

    @Override
    public void execute(CommandEvent event) {
        String content = event.getArgs();
        if (StringUtils.isBlank(content)) {
            return;
        }
        List<String> arguments = Arrays.asList(StringUtils.split(content, StringUtils.SPACE));
        if (arguments.isEmpty()) {
            return;
        }
        Message result = getCharacterInfo(arguments.get(0));
        if (result != null) {
            event.getChannel().sendMessage(result).queue();
        }
    }

    public Message getCharacterInfo(String name) {
        if (StringUtils.isBlank(name)) return null;

        Character character = characterService.getByName(name);

        return getCharacterMessage(character);
    }

    private Message getCharacterMessage(Character character) {
        if (character == null) return null;

        MessageBuilder messageBuilder = new MessageBuilder();
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle(character.getName());

        setColor(embedBuilder, character.getType());

        addDescription(embedBuilder, character.isNative(), CHARACTER_IS_NATIVE);
        addDescription(embedBuilder, character.isHasDebuff(), CHARACTER_HAS_DEBUFF);
        addDescription(embedBuilder, character.isHasReflect(), CHARACTER_HAS_REFLECT);
        addDescription(embedBuilder, character.isSupport(), CHARACTER_IS_SUPPORT);

        addField(embedBuilder, "type", character.getType(), false);
        addField(embedBuilder, "leadership", character.getLeadership(), true);
        addField(embedBuilder, "t1 passive", character.getT1Passive(), false);
        addField(embedBuilder, "t2 passive", character.getT2Passive(), true);
        addField(embedBuilder, "t3 ability", character.getT3Ability(), false);

        embedBuilder.setThumbnail("http://localhost:8080/character/image");
        messageBuilder.setEmbed(embedBuilder.build());

        return messageBuilder.build();
    }
}