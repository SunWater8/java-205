import java.util.Scanner;

public class AdminMain {
	public static void main(String[] args) {
		
		AdminManager adManager = new AdminManager(AdminDao.getInstance());
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine().trim());
		if(num==3) {
			adManager.chkLogin();
		}
	}
}
