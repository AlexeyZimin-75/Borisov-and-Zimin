import java.util.Map;

public class PlayerData {
    private String playerName;
    private int playerScore = 0;
    Map<String,String> countriesAndCapitals = CountriesAndCapitals.getCountriesAndCapitals();

    public PlayerData (String name){
        this.playerName = name;
    }

    public void removeCountry(String country){
        countriesAndCapitals.remove(country);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void addOneScore(){
        playerScore += 1;
    }
}