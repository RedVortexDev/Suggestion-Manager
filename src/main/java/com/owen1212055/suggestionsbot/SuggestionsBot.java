package com.owen1212055.suggestionsbot;

import com.owen1212055.suggestionsbot.instance.InstanceHandler;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class SuggestionsBot {
    public static InstanceHandler instance = new InstanceHandler();

    public static void main(String[] args) throws LoginException, InterruptedException, SQLException {
        instance.startup();


    }

}
