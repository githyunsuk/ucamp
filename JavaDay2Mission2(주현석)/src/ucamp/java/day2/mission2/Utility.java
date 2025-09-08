package ucamp.java.day2.mission2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utility {
	/**
	 * <pre>
	 * 키보드로 입력한 데이터를 문자열로 반환하는 메서드
	 * </pre>
	 * @return 입력한 문자열
	 */
	public static String inputString() {
		String inputData = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputData = in.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return inputData;
	}
	
	
	/**
	 * 키보드로 입력한 숫자 데이터를 int 반환하는 메서드
	 * @return 숫자로 변환된 사용자 입력값
	 */
	public static int inputNumber() {
		String inputData = null;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputData = in.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return Integer.parseInt(inputData);
	}
}
