// Tabulation
public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int target = 0;
	    for(int a:arr) target += a;
	    
	    boolean[][] dp = new boolean[n][target+1];
	    for(int i=0;i<n;i++) dp[i][0] = true;
	    if(arr[0] <= target) dp[0][arr[0]] = true;
	    
	    for(int i=1;i<n;i++){
	        for(int t=1;t<=target;t++){
	            boolean nottake = dp[i-1][t];
	            boolean take = false;
	            if(arr[i] <= t) take = dp[i-1][t-arr[i]];
	            dp[i][t] = take | nottake;
	        }
	    }
	    
	    //last check
	    int min = (int) 1e9;
	    for(int i=0;i<=target;i++){
	        if(dp[n-1][i]){
	            min = Math.min(min, Math.abs(i - (target - i)));
	        }
	    }
	    return min;
	} 

//Space Optmization
public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int target = 0;
	    for(int a:arr) target += a;
	    
	    boolean[] dp = new boolean[target+1];
	    dp[0] = true;
	    
	    for(int i=1;i<n;i++){
	        boolean[] temp = new boolean[target+1];
	        for(int t=1;t<=target;t++){
	            boolean nottake = dp[t];
	            boolean take = false;
	            if(arr[i] <= t) take = dp[t-arr[i]];
	            temp[t] = take | nottake;
	        }
	        for(int t=1;t<=target;t++) dp[t] = temp[t];
	    }
	    
	    //last check
	    int min = (int) 1e9;
	    for(int i=0;i<=target;i++){
	        if(dp[i]){
	            min = Math.min(min, Math.abs(i - (target - i)));
	        }
	    }
	    return min;
	} 
