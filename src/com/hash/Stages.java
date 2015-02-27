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

public class Stages 
{
	static long []v;
	
	//4 X 4 matrix
	public static long[] initialize()
	{
		v = new long[16];
		
		System.arraycopy(Constants_256.h, 0, v, 0, 8);
		
		v[8]  =     Blacke256.s[0] ^ Constants_256.C[0];
		v[9]  =     Blacke256.s[1] ^ Constants_256.C[1];
		v[10] =     Blacke256.s[2] ^ Constants_256.C[2];
		v[11] =     Blacke256.s[3] ^ Constants_256.C[3];
		v[12] = Constants_256.t[0] ^ Constants_256.C[4];
		v[13] = Constants_256.t[0] ^ Constants_256.C[5];
		v[14] = Constants_256.t[1] ^ Constants_256.C[6];
		v[15] = Constants_256.t[1] ^ Constants_256.C[7];
		
		return v;
	}
	
	public static long[] G(int i, long _a, long _b, long _c, long _d, int r)
	{
		long a = _a, b = _b, c = _c, d = _d;
		
		a = a + b + (Blacke256.m[Constants_256.P[r][2 * i]] ^ Constants_256.C[Constants_256.P[r][2 * i + 1]]);
		d = Long.rotateRight((d ^ a), 16);
		c += d;
		b = Long.rotateRight((b ^ c), 12);
		a = a + b + (Blacke256.m[Constants_256.P[r][2 * i + 1]] ^ Constants_256.C[Constants_256.P[r][2 * i]]);
		d = Long.rotateRight((d ^ a), 8);
		c += d;
		b = Long.rotateRight((b ^ c), 7);
		
		return new long[]{a, b, c, d};
	}
	
	public static final long[] finalize(long[] v)
	{
		long[] _h = new long[8];
		
		_h[0] = Constants_256.h[0] ^ Blacke256.s[0] ^ v[0] ^ v[8];
		_h[1] = Constants_256.h[1] ^ Blacke256.s[1] ^ v[1] ^ v[9];
		_h[2] = Constants_256.h[2] ^ Blacke256.s[2] ^ v[2] ^ v[10];
		_h[3] = Constants_256.h[3] ^ Blacke256.s[3] ^ v[3] ^ v[11];
		_h[4] = Constants_256.h[4] ^ Blacke256.s[0] ^ v[4] ^ v[12];
		_h[5] = Constants_256.h[5] ^ Blacke256.s[1] ^ v[5] ^ v[13];
		_h[6] = Constants_256.h[6] ^ Blacke256.s[2] ^ v[6] ^ v[14];
		_h[7] = Constants_256.h[7] ^ Blacke256.s[3] ^ v[7] ^ v[15];
		
		return _h;
	}
	
	public static void round()
	{
		//goes with Gi
		
		long []temp = new long[4];
		for(int r = 0; r < 14; r++)
		{
			/*
			 *	G0(v0 , v4 , v8 , v12) 
			 *	G1(v1 , v5 , v9 , v13) 
			 *	G2(v2 , v6 , v10, v14) 
			 *	G3(v3 , v7 , v11, v15)
			 *	G4(v0 , v5 , v10, v15) 
			 *	G5(v1 , v6 , v11, v12) 
			 *	G6(v2 , v7 , v8 , v13) 
			 *	G7(v3 , v4 , v9 , v14) 
			 */
			
			temp = G(0, Stages.v[0], Stages.v[4], Stages.v[8], Stages.v[12], r);
			Stages.v[0]  = temp[0];
			Stages.v[4]  = temp[1];
			Stages.v[8]  = temp[2];
			Stages.v[12] = temp[3];
			
			
		}
	}
}
