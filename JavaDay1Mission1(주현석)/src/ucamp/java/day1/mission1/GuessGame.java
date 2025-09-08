package ucamp.java.day1.mission1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessGame {
	private static final String INPUT_MESSAGE = "1부터 100사이의 값을 입력하세요 : ";
	private static final int INVALID_NUMBER = 999999;

	static int tryCount = 0; // 게임 시도 횟수

	public static void main(String[] args) {
		// 사용자가 게임을 시작할지 여부를 Y/N 으로 입력하여 Y인 경우 게임을 시작하고, N인 경우 프로그램을 종료한다.
		while (true) {
			System.out.print("게임을 시작합니다(Y/N) :");
			if (inputString().equals("N")) {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			} else {
				getGame();
			}
		}
	}

	public static void getGame() {
		int randomNum = getRandomNumber();
		// 사용자가 난수를 맞출 때까지 반복하는 코드를 반복문(do~while 권장)으로 작성한다.
		int num;
		int cnt = 1;
		int diff;

		while (true) {
			num = getValidNumber(cnt);
			diff = num - randomNum;
			if (num == randomNum) {
				System.out.println("축하합니다! " + cnt + "번째 맞추셨습니다.");
				System.out.println();
				break;
			} else if (diff >= 10) {
				System.out.println("입력하신 값은 너무 큽니다.");
			} else if (diff >= 5) {
				System.out.println("입력하신 값은 약간 큽니다.");
			} else if (diff >= 1) {
				System.out.println("입력하신 값은 아주 약간 큽니다.");
			} else if (diff <= -10) {
				System.out.println("입력하신 값은 너무 작습니다.");
			} else if (diff <= -5) {
				System.out.println("입력하신 값은 약간 작습니다.");
			} else if (diff <= -1) {
				System.out.println("입력하신 값은 아주 약간 작습니다.");
			}
			cnt++;
		}
	}

	public static int getValidNumber(int cnt) {
		int inputNum = 0;

		// "[n번째 시도] 1부터 100사이의 값을 입력하세요 : " 메시지(n은 시도 횟수)를 화면에 출력하고,
		// 사용자로부터 숫자를 입력 받아 그 수를 리턴한다.
		// 만약 사용자가 입력한 값이 숫자가 아니거나 1부터 100사이의 값이 아닌 경우,
		// 올바른 숫자를 입력할 때까지 메시지를 출력하고 숫자를 입력 작업을 반복한다.
		while (true) {
			System.out.print("[" + cnt + "번째 시도] " + INPUT_MESSAGE);
			inputNum = inputNumber();
			if (inputNum >= 1 && inputNum <= 100)
				break;
		}

		return inputNum;

	}

	public static int inputNumber() {
		int inputData = 0;

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputData = Integer.parseInt(in.readLine());

			return inputData;
		} catch (Exception e) {
			return INVALID_NUMBER;

		}
	}

	public static String inputString() {
		String inputString = null;

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputString = in.readLine();
			if (inputString.equals("Y") || inputString.equals("N"))
				return inputString;
			throw new Exception();
		} catch (Exception e) {
			return "N";
		}
	}

	private static int getRandomNumber() {
		return new Random().nextInt(100) + 1;
	}
}
