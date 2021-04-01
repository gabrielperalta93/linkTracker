package com.SpringClase4.LinkTracker.services;

import com.SpringClase4.LinkTracker.dtos.LinkDTO;
import com.SpringClase4.LinkTracker.dtos.LinkCreatedDTO;
import com.SpringClase4.LinkTracker.dtos.LinkRedirectedDTO;
import com.SpringClase4.LinkTracker.exceptions.IncorrectPasswordException;
import com.SpringClase4.LinkTracker.exceptions.InvalidURLException;
import com.SpringClase4.LinkTracker.exceptions.NotValidException;

public interface LinkTrackerService {

    public LinkCreatedDTO createLink(LinkDTO link) throws InvalidURLException;

    public String redirectLink(int linkId, String password) throws IncorrectPasswordException, NotValidException;

    public LinkRedirectedDTO metricsLink(int linkId);

    public LinkDTO invalidateLink(int linkId) throws NotValidException;


}
