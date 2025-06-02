package com.autotestiq.autotest_iq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotestiq.autotest_iq.model.TestCase;
import com.autotestiq.autotest_iq.repository.TestCaseRepository;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    public TestCase createTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    public List<TestCase> getAllTestCases() {
        return testCaseRepository.findAll();
    }

    public TestCase getTestCaseById(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }
    
 // In TestCaseService.java
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }
    
}