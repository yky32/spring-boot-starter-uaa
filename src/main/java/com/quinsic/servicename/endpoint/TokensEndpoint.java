package com.quinsic.servicename.endpoint;


import com.quinsic.core.response.R;
import com.quinsic.core.response.Result;
import com.quinsic.servicename.entity.dto.CreateTokenRequestDto;
import com.quinsic.servicename.entity.dto.CreateTokenResponseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
@AllArgsConstructor
@Slf4j
@SecurityRequirement(name = "uaa-tokens-api")
public class TokensEndpoint {
    @PostMapping
    public Result<CreateTokenResponseDto> create(CreateTokenRequestDto requestDto) {
        return R.success(null);
    }
}
