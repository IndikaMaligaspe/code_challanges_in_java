package coding_challanges.dynamic_programming.memo;

import java.util.HashMap;
import java.util.Map;

public class CanConstructWord {
	
	public static boolean canConstructWord(String str, String[] words) {
		
		Map<String, Boolean> memo = new HashMap<>();
		return canConstructWordHelper(str, words, memo);
	}
	
	private static boolean canConstructWordHelper(String str, String[] words , Map<String, Boolean> memo ) {
		if(str.length() == 0) return true;
		if(memo.containsKey(str)) return memo.get(str);
		
		for (String word: words) {
			int startPos = str.indexOf(word,0);
			if( startPos == 0) {
				
				String suffix = str.substring(word.length());
			
				if(canConstructWordHelper(suffix, words, memo)) {
					memo.put(str, true);
					return true;
				}
			}
		}
		memo.put(str, false);
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(CanConstructWord.canConstructWord("abcdef", new String[] {"ab","abc","cd", "def", "abcd"}));
		System.out.println(CanConstructWord.canConstructWord("skateboard", new String[] {"bo","rd","ate", "t", "ska", "sk","boar"}));
		System.out.println(CanConstructWord.canConstructWord("enterapotentpot", new String[] {"a","p","ent", "enter", "ot", "o", "t"}));
	}
}
