

import java.util.Scanner;

import org.omg.CORBA.FloatSeqHelper;

public class Lucky {
	public static void main(String[] args) {
		String yn = null;
		String[] name = new String[3];
		String[] password = new String[3];
		int[] cardNo = new int[3];
		String name1 = null;
		String password1 = null;
		int j = 0;
		int index = 0;
		int time = 0;
		do {
			System.out.println("*****��ӭ���뽱�͸���ϵͳ*****");
			System.out.println("         1.ע��                              ");
			System.out.println("         2.��½                              ");
			System.out.println("         3.�齱                              ");
			System.out.println("************************");
			System.out.print("��ѡ��˵���");
			int key = 0;
			Scanner input = new Scanner(System.in);
			key = input.nextInt();
			switch (key) {
			case 1:// ע��register
				for (int i = 0; i < cardNo.length; i++) {
					if (name[i] == null) {
						index = i;
					}
				}
				System.out.println("[���͸���ϵͳ> ע��]");
				System.out.println("����д����ע����Ϣ��");
				System.out.print("�û���:");
				name[index] = input.next();
				System.out.print("���룺");
				password[index] = input.next();
				System.out.println("�û���\t����\t����");
				cardNo[index] = (int) (Math.random() * 10);
				System.out.println(name[index] + "\t" + password[index] + "\t" + cardNo[index]);
				break;
			case 2:// ��½landing				
				System.out.println("[���͸���ϵͳ> ��½]");
				System.out.print("�û���:");
				name1 = input.next();
				System.out.print("���룺");
				password1 = input.next();
				if (name[index].equals(name1) && password[index].equals(password1)) {
					System.out.println("��½�ɹ���");
				} else {
					System.out.println("��½ʧ�ܣ�");
					time++;
					if (time==3){
						System.out.println("��������������Σ�");
						 break;
					}
				}
				break;
			case 3:// �齱lucky
				System.out.println("[���͸���ϵͳ> �齱]");
				int[] cardnos = new int[5];
				System.out.println("���Ŀ���Ϊ��" + cardNo[index]);
				// �����������
				for (int i = 0; i < cardnos.length; i++) {
					cardnos[i] = (int) (Math.random() * 10);
					for (int k = 0; k < i; k++) {
						if (cardnos[i] == cardnos[k]) {
							cardnos[i] = (int) (Math.random() * 10);
							k = -1;
						}
					}
				}
				// ��ӡ����
				System.out.println("���˿���Ϊ��");
				for (j = 0; j < cardnos.length; j++) {
					System.out.print(cardnos[j] + " ");
				}
				// �ж��Ƿ��н�
				boolean flag = false;
				for (j = 0; j < cardnos.length; j++) {
					if (cardnos[j] == cardNo[index]) {
						flag = true;
						break;
					}
				}
				
				if (flag) {
					System.out.print("��ϲ��");
				} else {
					System.out.print("��Ǹ��");
				}
				break;
			default:
				System.out.println("����������������룡");
				break;
			}
			System.out.print("������(y/n)");
			yn = input.next();
			
		} while (yn.equalsIgnoreCase("y"));
		System.out.println("ϵͳ�˳���ллʹ�ã�");
	}
}
