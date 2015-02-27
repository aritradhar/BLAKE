package com.hash;

public class Constants_256 
{
	public static int IV0 = 0x6A09E667;
	public static int IV1 = 0xBB67AE85;
	public static int IV2 = 0x3C6EF372;
	public static int IV3 = 0xA54FF53A;
	public static int IV4 = 0x510E527F;
	public static int IV5 = 0x9B05688C;
	public static int IV6 = 0x1F83D9AB;
	public static int IV7 = 0x5BE0CD19;
	
	public static int C0 = 0x243F6A88;
	public static int C1 = 0x85A308D3;
	public static int C2 = 0x13198A2E;
	public static int C3 = 0x03707344;
	public static int C4 = 0xA4093822;
	public static int C5 = 0x299F31D0;
	public static int C6 = 0x082EFA98;
	public static int C7 = 0xEC4E6C89;
	public static int C8 = 0x452821E6;
	public static int C9 = 0x38D01377;
	public static int C10 = 0xBE5466CF;
	public static int C11 = 0x34E90C6C;
	public static int C12 = 0xC0AC29B7;
	public static int C13 = 0xC97C50DD;
	public static int C14 = 0x3F84D5B5;
	public static int C15 = 0xB5470917;
	
	public static short [][]P = {
		{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
		{14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3},
		{11, 8, 12, 0, 5, 2, 15, 13, 10, 14, 3, 6, 7, 1, 9, 4},
		{7, 9, 3, 1, 13, 12, 11, 14, 2, 6, 5, 10, 4, 0, 15, 8},
		{9, 0, 5, 7, 2, 4, 10, 15, 14, 1, 11, 12, 6, 8, 3, 13},
		{2, 12, 6, 10, 0, 11, 8, 3, 4, 13, 7, 5, 15, 14, 1, 9},
		{12, 5, 1, 15, 14, 13, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11},
		{13, 11, 7, 14, 12, 1, 3, 9, 5, 0, 15, 4, 8, 6, 2, 10},
		{6, 15, 14, 9, 11, 3, 0, 8, 12, 2, 13, 7, 1, 4, 10, 5},
		{10, 2, 8, 4, 7, 6, 1, 5, 15, 11, 9, 14, 3, 12, 13, 0}
	};
	
}
