package com.quinsic.servicename.endpoint;

import com.quinsic.core.exception.BizException;
import com.quinsic.core.response.R;
import com.quinsic.core.response.Result;
import com.quinsic.core.response.SystemResponse;
import com.quinsic.servicename.entity.dto.TestRequestDto;
import com.quinsic.servicename.entity.dto.TestResponseDto;
import com.quinsic.servicename.service.TestService;
import com.quinsic.servicename.usecase.CreateTestUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
@Slf4j
public class ExampleEndpoint {

    private final CreateTestUseCase createTestUseCase;
    private final TestService testService;

    @GetMapping
    public Result<String> test() {
        return R.success("this is ExampleEndpoint");
    }

    @GetMapping("/error")
    public Result<String> error() {
        // if (false); throw
        throw new BizException(SystemResponse.SYS9999);
    }

    @GetMapping("/use-case")
    public Result<String> useCase() {
        return R.success(createTestUseCase.execute());
    }

    @GetMapping("/service")
    public Result<String> service() {
        return R.success(testService.get());
    }

    @PostMapping
    public Result<TestResponseDto> create(@Valid @RequestBody TestRequestDto dto) {
        return R.success(testService.create(dto.getName()));
    }

}
