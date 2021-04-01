package com.SpringClase4.LinkTracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkRedirectedDTO {
    private String url;
    private int timesRedirected;
}
