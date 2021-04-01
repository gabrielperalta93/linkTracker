package com.SpringClase4.LinkTracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;


@Data
@AllArgsConstructor
public class LinkDTO {

    private String url;
    private int linkId;
    private int metrics;
    private String password;
    private boolean isValid;

    public void incrementMetric(){
        metrics++;
    }
}
