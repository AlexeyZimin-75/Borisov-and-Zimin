import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CitiesAndCapitals {
    private static final String filePath = "123.csv";
    public static Map.Entry<String,String> getRandomPair(){
        Random random = new Random();
        List<Map.Entry<String, String>> entryList = new ArrayList<>(storage.entrySet());
        int randomIndex = random.nextInt(entryList.size());
        return entryList.get(randomIndex);


    }
    private static final Map<String, String> storage = new HashMap<>();
    static {

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))){

            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");

                if(parts.length >= 2){
                    String country = parts[0].trim();
                    String capital = parts[1].trim();

                    storage.put(country,capital);
                }

            }
           
       } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


