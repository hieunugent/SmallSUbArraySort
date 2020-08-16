import java.util.*;

class Program {
  public static int[] subarraySort(int[] array) {
    // Write your code here.h
		int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;
		 for(int i = 0; i < array.length; i++){
			 int num = array[i];
			 if(isOutOfOrder(i, num, array)){
				 minOutOfOrder=Math.min(minOutOfOrder,num);
				 maxOutOfOrder=Math.max(maxOutOfOrder,num);
			 }
		 }
		if(minOutOfOrder ==Integer.MAX_VALUE){
			return new int[] {-1, -1};
		}
		int startSubLeft=0;
		while(minOutOfOrder >= array[startSubLeft]){
			startSubLeft++;
		}
		int startSubRight= array.length-1;
		while(maxOutOfOrder <= array[startSubRight]){
			startSubRight--;
		}
		
    return new int[] {startSubLeft,startSubRight};
  }
	
	
	public static Boolean isOutOfOrder(int i,int num,int[] array){
		if(i == 0){
			return num > array[i+1];
		}
		if(i == array.length -1){
			return num < array[i-1];
		}
		return num > array[i+1] || num < array[i-1];
	}
}
