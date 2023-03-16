package com.quinsic.servicename.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is the API requestBody Mapping object.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestRequestDto {
    private String name;
}
