package tour;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/tour")
public class TourController {

    @Value("${dataPortal-API-KEY}")
    private String serviceKey;

    @GetMapping
    public String showDefault() {
        return "redirect:/tour/list";
    }

    @GetMapping("/list")
    public String list(Model model) {

        String baseUrl = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1";

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("numOfRows","20")
                .queryParam("pageNo","1")
                .queryParam("MobileOS","etc")
                .queryParam("MobileApp","test")
                .queryParam("_type","json")
                .queryParam("listYN","Y")
                .queryParam("arrange","A")
                .queryParam("contentTypeId","12")
                .queryParam("areaCode","4")
                .queryParam("serviceKey", serviceKey)
                .build(false);

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        RestTemplate template = new RestTemplate(factory);

        ResponseEntity<String> response = template.getForEntity(uriComponents.toUriString(), String.class);

        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject) parser.parse(response.getBody());
            JSONObject responseData = (JSONObject) object.get("response");
            JSONObject body = (JSONObject) responseData.get("body");
            JSONObject items = (JSONObject) body.get("items");
            JSONArray item = (JSONArray) items.get("item");
            for (Object tourItem : item) {

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "/tour/list";
    }
}
