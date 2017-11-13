package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class PlayerTest {

    //@Test
    public void bet_test_1() {
        // Arrange
        String json = "";
        JsonElement testee = new JsonParser().parse(json);

        // Execute
        int bet = Player.betRequest(testee);

        // Verify
        assert bet > 0;
    }
}
