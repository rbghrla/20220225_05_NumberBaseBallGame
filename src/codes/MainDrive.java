package codes;

import java.util.Random;
import java.util.Scanner;

public class MainDrive {
	
	
	/**�߱������� ���̸� 4�ڸ� ���� �߱��� ����*/
	static final int len = 4;
	/**�ش��� ������ �� ���θ� �����Ѵ�.*/
	static final boolean showsCorrectAnswers = false;
	public static void main(String[] args) {
		int[] cpuNumbers = new int[len];
		for (int i = 0; i < cpuNumbers.length; i++) {
			while (true) {
				Random myRandom = new Random();
				int randomNum = myRandom.nextInt(9) + 1;
				// 1 ~ 10 ���� (9)
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
		// ���� Ȯ�ο� for ��		
		if (showsCorrectAnswers) {
			for (int j=0; j<cpuNumbers.length; j++) {
				int num = cpuNumbers[j];
				System.out.print(num);
			}
			System.out.println();
		}
		// ����ڰ� ������ ���⶧ ���� �Է¹���
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("����Է� : ");
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
			System.out.println(strikeCount + "Strike, " + ballCount + "Ball�Դϴ�.");
			// ���, ���� ����
			if(strikeCount == len) {
				System.out.println("�����մϴ�!!");
				System.out.println("������ �����մϴ�.!");
				break;
			}
		}
	}
}

