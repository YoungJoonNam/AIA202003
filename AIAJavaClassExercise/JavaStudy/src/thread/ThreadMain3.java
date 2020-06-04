package thread;

import javax.swing.JOptionPane;

public class ThreadMain3 {

	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog("사용자 이름을 입력해주세요");
		
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}

		System.out.println(input);

	}

}
