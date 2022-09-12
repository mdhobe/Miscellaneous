class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

		String[] str = s.split(" ");

		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i].length() == 0)continue;
			ans.append(str[i]);
			ans.append(" ");
		}
        ans.setLength(ans.length() - 1);
		return ans.toString();
    }
}
