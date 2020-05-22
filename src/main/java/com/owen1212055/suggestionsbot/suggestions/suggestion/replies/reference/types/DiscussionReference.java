package com.owen1212055.suggestionsbot.suggestions.suggestion.replies.reference.types;

import com.owen1212055.suggestionsbot.suggestions.reactions.Reaction;
import com.owen1212055.suggestionsbot.suggestions.suggestion.Suggestion;
import com.owen1212055.suggestionsbot.suggestions.suggestion.replies.reference.Reference;
import com.owen1212055.suggestionsbot.util.BotConstants;
import com.owen1212055.suggestionsbot.util.Util;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

public class DiscussionReference extends Reference {

    @Override
    public String getName() {
        return "discussion_message";
    }

    @Override
    public long getChannelID() {
        return BotConstants.DISCUSSION;
    }

    @Override
    public boolean syncEmojis() {
        return true;
    }

    @Override
    public boolean mustExist() {
        return false;
    }

    @Override
    public MessageEmbed create(Suggestion suggestion) {
        EmbedBuilder builder = new EmbedBuilder();
        Message message = suggestion.getSuggestion();
        builder.setAuthor(message.getAuthor().getName(), null, message.getAuthor().getEffectiveAvatarUrl());

        Reaction reaction = suggestion.reactionManager.getTopReaction();
        builder.setColor(reaction != null ? reaction.getColor() : Color.gray);

        builder.setDescription(String.format("\uD83D\uDCE8 [New %s posted](" + message.getJumpUrl() + ")", suggestion.getChannel().getName().toLowerCase()));


        builder.addField("\u200b", Util.trim(message.getContentRaw(), 256), false);

        builder.setFooter("Posted in #" + message.getChannel().getName());

        return builder.build();
    }
}
