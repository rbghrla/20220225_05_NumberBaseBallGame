package codes;

import java.util.Random;
import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

//		��ǻ�Ͱ� ���� ����
//		int �� ĭ¥�� �迭

		int[] cpuNumbers = new int[3];

		for (int i = 0; i < cpuNumbers.length; i++) {
			while (true) {
				Random myRandom = new Random();
				int randomNum = myRandom.nextInt(9) + 1; // 1 ~ 10 ���� (9)

				boolean isDuplOk = true;

				for (int num : cpuNumbers) {
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

//		���� Ȯ�ο� for ��
		for (int num : cpuNumbers) {
			System.out.print(num);
		}

//		����ڰ� ������ ���⶧ ���� �Է¹���
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("����Է� : ");
			int inputNum = sc.nextInt();

//			321 => {3, 2, 1} ó�� ��ĭ �迭�� �и� / ���� S, B ����.

			int[] myNumbers = new int[3];

			myNumbers[0] = inputNum / 100;
			myNumbers[1] = (inputNum / 10) % 10;
			myNumbers[2] = inputNum % 10;

			int strikeCount = 0;
			int ballCount = 0;

			for (int i = 0; i < myNumbers.length; i++) {

				for (int j = 0; j < cpuNumbers.length; j++) {
					if (myNumbers[i] == cpuNumbers[j]) {
						if (i == j) {
							strikeCount++;
						}else {
							ballCount++;
						}
					}
				}
			}
			System.out.println(strikeCount + "S, " + ballCount + "B�Դϴ�.");
			
//			���, ���� ����
			if(strikeCount == 3) {
				System.out.println("�����մϴ�!!");
				
				System.out.println("������ �����մϴ�.!");
				break;
			}

		}
	}
}
