package lc.leetcode.editor.en;
//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be in any order you want. 
// Related Topics String Backtracking



import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_17 {

    public HashMap<Character, List<String>> getMap() {
        HashMap<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        return map;
    }

    public List<String> letterCombinations(String digits) {

        if (Objects.equals(digits, "")) {
            return new ArrayList<>();
        }

        HashMap<Character, List<String>> map = getMap();
        List<String> list = new ArrayList();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            char s = digits.charAt(i);
            List<String> mapList = map.get(s);
            ArrayList<String> newList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < mapList.size(); k++) {
                    String strs = new StringBuffer(list.get(j)).append(mapList.get(k)).toString();
                    newList.add(strs);
                }
            }
            list = newList;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
