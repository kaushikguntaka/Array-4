// TC - O(n), SC - O(1)

// LC - 31

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        int n = nums.length;
        
        int peak_index = -1;
        int peak_swap_ele_index = -1;
        
        // find peak
        for(int x = n-2; x >= 0; x--){
            if(nums[x] < nums[x+1]){
                peak_index = x;
                break;
            }    
        }
        
        // find swap element
        for(int x = n-1; x >= 0 && peak_index != -1; x--){
            if(nums[peak_index] < nums[x]){
                peak_swap_ele_index = x;
                // swap
                swap(nums, peak_index, peak_swap_ele_index);       
                break;
            }
        }
        
        // reverse
        reverse(nums, peak_index+1, n);
    }
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void reverse(int[] arr, int start, int end){
        end--;
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}