package org.dev.baffle;

//A Naive recursive JAVA program to find minimum of coins 
//to make a given change V 
class Coin 
{ 
	
	public static int getMinCoin(int[] coins, int value) {
		if(value==0) return 0;
		
		for(int i=0;i<coins.length;i++) {
			int sub_res=getMinCoin(coins, value-coins[i]);
			return sub_res;
		}
		return 0;
		
	}
	
 // m is size of coins array (number of different coins) 
 static int minCoins(int coins[], int m, int V) 
 { 
    // base case 
    if (V == 0) return 0; 
    
    // Initialize result 
    int res = Integer.MAX_VALUE; 
    
    // Try every coin that has smaller value than V 
    for (int i=0; i<m; i++) 
    { 
      if (coins[i] <= V) 
      { 
          int sub_res = minCoins(coins, m, V-coins[i]); 
          
          System.out.println(sub_res);
          
          // Check for INT_MAX to avoid overflow and see if 
          // result can minimized 
          if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) 
             res = sub_res + 1; 
      } 
    } 
    return res; 
 } 
}

public class CoinTest {
	public static void main(String[] args) {
//		int[] input2= {5,10,2,1,10,5,1,1,2,1,10,2};
//		int input1=12;
//		
//		System.out.println(new Coin().getMinCoinToMakeSomeOf(input1, input2));
		
		
	    int coins[] =  {9, 6, 5, 1}; //{5,10,2,1,10,5,1,1,2,1,10,2};
	    int m = coins.length; 
	    int V = 11;//18; 
	    System.out.println("Minimum coins required is "+ new Coin().minCoins(coins, m, V) );
	   // System.out.println(Integer.MAX_VALUE);
		
	}
}
