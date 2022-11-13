package com.imageUploader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Upload {

    @Autowired
    private CloudinaryService cloudinaryService;

    @CrossOrigin(origins = "*")
    @PostMapping("/upload")
    public List<Tag> uploadFile(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        String image_url = cloudinaryService.uploadFile(file);

        String credentialsToEncode = "acc_7fdb8d4160abe4e" + ":" + "33d152abb1b8ee9b95bec94b46fa8956";
        String basicAuth = Base64.getEncoder().encodeToString(credentialsToEncode.getBytes(StandardCharsets.UTF_8));

        String endpoint_url = "https://api.imagga.com/v2/tags";
        String url = endpoint_url + "?image_url=" + image_url;

        System.out.println(image_url);
        System.out.println(url);
        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

        connection.setRequestProperty("Authorization", "Basic " + basicAuth);

        int responseCode = connection.getResponseCode();

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader connectionInput = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String jsonResponse = connectionInput.readLine();
        connectionInput.close();
        System.out.println(jsonResponse);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonResponse);
        JSONObject result = (JSONObject)json.get("result");
        JSONArray jsonTags = (JSONArray) result.get("tags");
        Iterator itr = jsonTags.iterator();
        List<Tag> tags = new ArrayList<>();
        int i=0;
        while (itr.hasNext()) {
            Object slide = itr.next();
            JSONObject jsonObject2 = (JSONObject) slide;
            JSONObject info = (JSONObject) jsonObject2.get("tag");
            String label = (String) info.get("en");
            tags.add(new Tag(label));
            i++;
            if(i>=7){
                break;
            }
        }
        return tags;
    }

    @PostMapping("/testUpload")
    public List<Tag> uploadFileTest(@RequestParam("file") String file) throws IOException, ParseException {
        String jsonResponse = "{\"result\":{\"tags\":[{\"confidence\":53.596549987793,\"tag\":{\"en\":\"building\"}},{\"confidence\":49.4747085571289,\"tag\":{\"en\":\"architecture\"}},{\"confidence\":39.3060111999512,\"tag\":{\"en\":\"urban\"}},{\"confidence\":38.5329360961914,\"tag\":{\"en\":\"structure\"}},{\"confidence\":38.1273765563965,\"tag\":{\"en\":\"window\"}},{\"confidence\":31.886100769043,\"tag\":{\"en\":\"glass\"}},{\"confidence\":31.5770740509033,\"tag\":{\"en\":\"city\"}},{\"confidence\":31.5343322753906,\"tag\":{\"en\":\"modern\"}},{\"confidence\":29.5849189758301,\"tag\":{\"en\":\"roof\"}},{\"confidence\":28.2235164642334,\"tag\":{\"en\":\"construction\"}},{\"confidence\":27.4099884033203,\"tag\":{\"en\":\"interior\"}},{\"confidence\":23.9161510467529,\"tag\":{\"en\":\"inside\"}},{\"confidence\":21.2500495910645,\"tag\":{\"en\":\"business\"}},{\"confidence\":21.2091064453125,\"tag\":{\"en\":\"steel\"}},{\"confidence\":20.8622703552246,\"tag\":{\"en\":\"wall\"}},{\"confidence\":20.7680835723877,\"tag\":{\"en\":\"device\"}},{\"confidence\":20.151948928833,\"tag\":{\"en\":\"office\"}},{\"confidence\":19.7616424560547,\"tag\":{\"en\":\"sky\"}},{\"confidence\":19.2884864807129,\"tag\":{\"en\":\"house\"}},{\"confidence\":18.7075500488281,\"tag\":{\"en\":\"light\"}},{\"confidence\":17.817419052124,\"tag\":{\"en\":\"center\"}},{\"confidence\":17.44016456604,\"tag\":{\"en\":\"design\"}},{\"confidence\":17.0671939849854,\"tag\":{\"en\":\"futuristic\"}},{\"confidence\":16.9224338531494,\"tag\":{\"en\":\"hall\"}},{\"confidence\":16.3126468658447,\"tag\":{\"en\":\"windows\"}},{\"confidence\":16.0856685638428,\"tag\":{\"en\":\"metal\"}},{\"confidence\":16.0609035491943,\"tag\":{\"en\":\"buildings\"}},{\"confidence\":15.4250888824463,\"tag\":{\"en\":\"reflection\"}},{\"confidence\":15.057731628418,\"tag\":{\"en\":\"perspective\"}},{\"confidence\":14.78857421875,\"tag\":{\"en\":\"machine\"}},{\"confidence\":14.7241125106812,\"tag\":{\"en\":\"high\"}},{\"confidence\":14.5177898406982,\"tag\":{\"en\":\"industrial\"}},{\"confidence\":14.5084791183472,\"tag\":{\"en\":\"industry\"}},{\"confidence\":13.3608016967773,\"tag\":{\"en\":\"inclined plane\"}},{\"confidence\":13.1722373962402,\"tag\":{\"en\":\"indoors\"}},{\"confidence\":12.5322418212891,\"tag\":{\"en\":\"old\"}},{\"confidence\":11.6334705352783,\"tag\":{\"en\":\"tower\"}},{\"confidence\":11.1615877151489,\"tag\":{\"en\":\"work\"}},{\"confidence\":10.952618598938,\"tag\":{\"en\":\"indoor\"}},{\"confidence\":10.8060464859009,\"tag\":{\"en\":\"ceiling\"}},{\"confidence\":10.4541969299316,\"tag\":{\"en\":\"detail\"}},{\"confidence\":10.3869514465332,\"tag\":{\"en\":\"technology\"}},{\"confidence\":10.1332416534424,\"tag\":{\"en\":\"exterior\"}},{\"confidence\":10.0014781951904,\"tag\":{\"en\":\"wood\"}},{\"confidence\":9.64633846282959,\"tag\":{\"en\":\"factory\"}},{\"confidence\":9.46651363372803,\"tag\":{\"en\":\"airport\"}},{\"confidence\":9.41295337677002,\"tag\":{\"en\":\"tall\"}},{\"confidence\":9.35909366607666,\"tag\":{\"en\":\"skyscraper\"}},{\"confidence\":9.31428718566895,\"tag\":{\"en\":\"equipment\"}},{\"confidence\":9.0608606338501,\"tag\":{\"en\":\"step\"}},{\"confidence\":8.9027681350708,\"tag\":{\"en\":\"new\"}},{\"confidence\":8.81521511077881,\"tag\":{\"en\":\"room\"}},{\"confidence\":8.78566741943359,\"tag\":{\"en\":\"wooden\"}},{\"confidence\":8.75927352905273,\"tag\":{\"en\":\"mall\"}},{\"confidence\":8.58757591247559,\"tag\":{\"en\":\"corporate\"}},{\"confidence\":8.57576942443848,\"tag\":{\"en\":\"bright\"}},{\"confidence\":8.56228637695312,\"tag\":{\"en\":\"mirror\"}},{\"confidence\":8.50893497467041,\"tag\":{\"en\":\"geometric\"}},{\"confidence\":8.42064952850342,\"tag\":{\"en\":\"mechanical device\"}},{\"confidence\":8.32084178924561,\"tag\":{\"en\":\"frame\"}},{\"confidence\":7.98549604415894,\"tag\":{\"en\":\"ventilator\"}},{\"confidence\":7.8897590637207,\"tag\":{\"en\":\"gate\"}},{\"confidence\":7.8464035987854,\"tag\":{\"en\":\"prison\"}},{\"confidence\":7.74187183380127,\"tag\":{\"en\":\"travel\"}},{\"confidence\":7.73051500320435,\"tag\":{\"en\":\"balcony\"}},{\"confidence\":7.72500324249268,\"tag\":{\"en\":\"empty\"}},{\"confidence\":7.6969838142395,\"tag\":{\"en\":\"mechanism\"}},{\"confidence\":7.68370819091797,\"tag\":{\"en\":\"downtown\"}},{\"confidence\":7.6528377532959,\"tag\":{\"en\":\"concrete\"}},{\"confidence\":7.64646434783936,\"tag\":{\"en\":\"trade\"}},{\"confidence\":7.59507417678833,\"tag\":{\"en\":\"beam\"}},{\"confidence\":7.57080268859863,\"tag\":{\"en\":\"build\"}},{\"confidence\":7.55163764953613,\"tag\":{\"en\":\"power\"}},{\"confidence\":7.5247745513916,\"tag\":{\"en\":\"lamp\"}},{\"confidence\":7.41620969772339,\"tag\":{\"en\":\"town\"}},{\"confidence\":7.30419588088989,\"tag\":{\"en\":\"dome\"}},{\"confidence\":7.16459035873413,\"tag\":{\"en\":\"transparent\"}},{\"confidence\":7.07595109939575,\"tag\":{\"en\":\"pipe\"}}]},\"status\":{\"text\":\"\",\"type\":\"success\"}}";

        System.out.println(jsonResponse);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonResponse);
        JSONObject result = (JSONObject)json.get("result");
        JSONArray jsonTags = (JSONArray) result.get("tags");
        Iterator itr = jsonTags.iterator();
        List<Tag> tags = new ArrayList<>();
        int i=0;
        while (itr.hasNext()) {
            Object slide = itr.next();
            JSONObject jsonObject2 = (JSONObject) slide;
            JSONObject info = (JSONObject) jsonObject2.get("tag");
            String label = (String) info.get("en");
            tags.add(new Tag(label));
            i++;
            if(i>=7){
                break;
            }
        }
        return tags;
    }

}
