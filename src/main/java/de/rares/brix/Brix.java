package de.rares.brix;

import de.rares.brix.list.Listener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

public class Brix {

    public static ArrayList<String> schimpfwoerter = new ArrayList<>();

    public static void main(String[] args) throws LoginException {

        schimpfwoerter.add("hurensohn");
        schimpfwoerter.add("huso");
        schimpfwoerter.add("idiot");
        schimpfwoerter.add("wixxer");
        schimpfwoerter.add("wixer");
        schimpfwoerter.add("arschloch");
        schimpfwoerter.add("misgeburt");
        schimpfwoerter.add("missgeburt");
        schimpfwoerter.add("fick");

        JDA jda = new JDABuilder("")
                .setActivity(Activity.playing("Grad am Arbeiten"))
                .addEventListeners(new Listener())
                .build();
    }



}
