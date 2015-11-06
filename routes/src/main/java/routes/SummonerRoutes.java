package routes;

/**
 * Created by Thomas on 03/11/2015.
 */
public class SummonerRoutes {

    public static String getSummoner(String region,Integer... ids){
        String res = "api/lol/" + region + "/v1.4/summoner/";
        for (Integer id : ids) {
            res = res.concat(id + ",");
        }
        return res.substring(0,res.length() - 1);
    }

    public static String getSummoner(Integer... ids){
        return getSummoner("euw",ids);
    }
}
