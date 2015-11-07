package resources;


import services.SummonerService;

/**
 * Created by Thomas on 03/11/2015.
 * Here we can see that we load 1 or N summoners with the same method
 */
public class SummonerResource extends Resource {

    private SummonerResource(Class aClass, String method,Class[] parametersType,Object[] parameters) {
        super(aClass, method, parametersType, parameters);
    }

    public static Resource getSummoner(Integer id){
        return new SummonerResource(SummonerService.class,"load",new Class[]{id.getClass()},new Object[]{id});
    }

    public static Resource getSummoners(Integer[] ids){
        return new SummonerResource(SummonerService.class,"load",new Class[]{ids.getClass()},ids);
    }

}
