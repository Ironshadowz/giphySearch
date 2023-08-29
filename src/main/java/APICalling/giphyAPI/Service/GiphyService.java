package APICalling.giphyAPI.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;



@Service
public class GiphyService 
{
    @Value("${GIPHY_URL}")
    private String GIPHYURL;

    @Value("${GIPHY_KEY}")
    private String GIPHYKEY;

    public List<String> getGiphy(String searchItem)
    {
        String giphyURL = UriComponentsBuilder
                            .fromUriString(GIPHYURL)
                            .queryParam("q", searchItem)
                            .queryParam("api_key", GIPHYKEY)
                            .toUriString();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> s = template.getForEntity(giphyURL, String.class);
    
        InputStream is = new ByteArrayInputStream(s.getBody().getBytes());
        JsonReader r = Json.createReader(is);
        JsonObject o = r.readObject();
        JsonArray ja = o.getJsonArray("data");
        System.out.println(ja.getJsonObject(0));

        List<JsonObject> jo = new LinkedList<>();
        for(int i=0; i<ja.size(); i++)
        {
            jo.add(i, ja.getJsonObject(i));
        }
        
        List<String> jsonList = new LinkedList<>();
        for(int i=0; i<jo.size();i++)
        {
            jsonList.add(i, jo.get(i).getJsonObject("images").getJsonObject("fixed_height").getString("url"));
        }

        System.out.println(jsonList);
        return jsonList;
        
    }

}
