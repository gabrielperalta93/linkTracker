package com.SpringClase4.LinkTracker.repositories;

import com.SpringClase4.LinkTracker.dtos.LinkDTO;

public interface LinksRepository {
    public LinkDTO getLinkById(int linkId);

    public int addLinkToRepository(LinkDTO link);

    void invalidateLink(int linkId);

}
