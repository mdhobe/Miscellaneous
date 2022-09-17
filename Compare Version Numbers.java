class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
        int length = Math.min(v1.length, v2.length);

		for (int i = 0; i < Math.min(v1.length, v2.length); i++) {
			int ver1 = Integer.parseInt(v1[i]);
			int ver2 = Integer.parseInt(v2[i]);

			if(ver1 > ver2) return 1;
			else if(ver1 < ver2) return -1;
		}
        
        for(int i=length;i<v1.length;i++){
            if(i >= v2.length){
                int ver1 = Integer.parseInt(v1[i]);
                if(ver1 > 0) return 1;
            }
        }
        
        for(int i=length;i<v2.length;i++){
            if(i >= v1.length){
                int ver2 = Integer.parseInt(v2[i]);
                if(ver2 > 0) return -1;
            }
        }
        
		return 0;
    }
}
