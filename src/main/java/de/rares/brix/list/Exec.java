package de.rares.brix.list;

import de.rares.brix.Brix;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Exec extends Thread {


    public MessageReceivedEvent e;
    public Guild g;

    public Exec(MessageReceivedEvent e) {
        this.e = e;
    }

    @Override
    public void run() {
        Guild g = e.getGuild();
        Member m = e.getMember();
        String msg = e.getMessage().getContentRaw();
        if (msg.startsWith("#")) {

            if (msg.startsWith("#ban")) {

                for (User mentionedUser : e.getMessage().getMentionedUsers()) {

                    g.getMember(mentionedUser).ban(7).queue();
                }

            } else if (msg.startsWith("#kick")) {

                for (User mentionedUser : e.getMessage().getMentionedUsers()) {

                    g.getMember(mentionedUser).kick().queue();
                }


            } else if (msg.startsWith("#mute")) {

                for (User mentionedUser : e.getMessage().getMentionedUsers()) {

                    for (TextChannel textChannel : g.getTextChannels()) {
                        textChannel.createPermissionOverride(g.getMember(mentionedUser)).deny(Permission.MESSAGE_WRITE).queue();
                    }
                }


            } else if (msg.startsWith("#unmute")) {

                for (User mentionedUser : e.getMessage().getMentionedUsers()) {

                    for (TextChannel textChannel : g.getTextChannels()) {
                        textChannel.getPermissionOverride(g.getMember(mentionedUser)).delete().queue();
                    }
                }


            } else if (msg.startsWith("#unban")) {

                for (User mentionedUser : e.getMessage().getMentionedUsers()) {

                    g.unban(mentionedUser).queue();
                }


            }
        } else {

            for (String s : Brix.schimpfwoerter) {
                if(msg.toLowerCase().contains(s)){
                    e.getMessage().delete().queue();
                    e.getChannel().sendMessage("Bitte achte auf darauf wie du mit deinen Mitspielern schreibst!").queue(me ->{
                        try {
                            sleep(10000);
                            me.delete().queue();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    });
                    break;
                }
            }

        }
    }
}
