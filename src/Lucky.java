

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
			System.out.println("*****欢迎进入奖客富翁系统*****");
			System.out.println("         1.注册                              ");
			System.out.println("         2.登陆                              ");
			System.out.println("         3.抽奖                              ");
			System.out.println("************************");
			System.out.print("请选择菜单：");
			int key = 0;
			Scanner input = new Scanner(System.in);
			key = input.nextInt();
			switch (key) {
			case 1:// 注册register
				for (int i = 0; i < cardNo.length; i++) {
					if (name[i] == null) {
						index = i;
					}
				}
				System.out.println("[奖客富翁系统> 注册]");
				System.out.println("请填写个人注册信息：");
				System.out.print("用户名:");
				name[index] = input.next();
				System.out.print("密码：");
				password[index] = input.next();
				System.out.println("用户名\t密码\t卡号");
				cardNo[index] = (int) (Math.random() * 10);
				System.out.println(name[index] + "\t" + password[index] + "\t" + cardNo[index]);
				break;
			case 2:// 登陆landing				
				System.out.println("[奖客富翁系统> 登陆]");
				System.out.print("用户名:");
				name1 = input.next();
				System.out.print("密码：");
				password1 = input.next();
				if (name[index].equals(name1) && password[index].equals(password1)) {
					System.out.println("登陆成功！");
				} else {
					System.out.println("登陆失败！");
					time++;
					if (time==3){
						System.out.println("错误次数超过三次！");
						 break;
					}
				}
				break;
			case 3:// 抽奖lucky
				System.out.println("[奖客富翁系统> 抽奖]");
				int[] cardnos = new int[5];
				System.out.println("您的卡号为：" + cardNo[index]);
				// 生成随机数组
				for (int i = 0; i < cardnos.length; i++) {
					cardnos[i] = (int) (Math.random() * 10);
					for (int k = 0; k < i; k++) {
						if (cardnos[i] == cardnos[k]) {
							cardnos[i] = (int) (Math.random() * 10);
							k = -1;
						}
					}
				}
				// 打印数组
				System.out.println("幸运卡号为：");
				for (j = 0; j < cardnos.length; j++) {
					System.out.print(cardnos[j] + " ");
				}
				// 判断是否中奖
				boolean flag = false;
				for (j = 0; j < cardnos.length; j++) {
					if (cardnos[j] == cardNo[index]) {
						flag = true;
						break;
					}
				}
				
				if (flag) {
					System.out.print("恭喜！");
				} else {
					System.out.print("抱歉！");
				}
				break;
			default:
				System.out.println("输入错误，请重新输入！");
				break;
			}
			System.out.print("继续吗？(y/n)");
			yn = input.next();
			
		} while (yn.equalsIgnoreCase("y"));
		System.out.println("系统退出，谢谢使用！");
	}
}
