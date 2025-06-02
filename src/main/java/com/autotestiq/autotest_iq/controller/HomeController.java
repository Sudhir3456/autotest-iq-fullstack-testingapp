package com.autotestiq.autotest_iq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.autotestiq.autotest_iq.model.TestCase;
import com.autotestiq.autotest_iq.service.SeleniumExecutorService;
import com.autotestiq.autotest_iq.service.TestCaseService;

@Controller
public class HomeController {

	@Autowired
	private TestCaseService testCaseService;

	@Autowired
	private SeleniumExecutorService seleniumExecutorService;

	
	

	@GetMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("testCases", testCaseService.getAllTestCases());
		return "home";
	}

	@GetMapping("/add-testcase")
	public String showAddForm(Model model) {
		model.addAttribute("testCase", new TestCase());
		return "add-testcase";
	}

	@PostMapping("/save-testcase")
	public String saveTestCase(@ModelAttribute("testCase") TestCase testCase, Model model) {
		// Save logic here (e.g., testCaseRepository.save(testCase))
		testCaseService.createTestCase(testCase);
		model.addAttribute("success", true);
		model.addAttribute("testCase", new TestCase()); // Reset form
		return "add-testcase"; // Return to form with success message
	}

 	@GetMapping("/edit-testcase/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		TestCase testCase = testCaseService.getTestCaseById(id);
		model.addAttribute("testCase", testCase);
		return "edit-testcase";
	}

	@PostMapping("/update-testcase/{id}")
	public String updateTestCase(@PathVariable Long id, @ModelAttribute TestCase testCase) {
		testCase.setId(id); // Ensure the ID is preserved
		testCaseService.createTestCase(testCase); // Save updates
		return "redirect:/home";
	}
	
	@GetMapping("/delete-testcase/{id}")
	public String deleteTestCase(@PathVariable Long id, Model model) {
		
		testCaseService.deleteTestCase(id);  
		model.addAttribute("testCases", testCaseService.getAllTestCases());
		return "home";
	}

	
	@PostMapping("/run-test")
 	public String runTest(@RequestParam("testCaseId") Long testCaseId) {
	   
		try {
			seleniumExecutorService.executeTest(testCaseId);
		} catch (Exception e) {
              e.printStackTrace();
		}
  	    
	    System.out.println("Run Seccess..");
	    return "testcaseresult";
	}
	
	
	@GetMapping("aboutPage")
	public String aboutPage() {
		
		return "about";
		
	}
	
	
	

}