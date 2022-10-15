import java.io.IOException;
import java.util.ArrayList;

public class dataTestcases {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataTest datatest=new DataTest();
		ArrayList<String> data= datatest.getdata("mngr137319");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));

	}

}
