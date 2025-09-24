package com.ucamp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucamp.entity.EmployeeDTO;
import com.ucamp.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {


	private final EmployeeService employeeService;

	
	@RequestMapping("/manager")
	public String getManager() {
		return "manager";
	}
	
	@RequestMapping("/list")
	public String getList(Model model) {
		List<EmployeeDTO> list = employeeService.searchAllEmployee();
		
		model.addAttribute("list", list);
		return "employeeList";
	}
	
	@RequestMapping("/insert")
	public String getInsert() {
		return "insert";
	}
	
	@RequestMapping("/insertProc")
	public String getInsertProc(@ModelAttribute EmployeeDTO employee) {
		
		employeeService.addEmployee(employee);
		
		return "manager";
	}
	
	@RequestMapping("/update/{id}")
	public String getUpdate(@PathVariable("id") String id, Model model) {
		
		EmployeeDTO employee = employeeService.searchEmployee(id);
		
		model.addAttribute("employee", employee);
		return "updateForm";
	}
	
	@PostMapping("/updateProc")
	public String getUpdateProc(@ModelAttribute EmployeeDTO employee) {
		employeeService.modifyEmployee(employee);
		
		return "manager";
	}
	
	@RequestMapping("/delete/{id}")
	public String getDelete(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("id", id);
		return "deleteForm";
	}
	
	@PostMapping("/deleteProc")
	public String getDeleteProc(@RequestParam("id") String id) {
		
		employeeService.removeEmployee(id);
		
		return "manager";
	}
	
}
