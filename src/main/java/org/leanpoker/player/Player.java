package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

    static final String VERSION = "SEM Java folding player Version 0.0.9";
    public static final String SEMPOKER = "sempoker";
    public static final String ACTIVE = "active";

    public static int betRequest(JsonElement request) {
        JsonObject jsonObject = request.getAsJsonObject();
        int current_buy_in = jsonObject.get("current_buy_in").getAsInt();
        int minimum_raise = jsonObject.get("minimum_raise").getAsInt();
        JsonArray players = jsonObject.get("players").getAsJsonArray();
        int bets = 0;
        int myStack = 0;
        for (JsonElement player : players) {
            JsonObject playerAsJsonObject = player.getAsJsonObject();
            String status = playerAsJsonObject.get("status").getAsString();
            String name = playerAsJsonObject.get("name").getAsString();
            int bet = playerAsJsonObject.get("bet").getAsInt();
            if (!name.equals(SEMPOKER) && status.equals(ACTIVE)) {
                bets += bet;
            }
            if (name.equals(SEMPOKER)) {
                myStack = playerAsJsonObject.get("stack").getAsInt();
            }
        }

        return myStack / 2;
    }

    public static void showdown(JsonElement game) {
    }
}
