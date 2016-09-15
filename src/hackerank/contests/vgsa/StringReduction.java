package hackerank.contests.vgsa;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class StringReduction {
	private boolean isSame(String str){
		for(int i = str.length() - 1; i > 0; i--){
			if(str.charAt(i) != str.charAt(i-1)) return false;
		}
		return true;
	}
	
	private int solve(String ln){
		if(isSame(ln)) return ln.length();
		int[] count = new int[3];
		for(int i = ln.length() - 1; i >= 0; i--){
			char c = ln.charAt(i);
			count[c - 'a']++;
		}
		
		if(ln.length() % 2 == 0){
			// even
			for(int i = 0; i < 3; i++){
				if(count[i] % 2 != 0) return 1;
			}
			return 2;
		} else {
			// odd
			for(int i = 0; i < 3; i++){
				if(count[i] % 2 == 0) return 1;
			}
			return 2;
		}
		

	}
	
	private void run(Reader r) throws Exception {
		//BufferedReader rd = new BufferedReader(r);
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		for(; T > 0; T--){
			String ln = s.next();
			//pw.printf("%s: %d", ln, solve(ln));
			System.out.println(solve(ln));
		}
		
		s.close();
	}

	public static void main(String[] args) throws Exception {
		Reader rd = args.length == 0 ? new InputStreamReader(System.in) : new FileReader(args[0]);
		new StringReduction().run(rd);
	}
}
