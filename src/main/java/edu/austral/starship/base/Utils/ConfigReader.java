package edu.austral.starship.base.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConfigReader {

    public static List<StarshipKeySet> readFile() {
        List<StarshipKeySet> starshipKeySets = new ArrayList<>();
        File file = new File("/Users/lucas.garcia/Projetcts/Austral/starships/src/main/resources/config.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String st = null;
        while (true) {
            try {
                if (!((st = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            Object[] config = st.split(",");
            int[] keys = new int[config.length];
            for (int i = 0; i < config.length; i++) {
                if (i == 0 || i == 1) keys[i] = Integer.parseInt((String) config[i]);
                else keys[i] = (int)(((String)config[i]).toUpperCase().toCharArray()[0]);
            }
            starshipKeySets.add(new StarshipKeySet(keys));
        }

        return starshipKeySets;
    }
}