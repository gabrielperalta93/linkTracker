package com.SpringClase4.LinkTracker.services;

import com.SpringClase4.LinkTracker.dtos.LinkDTO;
import com.SpringClase4.LinkTracker.dtos.LinkCreatedDTO;
import com.SpringClase4.LinkTracker.dtos.LinkRedirectedDTO;
import com.SpringClase4.LinkTracker.exceptions.IncorrectPasswordException;
import com.SpringClase4.LinkTracker.exceptions.InvalidURLException;
import com.SpringClase4.LinkTracker.exceptions.NotValidException;
import com.SpringClase4.LinkTracker.exceptions.ResourceNotFoundException;
import com.SpringClase4.LinkTracker.repositories.LinksRepository;
import com.SpringClase4.LinkTracker.utils.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class LinkTrackerServiceImple implements LinkTrackerService {

    @Autowired
    private LinksRepository linksRepository;

    @Override
    public LinkCreatedDTO createLink(LinkDTO link) throws InvalidURLException {

        if (UrlValidator.urlValidator(link.getUrl())) {
            int newId = linksRepository.addLinkToRepository(link);
            link.setPassword("1234");
            return new LinkCreatedDTO(link.getUrl(), newId, link.isValid());
        }else
            throw new InvalidURLException();
    }

    @Override
    public String redirectLink(int linkId, String password) throws IncorrectPasswordException, NotValidException {
        LinkDTO link = linksRepository.getLinkById(linkId);
        if(link == null){
            throw new ResourceNotFoundException();
        }else if(!link.getPassword().equals(password)){
            throw new IncorrectPasswordException();
        }else if (!link.isValid()){
            throw new NotValidException();
        }
        link.incrementMetric();
        return link.getUrl();
    }

    @Override
    public LinkRedirectedDTO metricsLink(int linkId) {
        LinkDTO link = linksRepository.getLinkById(linkId);
        return new LinkRedirectedDTO(link.getUrl(), link.getMetrics());
    }

    @Override
    public LinkDTO invalidateLink(int linkId) throws NotValidException {
        LinkDTO link = linksRepository.getLinkById(linkId);
        if (link.isValid()){
            linksRepository.invalidateLink(linkId);
        }
        return link;
    }
}
