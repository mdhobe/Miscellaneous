class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		int index = search(arr, x);
		System.out.println(index);
		if (index == -1) {
			int pleft = searchRange(arr, x);
			int pright = pleft + 1;
			while (pleft >= 0 && pright < arr.length && k-- > 0) {
				if (x - arr[pleft] > arr[pright] - x) {
					pq.add(arr[pright]);
					pright++;
				} else if (x - arr[pleft] <= arr[pright] - x) {
					pq.add(arr[pleft]);
					pleft--;
				}
			}
			while (pleft >= 0 && k-- > 0) {
				pq.add(arr[pleft]);
				pleft--;
			}
			while (pright < arr.length && k-- > 0) {
				pq.add(arr[pright]);
				pright++;
			}
		} else {
			pq.add(arr[index]);
			k--;
			int pleft = index - 1, pright = index + 1;
			while (pleft >= 0 && pright < arr.length && k-- > 0) {
				if (arr[index] - arr[pleft] > arr[pright] - arr[index]) {
					pq.add(arr[pright]);
					pright++;
				} else if (arr[index] - arr[pleft] <= arr[pright] - arr[index]) {
					pq.add(arr[pleft]);
					pleft--;
				}
			}
			while (pleft >= 0 && k-- > 0) {
				pq.add(arr[pleft]);
				pleft--;
			}
			while (pright < arr.length && k-- > 0) {
				pq.add(arr[pright]);
				pright++;
			}
		}

		List<Integer> ans = new ArrayList<>();
		while (pq.size() > 0) {
			ans.add(pq.poll());
		}
		System.out.println(ans);
		return ans;
    }
    
    public int search(int[] arr, int target) {
		int low = 0, high = arr.length - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (arr[mid] == target) return mid;
			else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public int searchRange(int[] arr, int target) {
        if(target < arr[0]) return 0;
		else if(target > arr[arr.length-1]) return arr.length-1;
		int low = 0, high = arr.length - 1;
		int ans = 0;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (arr[mid] < target && target < arr[mid + 1]) return mid;
			else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
}
