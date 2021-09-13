import java.io.*;

public class N1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}
		String temp;
		for (int i = 0; i < n; i++) {
			if (words[i] != "") {
				for (int j = i + 1; j < n; j++) {
					if (words[i].equals(words[j])) {
						words[j] = "";
					} else if (words[j] != "") {
						if (words[i].length() == words[j].length()) {
							for (int k = 0; k < words[i].length(); k++) {
								if (words[i].charAt(k) > words[j].charAt(k)) {
									temp = words[i];
									words[i] = words[j];
									words[j] = temp;
									break;
								} else if (words[i].charAt(k) < words[j].charAt(k)) {
									break;
								}
							}
						} else if (words[i].length() > words[j].length()) {
							temp = words[i];
							words[i] = words[j];
							words[j] = temp;
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (words[i] != "") {
				bw.write(words[i]);
				bw.newLine();
			}
		}
		bw.flush();
	}
}
