package APICalling.giphyAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import APICalling.giphyAPI.Service.GiphyService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GiphyController 
{
    @Autowired
    GiphyService giphyService;

    @GetMapping(path="/search", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<String> giphySearcher(@RequestParam String item)
    {
        return giphyService.getGiphy(item);
    }
}
