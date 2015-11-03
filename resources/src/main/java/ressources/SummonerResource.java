package ressources;


import services.SummonerService;

/**
 * Created by Thomas on 03/11/2015.
 */
public class SummonerResource extends Resource {

    private SummonerResource(Class aClass, String method, Class[] parametersType, Object[] parameters) {
        super(aClass, method, parametersType, parameters);
    }

    public static Resource getSummoner(Integer id){
        return new SummonerResource(SummonerService.class,"getSummoner",new Class[]{id.getClass()},new Object[]{id});
    }

}
