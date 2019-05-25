package com.airborne.mff;

import com.airborne.mff.command.CharacterCommand;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.security.auth.login.LoginException;

@Component
public class DiscordBot {

    private static final Logger logger = LogManager.getLogger();

    private JDA jda;

    @Value("${jda.discord.token}")
    private String token;

    @Value("${jda.discord.client_id}")
    private String ownerId;

    @Autowired
    CharacterCommand characterCommand;

    @PostConstruct
    public void setup() throws Exception {
        startBot();
    }

    @PreDestroy
    public void shutdown() {
        jda.shutdown();
    }

    public void startBot() throws LoginException, InterruptedException {
        CommandClientBuilder clientBuilder = new CommandClientBuilder();
        clientBuilder.setOwnerId(ownerId);
        clientBuilder.setPrefix("!");
        clientBuilder.addCommand(characterCommand);

        jda = new JDABuilder(AccountType.BOT)
                .setToken(token)
                .addEventListener(clientBuilder.build())
                .build();

        logger.info("Discord bot ready");
        jda.awaitReady();
    }

    public JDA getJda() {
        return this.jda;
    }
}
