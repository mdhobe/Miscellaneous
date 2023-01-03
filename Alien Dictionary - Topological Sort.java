class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, ArrayList<Character>> adj = new HashMap<>();
        for(int i=0;i<K;i++) adj.put(alpha.charAt(i), new ArrayList<Character>());
        
        //graph formation
        for(int i=0;i<N-1;i++){
            String a = dict[i];
            String b = dict[i+1];
            int n = Math.min(a.length(), b.length());
            for(int j=0;j<n;j++){
                if(a.charAt(j) != b.charAt(j)){
                    adj.get(a.charAt(j)).add(b.charAt(j));
                    break;
                }
            }
        }
        
        //indegree
        int[] indegree = new int[K];
        for(int i=0;i<K;i++){
            for(Character a : adj.get(alpha.charAt(i))){
                indegree[alpha.indexOf(a)]++;
            }
        }
        
        //0 indegree in queue
        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<K;i++) if(indegree[i]==0) queue.add(alpha.charAt(i));
        
        //topology sort
        StringBuilder str = new StringBuilder();
        while(!queue.isEmpty()){
            Character c = queue.poll();
            str.append(c);
            for(Character k : adj.get(c)){
                indegree[alpha.indexOf(k)]--;
                if(indegree[alpha.indexOf(k)] == 0) queue.add(k);
            }
        }
        
        return str.toString();
    }
}
