package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import responses.Response;

import java.net.URL;

/**
 * Created by Thomas on 03/11/2015.
 * //TODO Need to be reviewed for multiples requests at same time
 */
public class Api {

    //Singleton
    private static Api instance;
    //Url de l'api
    private static String baseUri = "https://euw.api.pvp.net/";
    //the key used
    private static String apiKey = System.getenv("riotApiKey");

    //The class used to parse json
    private Class responseClass;
    //the route
    private String route;

    private Api() {
        if(apiKey == null) System.out.println("ERROR : Api key not find ! Couldn't communicate with the API.");
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

    /**
     * set response and route
     * @param route
     * @param response
     * @return
     */
    public Api path(String route, Class response){
        this.responseClass = response;
        this.route = route;
        return this;
    }

    /**
     * parse uri
     * @return
     */
    private String prepareUri(){
        return baseUri + route + getApiKey();
    }

    /**
     * Execute the request and try to parse into responseClass
     * @return
     * @throws Exception
     */
    public Object execute() throws Exception {
        URL url = new URL(prepareUri());

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(url, (Class<Response>) responseClass);
    }
}
