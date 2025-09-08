package ucamp.java.day2.mission2;

public class StudentSort {
	private static Student[] studentArr;

	public static void main(String[] args) {
		createStudentInfoFromInput();

		printStudentInfo("[입력된 학생정보]");

		SortStudentInfoByAgeDesc();
		printStudentInfo("[나이 내림차순 정렬결과]");

		SortStudentInfoByName();
		printStudentInfo("[이름 오름차순 정렬결과]");

		while (SearchStudentByNo())
			;

		System.out.println("\n#프로그램을 종료합니다.");

	}

	private static void createStudentInfoFromInput() {
		int numOfStudent; // 등록된 학생 수

		System.out.print(">> 등록할 학생 수를 입력하세요: ");
		numOfStudent = Utility.inputNumber();

		// studentArr = XXX; //학생 객체를 저장할 배열을 생성
		studentArr = new Student[numOfStudent];

		// 제공되는 메서드를 활용하여 키보드 입력 값으로 나머지 필드들(이름, 나이, 전화번호)을 초기화
		for (int i = 0; i < numOfStudent; i++) {
			studentArr[i] = new Student();
			System.out.println("[" + (i + 1) + "번째 학생정보 입력]");

			System.out.print("학번 :");
			studentArr[i].setStudentNo(Utility.inputString());
			System.out.print("이름 :");
			studentArr[i].setName(Utility.inputString());
			System.out.print("나이 :");
			studentArr[i].setAge(Utility.inputNumber());
			System.out.print("전화번호 :");
			studentArr[i].setPhoneNo(Utility.inputString());
			System.out.println();
		}

	}

	private static void printStudentInfo(String title) {
		System.out.println(title);
		System.out.println("--------------------------------------------");
		System.out.println("학번\t이름\t나이\t전화번호");
		System.out.println("--------------------------------------------");

		for (Student student : studentArr) {
			System.out.print(student.getStudentNo() + "\t");
			System.out.print(student.getName() + "\t");
			System.out.print(student.getAge() + "\t");
			System.out.println(student.getPhoneNo());
		}

		System.out.println("--------------------------------------------");
		System.out.println();
	}

	private static void SortStudentInfoByName() {
		// 학생 이름을 기준으로 배열에 저장된 학생 객체를 오름차순으로 정렬
		// 이름 비교시 문자열의 compareTo() 메서드 활용
		for (int i = 0; i < studentArr.length - 1; i++) {
			for (int j = i + 1; j < studentArr.length; j++) {
				String nameI = studentArr[i].getName();
				String nameJ = studentArr[j].getName();
				int diff = nameI.compareTo(nameJ);

				if (diff > 0) {
					Student temp = studentArr[i];
					studentArr[i] = studentArr[j];
					studentArr[j] = temp;
				}
			}
		}
	}

	private static void SortStudentInfoByAgeDesc() {
		// 나이를 기준으로 배열에 저장된 학생 객체를 내림차순으로 정렬
		for (int i = 0; i < studentArr.length - 1; i++) {
			for (int j = i + 1; j < studentArr.length; j++) {
				int ageI = studentArr[i].getAge();
				int ageJ = studentArr[j].getAge();

				if (ageI - ageJ < 0) {
					Student temp = studentArr[i];
					studentArr[i] = studentArr[j];
					studentArr[j] = temp;
				}
			}
		}
	}

	private static boolean SearchStudentByNo() {
		System.out.print(">> 검색할 학생의 학번을 입력하세요(프로그램 종료: q): ");
		String studentNo = Utility.inputString();
		boolean flag = false;
		Student targetStudent = null;

		if (studentNo.equals("q"))
			return false;

		// 배열을 탐색하여 학번에 해당하는 학생정보가 존재하는 경우(equals() 메서드로 문자열 비교)
		for (Student student : studentArr) {
			if (studentNo.equals(student.getStudentNo())) {
				flag = true;
				targetStudent = student;
			}
		}
		// 학생정보(이름, 나이, 전화번호)를 출력하고 true를 반환
		// 입력한 학번에 해당하는 학생정보가 존재하지 않는 경우, 메세지 출력 후 true 반환
		if (flag) {
			System.out.println("--------------------------------------------");
			System.out.println("이름: " + targetStudent.getName());
			System.out.println("나이: " + targetStudent.getAge());
			System.out.println("전화번호: " + targetStudent.getPhoneNo());
			System.out.println("--------------------------------------------");
		} else {
			System.out.println("#학번이 " + studentNo + "인 학생은 존재하지 않습니다!");
		}

		return true;
	}
}
