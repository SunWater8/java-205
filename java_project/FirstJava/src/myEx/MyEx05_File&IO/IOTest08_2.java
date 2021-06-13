

package test;
import java.io.*;

public class IOTest08_2 {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("printWrite.txt"));
			
			String str = null;
			while(true) {
				str = in.readLine();
				if(str==null) {
					break;
				}
				System.out.println(str);
						
			}
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
