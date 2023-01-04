class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>();
        for(String a:wordList) words.add(a);
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int ans = 1;
        boolean found = false;
        while(!queue.isEmpty() && !found){
            int size = queue.size();
            ans++;
            while(size-->0){
                String word = queue.poll();
                for(int i=0;i<word.length();i++){
                    for(int j=0;j<alphabets.length();j++){
                        String newword = word.substring(0, i) + alphabets.charAt(j) + word.substring(i + 1);
                        if(words.contains(newword) && endWord.equals(newword)){
                            found = true;
                            break;
                        }
                        if(words.contains(newword) && !visited.contains(newword)){
                            visited.add(newword);
                            queue.add(newword);
                        }
                    }
                }
            }
            System.out.println(queue);
        }
        if(found) return ans;
        return 0;
    }
}
