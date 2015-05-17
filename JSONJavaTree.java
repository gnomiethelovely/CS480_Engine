/*
Sample: testing how Json works
 Parse JSON-format text file to a tree model using Java.
 Using the gson library.
 */

import com.google.gson.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JSONJavaTree {

    public static void main(String args[]) throws IOException {
        String text = getText("jsonexample.json");
        //Gson gson = new Gson();
        //gson.fromJson(jsonText, JSONJavaTree.class);
        JsonParser parser = new JsonParser();
        /*
         parsing will return a Json element which can either be
         a JsonObject(node), JsonArray(list of nodes), JsonPrimitive,
         or a JsonNull
         */
        JsonElement element = parser.parse(text); //should be at the rootnode
        if (element.isJsonObject()) {
            //gets albums
            JsonObject albums = element.getAsJsonObject();
            System.out.println(albums.get("title").getAsString());
            JsonArray datasets = albums.getAsJsonArray("dataset");
            for (int i = 0; i < datasets.size(); i++) {
                JsonObject dataset = datasets.get(i).getAsJsonObject();
                System.out.println(dataset.get("album_title").getAsString());
            }
        }

    }

    public static String getText(String textfile) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(textfile));

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        } finally {
            br.close();
        }

    }

}
