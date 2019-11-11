package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestClass {
	
	public static String makeMid(){
		List<String> fid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> did = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> tid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> qid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		List<String> pid = Arrays.asList("a","b","c","d","e","f","g","h","i",
										 "j","k","l","m","n","o","p","q","r",
										 "s","t","u","v","w","x","y","z","0",
										 "1","2","3","4","5","6","7","8","9");
		Collections.shuffle(fid);
		Collections.shuffle(did);
		Collections.shuffle(tid);
		Collections.shuffle(qid);
		Collections.shuffle(pid);
		String fullMid = fid.get(0) + did.get(1) + tid.get(2) + qid.get(3) + pid.get(4);
		return fullMid;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
		      if (i % 5 == 0) {
		        System.out.println();
		        if (makeMid() != makeMid()) {
		        	System.out.print(makeMid() + ", ");
		        }
		      }
		      
		    }
	}

}
