package com.example.contracts.dto;

import com.example.contracts.dto.DeviseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class PaysDto {
    private Long id;
    private String nom;
    private DeviseDto deviseDto;

}
