package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.List;

public class Player {

    static final String VERSION = "SEM Java folding player Version 0.0.14";
    public static final String SEMPOKER = "sempoker";
    public static final String ACTIVE = "active";

    public static int betRequest(JsonElement request) {
        JsonObject jsonObject = request.getAsJsonObject();
        int current_buy_in = jsonObject.get("current_buy_in").getAsInt();
        int minimum_raise = jsonObject.get("minimum_raise").getAsInt();
        int orbits = jsonObject.get("orbits").getAsInt();

        JsonArray players = jsonObject.get("players").getAsJsonArray();
        int myBet = 0;
        int myStack = 0;
        String hole1 = "";
        String hole2 = "";
        for (JsonElement player : players) {
            JsonObject playerAsJsonObject = player.getAsJsonObject();
            String status = playerAsJsonObject.get("status").getAsString();
            String name = playerAsJsonObject.get("name").getAsString();
            int bet = playerAsJsonObject.get("bet").getAsInt();
            if (name.equals(SEMPOKER)) {
                myBet = playerAsJsonObject.get("bet").getAsInt();
                myStack = playerAsJsonObject.get("stack").getAsInt();
                JsonArray hole_cards = playerAsJsonObject.getAsJsonArray("hole_cards");
                hole1 = hole_cards.get(0).getAsJsonObject().get("rank").getAsString();
                hole2 = hole_cards.get(1).getAsJsonObject().get("rank").getAsString();
            }
        }

        // 10 and J,Q,K,A
        List<String> goodCards = Arrays.asList(new String[]{"10", "J", "Q", "K", "A"});
        if (goodCards.contains(hole1) && goodCards.contains(hole2)) {
            return myStack;
        } else {
            return 0;
        }

        //    int result = 0;
        //      result = current_buy_in - myBet + minimum_raise;


//        return result;
    }

    public static void showdown(JsonElement game) {
    }
}
