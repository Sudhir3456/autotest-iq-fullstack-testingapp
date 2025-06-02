package com.autotestiq.autotest_iq.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TestStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long testCaseId; // Foreign key

    private String url; // optional, needed in first step
    private String locatorType; // id, name, xpath, css
    private String locatorValue; // actual value
    private String action; // click, sendKeys, getText
    private String inputData; // value to enter if sendKeys
    private int stepOrder; // order of execution
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(Long testCaseId) {
		this.testCaseId = testCaseId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLocatorType() {
		return locatorType;
	}
	public void setLocatorType(String locatorType) {
		this.locatorType = locatorType;
	}
	public String getLocatorValue() {
		return locatorValue;
	}
	public void setLocatorValue(String locatorValue) {
		this.locatorValue = locatorValue;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getInputData() {
		return inputData;
	}
	public void setInputData(String inputData) {
		this.inputData = inputData;
	}
	public int getStepOrder() {
		return stepOrder;
	}
	public void setStepOrder(int stepOrder) {
		this.stepOrder = stepOrder;
	}
	
	
	@Override
	public String toString() {
		return "TestStep [id=" + id + ", testCaseId=" + testCaseId + ", url=" + url + ", locatorType=" + locatorType
				+ ", locatorValue=" + locatorValue + ", action=" + action + ", inputData=" + inputData + ", stepOrder="
				+ stepOrder + "]";
	}

     
    
    
    
}