import java.io.*;

public class N11719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = "";
		while (br.ready()) {
			data += (char) br.read();
		}
		System.out.print(data);
	}
}
