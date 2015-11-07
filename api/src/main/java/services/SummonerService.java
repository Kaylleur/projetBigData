package services;

import api.Api;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Summoner;
import responses.SummonerResponse;
import routes.SummonerRoutes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Thomas on 03/11/2015.
 * Each action for summonerS will be here
 * action for ONE summoner will be in the model
 */
public class SummonerService {

    public static Summoner load(Integer id) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        HashMap<String, Object> json =(HashMap<String,Object>) Api.get().path(SummonerRoutes.getSummoner(id), Map.class).execute();

//        System.out.println(mapper.convertValue(json.get(json.keySet().toArray()[0]), SummonerResponse.class));
        return new Summoner(mapper.convertValue(json.get(json.keySet().toArray()[0]), SummonerResponse.class));
    }

}
