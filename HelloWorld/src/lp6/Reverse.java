package lp6;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Reverse {
	public static void main(String[] args) throws IOException {
		final int MAX = 100;
		InputStream fis = new FileInputStream("C:\\Users\\wkddu\\eclipse-workspace\\HelloWorld\\src\\lp6\\input.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		int cnt = 0;
		String data;
		String[] lines = new String[MAX];
		while((data = br.readLine()) != null) {
			lines[cnt++] = data;
		}
		br.close(); isr.close(); fis.close();
		
		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\wkddu\\\\eclipse-workspace\\\\HelloWorld\\\\src\\\\lp6\\\\output.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		for(int i = cnt-1; i>=0; --i) {
			bw.write(lines[i]);
			bw.newLine();
			bw.flush();
		}
		bw.close(); osw.close(); fos.close();
	}
}