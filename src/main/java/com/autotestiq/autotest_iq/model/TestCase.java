package com.autotestiq.autotest_iq.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TestCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private TestCaseStatus status;

	// Add getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Update getter/setter to use TestCaseStatus
	public TestCaseStatus getStatus() {
		return status;
	}

	public void setStatus(TestCaseStatus status) 
	{ 
		this.status= status;
		
	}
}