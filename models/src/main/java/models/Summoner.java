package models;

import responses.SummonerResponse;

/**
 * Created by Thomas on 03/11/2015.
 * Model for summoner final class instantiate
 * This represent ONE summoner
 */
public class Summoner {

    private Integer id;
    private String name;
    private String profileIconId;
    private Integer summonerLevel;
    private Integer revisionDate;

    public Summoner(Integer id, String name, String profileIconId, Integer summonerLevel, Integer revisionDate) {
        this.id = id;
        this.name = name;
        this.profileIconId = profileIconId;
        this.summonerLevel = summonerLevel;
        this.revisionDate = revisionDate;
    }

    public Summoner(SummonerResponse summonerResponse) {
        this(summonerResponse.id,summonerResponse.name,summonerResponse.profileIconId,summonerResponse.revisionDate,summonerResponse.summonerLevel);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfileIconId() {
        return profileIconId;
    }

    public Integer getSummonerLevel() {
        return summonerLevel;
    }

    public Integer getRevisionDate() {
        return revisionDate;
    }
}
