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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

@Controller
@RequestMapping("/tour")
public class TourController {

    @Value("${dataPortal-API-KEY}")
    private String serviceKey;

    private HashMap<String, TourListDto> tourList = new HashMap<>();

    @GetMapping
    public String showDefault() {
        return "redirect:/tour/list";
    }

    private ResponseEntity<String> apiCall(UriComponents uriComponents) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        RestTemplate template = new RestTemplate(factory);

        ResponseEntity<String> response = template.getForEntity(uriComponents.toUriString(), String.class);

        return response;
    }

    private JSONArray jsonParsing(ResponseEntity<String> response) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(response.getBody());
            JSONObject responseData = (JSONObject) object.get("response");
            JSONObject body = (JSONObject) responseData.get("body");
            JSONObject items = (JSONObject) body.get("items");
            JSONArray item = (JSONArray) items.get("item");
            return item;
        } catch (ParseException e) {
            throw new NullPointerException();
        }
    }

    @GetMapping("/list")
    public String list(Model model) {

        String baseUrl = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1";

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("numOfRows","300")
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

        ResponseEntity<String> response = apiCall(uriComponents);

        JSONArray item = jsonParsing(response);

        for(int i = 0; i < item.size(); i++){
            JSONObject tourData = (JSONObject) item.get(i);
            TourListDto tourListDto = new TourListDto();
            if (tourData.get("firstimage").equals("")) {
                continue;
            }
            tourListDto.setThumbnailImage(String.valueOf(tourData.get("firstimage")));
            tourListDto.setContentId(String.valueOf(tourData.get("contentid")));
            tourListDto.setTitle(String.valueOf(tourData.get("title")));
            String address = String.valueOf(tourData.get("addr1"));
            if (address.contains("대구 ")) {
                address = address.replace("대구","대구광역시");
            }
            tourListDto.setAddress(address);
            tourList.put(tourListDto.getContentId(), tourListDto);
        }
        model.addAttribute("tourList", tourList);
        return "/tour/list";
    }

    private void setTourDetailOverview(String tourId, TourDetailDto tourDetailDto) {
        String baseUrl = "https://apis.data.go.kr/B551011/KorService1/detailCommon1";

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("numOfRows","1")
                .queryParam("pageNo","1")
                .queryParam("MobileOS","etc")
                .queryParam("MobileApp","test")
                .queryParam("_type","json")
                .queryParam("contentTypeId","12")
                .queryParam("contentId",tourId)
                .queryParam("defaultYN","Y")
                .queryParam("overviewYN","Y")
                .queryParam("serviceKey", serviceKey)
                .build(false);

        ResponseEntity<String> response = apiCall(uriComponents);

        JSONArray item = jsonParsing(response);

        for(int i = 0; i < item.size(); i++) {
            JSONObject tourDetail = (JSONObject) item.get(i);
            tourDetailDto.setOverview(String.valueOf(tourDetail.get("overview")));
            tourDetailDto.setContentId(String.valueOf(tourDetail.get("contentid")));
        }
    }

    private void setTourDetailInfo(String tourId, TourDetailDto tourDetailDto) {
        String baseUrl = "https://apis.data.go.kr/B551011/KorService1/detailIntro1";

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("numOfRows","1")
                .queryParam("pageNo","1")
                .queryParam("MobileOS","etc")
                .queryParam("MobileApp","test")
                .queryParam("_type","json")
                .queryParam("contentTypeId","12")
                .queryParam("contentId",tourId)
                .queryParam("serviceKey", serviceKey)
                .build(false);

        ResponseEntity<String> response = apiCall(uriComponents);

        JSONArray item = jsonParsing(response);

        for(int i = 0; i < item.size(); i++) {
            JSONObject tourDetail = (JSONObject) item.get(i);
            tourDetailDto.setInfoCenter(String.valueOf(tourDetail.get("infocenter")));
            tourDetailDto.setParkingInfo(String.valueOf(tourDetail.get("parking")));
        }
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("tourId") String tourId, Model model) {

        TourDetailDto tourDetailDto = new TourDetailDto();

        setTourDetailOverview(tourId, tourDetailDto);
        setTourDetailInfo(tourId, tourDetailDto);

        model.addAttribute("tourDetail", tourDetailDto);
        model.addAttribute("tourInfo", tourList);

        return "/tour/detail";
    }
}
