package com.quinsic.servicename.usecase;

import com.quinsic.servicename.service.RunService;
import com.quinsic.servicename.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * This is optional class for in-case you're going to implement logic
 * which is cross multiple services layers
 */
@Component
@AllArgsConstructor
public class CreateTestUseCase {
    private final TestService testService;
    private final RunService runService;

    public String execute() {
        return testService.get() + runService.get();
    }
}
