package com.autotestiq.autotest_iq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autotestiq.autotest_iq.model.TestCase;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    // Basic CRUD operations are inherited automatically
    // No need to implement anything yet
}