package org.leanpoker.player;

import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "SEM Java folding player Version 0.0.3";

    public static int betRequest(JsonElement request) {
        System.out.println("betRequest: " + request);

        return 10;
    }

    public static void showdown(JsonElement game) {
        System.out.println("showdown: " + game);
    }
}
