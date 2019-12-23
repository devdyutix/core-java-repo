package org.dev.baffle;

import java.util.Arrays;

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
   Two player A & B playing a game like, player A starts from beginning and choose first 2 numbers, and replace the second number from first from all over the array.
   Similarly, player B start playing from next and choose 2 Number and doing same till the all arrays shouldn't be same.
   find who will be winner
   Note: suppose, player A first start the match. and the winner will be the Player who got Maximum chance to play.
   
   input:{1,3,3,2,2,1}
   Player A start playing and choose first 2 number: 1 & 3 
   Now 2 will be replaced by 1 from all over the Array like {1,1,1,2,2,1}
	 * */
	public static String findWinnerOfGame() {
		return null;
	}
	public static void main(String[] args) {
		int arr[]={900, 940, 950, 1100, 1500, 1800};
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		
		int len=arr.length;
		
		System.out.println(findMinimumPlateformRequired(arr, dep, len));
	}
}
