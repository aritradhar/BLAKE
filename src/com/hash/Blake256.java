//*************************************************************************************
//*********************************************************************************** *
//author Aritra Dhar 																* *
//Research Engineer																  	* *
//Xerox Research Center India													    * *
//Bangalore, India																    * *
//--------------------------------------------------------------------------------- * * 
///////////////////////////////////////////////// 									* *
//The program will do the following:::: // 											* *
///////////////////////////////////////////////// 									* *
//version 1.0 																		* *
//*********************************************************************************** *
//*************************************************************************************


package com.hash;

import java.util.Arrays;

public class Blake256 
{
	public static long[] s, m;
	public Blake256(long[] s, long[] m)
	{
		Blake256.s = s;
		Blake256.m = m;
	}
	
	public long[] hash()
	{
		Stages.initialize();
		Stages.round();
		Stages.finalStage();
		
		return Constants_256.h;
	}
	
	public static void main(String[] args) 
	{
		
		long []m = new long[16];
		Arrays.fill(m, 0);
		long []s = new long[4];
		Arrays.fill(s, 0);
		
		Blake256 b = new Blake256(s, m);
		long []h = b.hash();
		
		for(long i : h)
			System.out.print(i + " ");
	}
}
