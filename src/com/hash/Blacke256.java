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

public class Blacke256 
{
	public static long[] s, m;
	public Blacke256(long[] s, long[] m)
	{
		Blacke256.s = s;
		Blacke256.m = m;
	}
	
	public void hash()
	{
		Stages.initialize();
		Stages.round();
		Stages.finalStage();
	}
	
	public static void main(String[] args) 
	{
		long []m = new long[16];
		Arrays.fill(m, 0);
		long []s = new long[4];
		Arrays.fill(s, 0);
		
		
	}
}
