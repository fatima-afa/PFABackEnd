package com.adria.intership.subscribers.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenceDto {

    private Long id;
    private String intituleAgence;
    private Long code;

    private VilleDto villeDto;
}
