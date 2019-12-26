package org.dev.baffle;

import java.util.Arrays;
import java.util.Iterator;

public class AirtelHackerRank {
	/* 
	find the Minimim number of platefrom required for the train.  
	Given arrival and departure times of all trains that reach a railway station, 
	the task is to find the minimum number of platforms required for the railway station so that no train waits.
	We are given two arrays which represent arrival and departure times of trains that stop
	
	Input arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
	dep[] =       {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
	Output 3
	 * */
	public static int findMinimumPlateformRequired(int[] arr, int[] dep, int len) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int plateform_needed=1;
		int result=1;
		int i=1, j=0;
		
		while(i<len && j<len) {
			if(arr[i]<=dep[j]) {
				plateform_needed++;
				i++;
				if(plateform_needed>result)
					result=plateform_needed;
			}else {
				plateform_needed--;
				j++;
			}
		}
		
		
		
		return result;
	}
	/*
   There are two players A and B who are interested in playing a game of numbers. In each move a player pick two distinct number, 
   let’s say a1 and a2 and then replace all a2 by a1 or a1 by a2. 
   They stop playing game if any one of them is unable to pick two number and the player who is unable to pick two distinct number in an array, looses the game. 
   First player always move first and then second. Task is to find which player wins.

	Examples:

	Input :  arr[] = { 1, 3, 3, 2,, 2, 1 }
	Output : Player 2 wins
	Explanation:
	First plays always looses irrespective
	of the numbers chosen by him. For example,
	say first player picks ( 1 & 3) 
	replace all 3 by 1  
	Now array Become { 1, 1, 1, 2, 2, 1 }
	Then second player picks ( 1  2 )
	either he replace 1 by 2 or 2 by 1 
	Array Become { 1, 1, 1, 1, 1, 1 }
	Now first player is not able to choose.

	Input  : arr[] = { 1, 2, 1, 2 }
	Output : Player 1 wins
	 * */
	public static String findWinnerOfGame(int arr[]) {
		
		String playerAr[]= {"A","B"};
		int countA=0;
		int countB=0;
		
		if(arr.length<4)
			return "-1: Atleast 4 numbers are required to initiate the game.";
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int firstNum=arr[i];
				int secondNum=arr[j];
				//Now Replacing the 2nd number from 1st number in all over the Array;
				for(int k=0;k<arr.length;k++) {
					if(arr[k]==secondNum) {
						arr[k]=firstNum;
					}
				}
				//get the player name and increment the count value
				String player=playerAr[0];
				if(player.equals("A"))
					countA++;
				else
					countB++;
				playerAr[0]=playerAr[1];
				playerAr[1]=player;
				i=j+1;
			}
		}
		if(countA>countB)
			return "Player A won the match";
		else
			return "Player B won the match";
		
		//return null;
	}
	public static void main(String[] args) {
//		int arr[]={900, 940, 950, 1100, 1500, 1800};
//		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
//		
//		int len=arr.length;
//		
//		System.out.println(findMinimumPlateformRequired(arr, dep, len));
		
		int arr[]= {1,3,3,2,1};
		System.out.println(findWinnerOfGame(arr));
	}
}
