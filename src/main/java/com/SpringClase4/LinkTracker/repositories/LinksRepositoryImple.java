package com.SpringClase4.LinkTracker.repositories;

import com.SpringClase4.LinkTracker.dtos.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinksRepositoryImple implements LinksRepository{

    private int id = 0;
    private HashMap<Integer, LinkDTO> repo = new HashMap<>();

    @Override
    public LinkDTO getLinkById(int linkId) {
        LinkDTO sdd = repo.get(linkId);
        return repo.get(linkId);
    }

    @Override
    public int addLinkToRepository(LinkDTO link) {
        int ret = this.incrementId();
        link.setValid(true);
        repo.put(ret,link);
        return ret;
    }

    public void incrementMetric(int linkId){
        repo.get(linkId).incrementMetric();
    }

    public void invalidateLink(int linkId){
        repo.get(linkId).setValid(false);
    }

    public int incrementId(){
        this.id++;
        return this.id;
    }

}
