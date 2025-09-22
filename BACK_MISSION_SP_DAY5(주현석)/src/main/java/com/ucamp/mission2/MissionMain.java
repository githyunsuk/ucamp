package com.ucamp.mission2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MissionMain {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeService service = context.getBean(EmployeeService.class);
		// 1. EMPLOYEE 테이블의 데이터를 조회한다.
		// 2. EMPLOYEE 테이블의 데이터를 입력한다.
		// 3. EMPLOYEE 테이블의 데이터를 갱신한다.
		// 4. EMPLOYEE 테이블의 데이터를 삭제한다.

		// 프로그램을 시작합니다.
		// 원하는 작업을 선택해 주세요.(0: 전체 조회, 1: 조회, 2: 입력, 3: 수정, 4: 삭제)
		// 1, 3, 4 의 작업은 아이디 기반으로 진행하며
		// 모든 작업(입력, 수정)은 EMPLOYEE 테이블의 모든 컬럼을 대상으로 한다.
		// 0, 1, 2, 3, 4 작업시 발생하는 모든 예외 처리는 main에서 처리한다.
		// 예외가 발생해도 프로그램이 종료되지 않아야 한다.
		// 메뉴 선택 옵션을 작성하여 프로그램이 종료되도록 해야한다.
		// 예외가 발생하는 경우 예외 메시지를 한줄 출력하도록 한다.(ex: ERROR: xxx 예외 발생)

		System.out.println("프로그램을 시작합니다.");
		while (true) {
			System.out.print("원하는 작업을 선택해 주세요.(0: 전체 조회, 1: 조회, 2: 입력, 3: 수정, 4: 삭제): ");
			int num = Integer.parseInt(br.readLine());

			try {
				if (num == 0) { //전체 조회
					List<Employee> list = service.getAllEmployees();
					for (Employee employee : list)
						System.out.println(employee);
					System.out.println("조회 완료");
					continue;
				} else if (num == 2) { //입력
					System.out.print("ID, 이름, 비밀번호, 부서를 입력해주세요: ");
					st = new StringTokenizer(br.readLine());
					service.insertEmployee(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
					System.out.println("입력 완료");
					continue;
				}

				Employee employee = null;
				System.out.print("ID를 입력해주세요: ");
				String id = br.readLine();

				if (num == 1) { //입력
					employee = service.findEmployeeById(id);
					System.out.println(employee);
					System.out.println("조회 완료");
				} else if (num == 3) { //수정
					System.out.println("수정한 이름, 비밀번호, 부서를 입력해주세요: ");
					st = new StringTokenizer(br.readLine());
					employee = new Employee(id, st.nextToken(), st.nextToken(), st.nextToken());
					service.updateEmployee(employee);
					System.out.println("수정 완료");
				} else if (num == 4) { //삭제
					employee = service.findEmployeeById(id);
					service.deleteEmployee(employee);
					System.out.println("삭제 완료");
				} else { //잘못된 입력
					System.out.println("잘못된 입력입니다.");
				}

			} catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage() + " 예외 발생");

			} finally {
				System.out.print("종료하시겠습니까?(0: 예, 1: 아니요): ");
				if (Integer.parseInt(br.readLine()) == 0)
					break;
			}
		}

		System.out.println("종료되었습니다.");

	}

}
