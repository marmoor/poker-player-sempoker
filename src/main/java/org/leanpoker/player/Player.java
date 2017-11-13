package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "SEM Java folding player Version 0.0.15";
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

        Map<String, Integer> values = new HashMap<>();
        add2map(hole1, values);
        add2map(hole2, values);
        for (JsonElement cardElement : jsonObject.get("community_cards").getAsJsonArray()) {
            String rank = cardElement.getAsJsonObject().get("rank").getAsString();
            add2map(rank, values);
        }
        int maxIdentical = 0;
        for (String key : values.keySet()) {
            if (values.get(key) > maxIdentical) {
                maxIdentical = values.get(key);
            }
        }


        // 10 and J,Q,K,A
        List<String> goodCards = Arrays.asList(new String[]{"10", "J", "Q", "K", "A"});
        if (maxIdentical >= 0 || (goodCards.contains(hole1) && goodCards.contains(hole2))) {
            return myStack;
        } else {
            return 0;
        }

        //    int result = 0;
        //      result = current_buy_in - myBet + minimum_raise;


//        return result;
    }

    private static void add2map(String hole1, Map<String, Integer> values) {
        if (!values.containsKey(hole1)) {
            values.put(hole1, 1);
        } else {
            values.put(hole1, values.get(hole1) + 1);
        }
    }

    public static void showdown(JsonElement game) {
    }

}
