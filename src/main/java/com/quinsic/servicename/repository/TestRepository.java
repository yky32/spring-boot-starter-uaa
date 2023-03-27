package com.quinsic.servicename.repository;

import com.quinsic.servicename.entity.po.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepositoryImplementation<User, Long> {
}