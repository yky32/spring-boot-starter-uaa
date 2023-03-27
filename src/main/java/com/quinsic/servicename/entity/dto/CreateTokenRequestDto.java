package com.quinsic.servicename.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTokenRequestDto {
    private String username;
    private String credentials; // need to be hashed value.
}
