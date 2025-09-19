package com.ucamp.mission.day4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeJdbcMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);//구현
		
		EmployeeService service = context.getBean(EmployeeService.class);// 구현
		
		Employee emp = service.insertEmployee("D7", "김동수", "1234", "개발");//DB 스키마에 맞게 value 전달
		System.out.println(emp);// D1 - 김동수 - 개발
		
		emp.setDname("영업");
		emp = service.updateEmployee(emp);
		System.out.println(emp);// D1 - 김동수 - 영업
		
		emp = service.findEmployeeById(emp.getId());
		System.out.println(emp);// D1 - 김동수 - 영업
		
		emp = service.deleteEmployee(emp); // D1 - 김동수 -영업
		System.out.println("삭제됨: "+emp);// D1 - 김동수 - 영업
		
		List<Employee> empList = service.getAllEmployees();
		for(Employee temp: empList) {
			System.out.println(temp); // 각 사원의 정보를 출력, 삭제된 D1이 포함되면 안됨.
		}
		
		System.out.println("종료");
	}
}
