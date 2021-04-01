package com.SpringClase4.LinkTracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkCreatedDTO {
    private String url;
    private int linkId;
    private Boolean isValid;
}
