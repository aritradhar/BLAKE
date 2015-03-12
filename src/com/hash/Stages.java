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
	
//		System.out.println(Constants_256.h[0]);
//		System.out.println(Constants_256.h[1]);
//		System.out.println(Constants_256.h[2]);
//		System.out.println(Constants_256.h[3]);
//		System.out.println(Constants_256.h[4]);
//		System.out.println(Constants_256.h[5]);
//		System.out.println(Constants_256.h[6]);
//		System.out.println(Constants_256.h[7]);	
//		
		v = new long[16];
		
		System.arraycopy(Constants_256.h, 0, v, 0, 8);
		
		v[8]  =     Blake256.s[0] ^ Constants_256.C[0];
		v[9]  =     Blake256.s[1] ^ Constants_256.C[1];
		v[10] =     Blake256.s[2] ^ Constants_256.C[2];
		v[11] =     Blake256.s[3] ^ Constants_256.C[3];
		v[12] = Constants_256.t[0] ^ Constants_256.C[4];
		v[13] = Constants_256.t[0] ^ Constants_256.C[5];
		v[14] = Constants_256.t[1] ^ Constants_256.C[6];
		v[15] = Constants_256.t[1] ^ Constants_256.C[7];
		
		return v;
	}
	
	public static long[] G(int i, long _a, long _b, long _c, long _d, int r)
	{
		long a = _a, b = _b, c = _c, d = _d;
		
		//for rounds >= 10
		r %= 10;
		
		a = a + b + ((Blake256.m[Constants_256.P[r][2 * i]]) ^ (Constants_256.C[Constants_256.P[r][2 * i + 1]]));
		long t = d ^ a;
		d = Long.rotateRight(t, 16);
		c += d;
		t = b ^ c;
		
		//System.out.println(Long.toBinaryString(t));
		
		b = Long.rotateRight(t, 12);
		
		//System.out.println(Long.toBinaryString(b));
		
		a = a + b + ((Blake256.m[Constants_256.P[r][2 * i + 1]]) ^ (Constants_256.C[Constants_256.P[r][2 * i]]));
		t = d ^ a;
		d = Long.rotateRight(t, 8);
		c += d;
		t = b ^ c;
		b = Long.rotateRight(t, 7);
		
		return new long[]{a, b, c, d};
	}
	
	public static void finalStage()
	{
		long[] _h = new long[8];
		
		_h[0] = Constants_256.h[0] ^ Blake256.s[0] ^ Stages.v[0] ^ Stages.v[8];
		_h[1] = Constants_256.h[1] ^ Blake256.s[1] ^ Stages.v[1] ^ Stages.v[9];
		_h[2] = Constants_256.h[2] ^ Blake256.s[2] ^ Stages.v[2] ^ Stages.v[10];
		_h[3] = Constants_256.h[3] ^ Blake256.s[3] ^ Stages.v[3] ^ Stages.v[11];
		_h[4] = Constants_256.h[4] ^ Blake256.s[0] ^ Stages.v[4] ^ Stages.v[12];
		_h[5] = Constants_256.h[5] ^ Blake256.s[1] ^ Stages.v[5] ^ Stages.v[13];
		_h[6] = Constants_256.h[6] ^ Blake256.s[2] ^ Stages.v[6] ^ Stages.v[14];
		_h[7] = Constants_256.h[7] ^ Blake256.s[3] ^ Stages.v[7] ^ Stages.v[15];
		
		 System.arraycopy(_h, 0, Constants_256.h, 0, 8);
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
			
			temp = G(1, Stages.v[1], Stages.v[5], Stages.v[9], Stages.v[13], r);
			Stages.v[0]  = temp[0];
			Stages.v[4]  = temp[1];
			Stages.v[8]  = temp[2];
			Stages.v[12] = temp[3];
			
			temp = G(2, Stages.v[2], Stages.v[6], Stages.v[10], Stages.v[14], r);
			Stages.v[0]  = temp[0];
			Stages.v[4]  = temp[1];
			Stages.v[8]  = temp[2];
			Stages.v[12] = temp[3];
			
			temp = G(3, Stages.v[3], Stages.v[7], Stages.v[11], Stages.v[15], r);
			Stages.v[0]  = temp[0];
			Stages.v[4]  = temp[1];
			Stages.v[8]  = temp[2];
			Stages.v[12] = temp[3];
			
			temp = G(4, Stages.v[0], Stages.v[5], Stages.v[10], Stages.v[15], r);
			Stages.v[0]  = temp[0];
			Stages.v[4]  = temp[1];
			Stages.v[8]  = temp[2];
			Stages.v[12] = temp[3];
			
			temp = G(5, Stages.v[1], Stages.v[6], Stages.v[11], Stages.v[12], r);
			Stages.v[0]  = temp[0];
			Stages.v[4]  = temp[1];
			Stages.v[8]  = temp[2];
			Stages.v[12] = temp[3];
			
			temp = G(6, Stages.v[2], Stages.v[7], Stages.v[8], Stages.v[13], r);
			Stages.v[0]  = temp[0];
			Stages.v[4]  = temp[1];
			Stages.v[8]  = temp[2];
			Stages.v[12] = temp[3];
			
			temp = G(7, Stages.v[3], Stages.v[4], Stages.v[9], Stages.v[14], r);
			Stages.v[0]  = temp[0];
			Stages.v[4]  = temp[1];
			Stages.v[8]  = temp[2];
			Stages.v[12] = temp[3];
		}
	}
}
