class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // get the hashmap with counts
        HashMap<String, Integer> myhash = new HashMap<>();
        Set<String> words = new HashSet<>();
        for(String w : wordList) words.add(w);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        if(words.contains(beginWord)) words.remove(beginWord);
        int count = 0;
        myhash.put(beginWord,count);
        boolean found = false;
        while(!queue.isEmpty() && !found){
            int size = queue.size();
            count++;
            while(size-->0){
                String word = queue.poll();
                for(int i=0;i<word.length();i++){
                    char[] newWordArray = word.toCharArray();
                    for(char c='a';c<='z';c++){
                        newWordArray[i] = c;
                        String newWord = new String(newWordArray);
                        if(words.contains(newWord) && endWord.equals(newWord)){
                            found = true;
                            myhash.put(newWord,count);
                            break;
                        }
                        if(words.contains(newWord)){
                            queue.add(newWord);
                            myhash.put(newWord,count);
                            words.remove(newWord);
                        }
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(found);
        System.out.println(myhash);

        List<List<String>> ans = new ArrayList<>();
        if(!found) return ans;

        //find paths
        List<String> track = new ArrayList<>();
        track.add(endWord);
        paths(endWord, beginWord, ans, track, myhash);
        System.out.println(ans);

        return ans;
    }

    public void paths(String current, String start,List<List<String>> ans, List<String> track, HashMap<String, Integer> myhash){
        if(current.equals(start)){
            ArrayList<String> tracknew = new ArrayList<String>(track);
            Collections.reverse(tracknew);
            ans.add(tracknew);
            return;
        }
        for(int i=0;i<current.length();i++){
            char[] newWordCharacter = current.toCharArray();
            for(char c='a';c<='z';c++){
                newWordCharacter[i] = c;
                String newWord = new String(newWordCharacter);
                if(myhash.containsKey(newWord) && myhash.get(newWord) == myhash.get(current)-1){
                    track.add(newWord);
                    paths(newWord, start, ans, track, myhash);
                    track.remove(track.size()-1);
                }
            }
        }
    }
}
