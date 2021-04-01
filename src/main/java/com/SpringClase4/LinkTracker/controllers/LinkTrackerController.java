package com.SpringClase4.LinkTracker.controllers;


import com.SpringClase4.LinkTracker.dtos.ErrorDTO;
import com.SpringClase4.LinkTracker.dtos.LinkDTO;
import com.SpringClase4.LinkTracker.exceptions.IncorrectPasswordException;
import com.SpringClase4.LinkTracker.exceptions.InvalidURLException;
import com.SpringClase4.LinkTracker.exceptions.NotValidException;
import com.SpringClase4.LinkTracker.services.LinkTrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkTrackerController {

    private LinkTrackerService linkTrackerService;

    public LinkTrackerController(LinkTrackerService linkTrackerService) throws NotValidException {
        this.linkTrackerService = linkTrackerService;
    }


    @PostMapping("/link")
    public ResponseEntity createLink(@RequestBody LinkDTO link) throws InvalidURLException {
        return new ResponseEntity(linkTrackerService.createLink(link), HttpStatus.OK);
    }

    @PostMapping("/invalidate")
    public ResponseEntity invalidateLink(@RequestParam int linkId) throws NotValidException {
        return new ResponseEntity(linkTrackerService.invalidateLink(linkId), HttpStatus.OK);
    }

    @GetMapping("/metrics")
    public ResponseEntity statistics(@RequestParam int linkId){
        return new ResponseEntity(linkTrackerService.metricsLink(linkId), HttpStatus.OK);
    }

    @GetMapping("/redirect")
    public RedirectView redirect(@RequestParam int linkId, @RequestParam String Password) throws IncorrectPasswordException, NotValidException {
        String link = linkTrackerService.redirectLink(linkId, Password);
        return new RedirectView(link);
    }

    @ExceptionHandler(value = {InvalidURLException.class})
    public ResponseEntity<ErrorDTO> handleException(InvalidURLException errorException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Invalid URL format");
        errorDTO.setMessage("The URL " + errorException.getMessage() + " is invalid");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
