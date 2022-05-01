package codes;

import java.util.Random;
import java.util.Scanner;

public class MainDrive {
	
	
	/**야구게임의 길이를 4자리 숫자 야구로 변경*/
	static final int len = 4;
	/**해답을 공개할 지 여부를 결정한다.*/
	static final boolean showsCorrectAnswers = false;
	public static void main(String[] args) {
		int[] cpuNumbers = new int[len];
		for (int i = 0; i < cpuNumbers.length; i++) {
			while (true) {
				Random myRandom = new Random();
				int randomNum = myRandom.nextInt(9) + 1;
				// 1 ~ 10 직전 (9)
				boolean isDuplOk = true;
				for (int j=0; j<cpuNumbers.length; j++) {
					int num = cpuNumbers[j];
					if (num == randomNum) {
						isDuplOk = false;
						break;
					}
				}
				if (isDuplOk) {
					cpuNumbers[i] = randomNum;
					break;
				}
			}
		}
		// 문제 확인용 for 문		
		if (showsCorrectAnswers) {
			for (int j=0; j<cpuNumbers.length; j++) {
				int num = cpuNumbers[j];
				System.out.print(num);
			}
			System.out.println();
		}
		// 사용자가 정답을 맞출때 까지 입력받자
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("답안입력 : ");
			int inputNum = sc.nextInt();
			int[] myNumbers = new int[len];
			for (int i=0; i<myNumbers.length; i++) {
				myNumbers[i] = inputNum / (int)Math.pow(10, len-1-i);
				inputNum = inputNum % (int)Math.pow(10, len-1-i);
			}
			
			int strikeCount = 0;
			int ballCount = 0;
			for (int i = 0; i < myNumbers.length; i++) {
				for (int j = 0; j < cpuNumbers.length; j++) {
					if (myNumbers[i] == cpuNumbers[j]) {
						if (i == j) {
							strikeCount++;
						}
						else {
							ballCount++;
						}
					}
				}
			}
			System.out.println(strikeCount + "Strike, " + ballCount + "Ball입니다.");
			// 라면, 게임 종료
			if(strikeCount == len) {
				System.out.println("축하합니다!!");
				System.out.println("게임을 종료합니다.!");
				break;
			}
		}
	}
}

