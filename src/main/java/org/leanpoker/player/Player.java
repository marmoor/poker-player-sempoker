package org.leanpoker.player;

import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "SEM Java folding player Version 0.0.7";

    public static int betRequest(JsonElement request) {
        return 10;

        /*
        JsonObject jsonObject = request.getAsJsonObject();
        int current_buy_in = jsonObject.get("current_buy_in").getAsInt();
        int minimum_raise = jsonObject.get("minimum_raise").getAsInt();
        JsonArray players = jsonObject.get("players").getAsJsonArray();
        int bets = 0;
        for (JsonElement player : players) {
            JsonObject playerAsJsonObject = player.getAsJsonObject();
            String status = playerAsJsonObject.get("status").getAsString();
            String name = playerAsJsonObject.get("name").getAsString();
            int bet = playerAsJsonObject.get("bet").getAsInt();
            if (!name.equals("sempoker") && status.equals("active")) {
                bets += bet;
            }
        }
//        return current_buy_in - bets + minimum_raise + 1;
        return current_buy_in + 10;
        */
    }

    public static void showdown(JsonElement game) {
    }
}
