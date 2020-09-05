package com.jrp.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Project;

@Controller
public class HomeController {
	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHomePage(Model model) throws JsonProcessingException {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectList", projects);
		
		/*
		 * List<Employee> employees = empRepo.findAll();
		 * model.addAttribute("employeeList", employees);
		 */
		//For ChartData
		List<ChartData> projectData = proRepo.getProjectStatus();
		//convert java object into json string via ObectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectStatusCnt", jsonString);
		
		
		
		
		List<EmployeeProject> employeeProjects = empRepo.employeeProjects();
		model.addAttribute("employeeprojects", employeeProjects);
		return "main/home";
		
		
	}

}
