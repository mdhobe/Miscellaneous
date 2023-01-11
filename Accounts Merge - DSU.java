public class DisjointSet {
	List<Integer> rank, parent, size;

	public DisjointSet(int n){
		rank = new ArrayList<>();
		parent = new ArrayList<>();
		size = new ArrayList<>();
		for(int i=0;i<=n;i++){
			rank.add(0);
			parent.add(i);
			size.add(1);
		}
	}

	public int findUltimateParent(int node){
		if(node == parent.get(node)) return node;
		int pnode = findUltimateParent(parent.get(node));
		parent.set(node, pnode);
		return parent.get(node);
	}

	public void unionByRank(int u, int v){
		int pu = findUltimateParent(u);
		int pv = findUltimateParent(v);
		if(pu == pv) return;

		if(rank.get(pu) < rank.get(pv)){
			parent.set(pu, pv);
		} else if(rank.get(pu) > rank.get(pv)){
			parent.set(pv, pu);
		} else {
			parent.set(pu, pv);
			int r = rank.get(pv);
			rank.set(pv, r+1);
		}
	}

	public void unionBySize(int u, int v){
		int pu = findUltimateParent(u);
		int pv = findUltimateParent(v);
		if(pu == pv) return;

		if(size.get(pu) < size.get(pv)){
			parent.set(pu, pv);
			size.set(pv, size.get(pu)+size.get(pu));
		} else {
			parent.set(pv, pu);
			size.set(pu, size.get(pu)+size.get(pu));
		}
	}
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int users = accounts.size();
        DisjointSet ds = new DisjointSet(users);

        HashMap<String, Integer> emailindex = new HashMap<>();
        for(int i=0;i<users;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(emailindex.containsKey(accounts.get(i).get(j))){
                    ds.unionByRank(i, emailindex.get(accounts.get(i).get(j)));
                } else emailindex.put(accounts.get(i).get(j), i);
            }
        }

        List<List<String>> collectionEmails = new ArrayList<>();
        for(int i=0;i<users;i++) collectionEmails.add(new ArrayList<String>());

        for (Map.Entry<String, Integer> entry : emailindex.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            collectionEmails.get(ds.findUltimateParent(v)).add(k);
        }

        for(int i=0;i<users;i++) Collections.sort(collectionEmails.get(i));

        List<List<String>> mergedEmails = new ArrayList<>();
        int index = 0;
        for(int i=0;i<users;i++){
            int size = collectionEmails.get(i).size();
            if(size > 0){
                mergedEmails.add(new ArrayList<String>());
                mergedEmails.get(index).add(accounts.get(i).get(0));
                for(int j=0;j<size;j++){
                    mergedEmails.get(index).add(collectionEmails.get(i).get(j));
                }
                index++;
            }
        }
        return mergedEmails;
    }
}
