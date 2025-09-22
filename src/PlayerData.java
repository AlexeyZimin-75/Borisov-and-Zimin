public class PlayerData {
    String playerName;
    int playerScore;

    public PlayerData (String[] playerData) {
        this.playerName = playerData[0];
        this.playerScore = Integer.parseInt(playerData[1]);
    }
}
