package com.autotestiq.autotest_iq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autotestiq.autotest_iq.model.TestStep;

public interface TestStepRepository extends JpaRepository<TestStep, Long> {
    
	List<TestStep> findByTestCaseIdOrderByStepOrderAsc(Long testCaseId);
}