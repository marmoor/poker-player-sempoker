package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Player {

    static final String VERSION = "SEM Java folding player Version 0.0.4";

    public static int betRequest(JsonElement request) {
        System.out.println("betRequest: " + request);

        JsonObject jsonObject = request.getAsJsonObject();
        int current_buy_in = jsonObject.get("current_buy_in").getAsInt();
        int minimum_raise = jsonObject.get("minimum_raise").getAsInt();
        JsonArray players = jsonObject.get("players").getAsJsonArray();
        int bets = 0;
        for (JsonElement player : players) {
            JsonObject playerAsJsonObject = player.getAsJsonObject();
            String status = playerAsJsonObject.get("status").getAsString();
            int bet = playerAsJsonObject.get("bet").getAsInt();
            if (status.equals("active")) {
                bets += bet;
            }
        }
        return current_buy_in - bets + minimum_raise;
    }

    public static void showdown(JsonElement game) {
        System.out.println("showdown: " + game);
    }
}
