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

public class Util 
{
	public static long[] G(int i, long _a, long _b, long _c, long _d, int r, long []m)
	{
		long a = _a, b = _b, c = _c, d = _d;
		
		a = a + b + (m[Constants_256.P[r][2 * i]] ^ Constants_256.C[Constants_256.P[r][2 * i + 1]]);
		d = Long.rotateRight((d ^ a), 16);
		c += d;
		b = Long.rotateRight((b ^ c), 12);
		a = a + b + (m[Constants_256.P[r][2 * i + 1]] ^ Constants_256.C[Constants_256.P[r][2 * i]]);
		d = Long.rotateRight((d ^ a), 8);
		c += d;
		b = Long.rotateRight((b ^ c), 7);
		
		return new long[]{a, b, c, d};
	}
}
