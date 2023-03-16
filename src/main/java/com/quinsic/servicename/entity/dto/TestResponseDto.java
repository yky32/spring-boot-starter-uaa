package com.quinsic.servicename.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * you can not to disclose all the persistent object data to the endpoint.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestResponseDto {
    private String anotherValue;
}
