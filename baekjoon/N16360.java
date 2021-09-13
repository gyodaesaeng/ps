import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N16360 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			bw.write(solve(word) + "\n");
		}
		bw.flush();
	}

	static String solve(String word) {
		switch (word.charAt(word.length() - 1)) {
		case 'a':
		case 'o':
		case 'u':
			word += 's';
			break;
		case 'y':
			word = word.substring(0, word.length() - 1) + 'i';
		case 'i':
			word += "os";
			break;
		case 'l':
		case 'r':
		case 'v':
			word += "es";
			break;
		case 'n':
			word = word.substring(0, word.length() - 1) + "anes";
			break;
		case 'e':
			if (word.charAt(word.length() - 2) == 'n') {
				word = word.substring(0, word.length() - 2) + "anes";
			} else {
				word += "us";
			}
			break;
		case 't':
		case 'w':
			word += "as";
			break;
		default:
			word += "us";
			break;
		}
		return word;
	}
}
