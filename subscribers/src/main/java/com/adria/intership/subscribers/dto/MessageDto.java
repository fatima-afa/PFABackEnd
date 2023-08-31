package com.adria.intership.subscribers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageDto {

    private Long id;
    private String sujet;
    private String Message;
    private BODto bo;
    private AbonneDto abonne;
}
