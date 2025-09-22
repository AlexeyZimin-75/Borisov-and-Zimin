import java.util.ArrayList;
import java.util.List;

public class Players {
    private static List<PlayerData> players = new ArrayList<PlayerData>();

    public void add(PlayerData player){
        players.add(player);
    }

    public static List<PlayerData> getPlayers() {
        return players;
    }
}
