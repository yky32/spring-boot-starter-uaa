package com.quinsic.servicename.service;

import com.quinsic.servicename.entity.dto.TestResponseDto;
import com.quinsic.servicename.entity.po.User;
import com.quinsic.servicename.repository.TestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public String get() {
        return "this is A's service layer";
    }

    public TestResponseDto create(String name) {
        User user = User.builder()
                .name(name)
                .build();
        user = testRepository.save(user);
        return TestResponseDto.builder()
                .anotherValue(user.getName())
                .build();
    }
}
