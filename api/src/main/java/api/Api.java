package api;

import api.util.HttpMethod;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import jdk.nashorn.internal.parser.JSONParser;
import responses.Response;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Thomas on 03/11/2015.
 * Need to be reviewed for multiples requests at same time
 */
public class Api {

    //Singleton
    private static Api instance;
    //Url de l'api
    private static String baseUri = "https://euw.api.pvp.net/";
    private static String apiKey = System.getenv("riotApiKey");

    private Class responseClass;
    private String route;

    private Api() {
    }

    /**
     * Singleton get
     * @return
     */
    public static Api get(){
        if(instance == null ){instance = new Api();}
        return instance;
    }

    private static String getApiKey() {
        return "?api_key=" + apiKey;
    }

    public void setResponseClass(Class<Response> responseClass) {
        this.responseClass = responseClass;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Api path(String route, Class response){
        this.setResponseClass(response);
        this.setRoute(route);
        return this;
    }

    private String prepareUri(){
        return baseUri + route + getApiKey();
    }

    public Object execute() throws Exception {
        URL url = new URL(prepareUri());

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(url, (Class<Response>) responseClass);
    }
}
