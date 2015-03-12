package com.hash;

import java.util.Arrays;

public class Constants_256 
{
	public static final long []IV = 
	{
		Long.parseLong("6A09E667", 16),
		Long.parseLong("BB67AE85", 16),
		Long.parseLong("3C6EF372", 16),
		Long.parseLong("A54FF53A", 16),
		Long.parseLong("510E527F", 16),
		Long.parseLong("9B05688C", 16),
		Long.parseLong("1F83D9AB", 16),
		Long.parseLong("5BE0CD19", 16),
	};
	
	public static final long []C = 
	{
		Long.parseLong("243F6A88", 16),
		//0x243F6A88, 
		Long.parseLong("85A308D3", 16),
		//0x85A308D3, 
		Long.parseLong("13198A2E", 16),
		//0x13198A2E, 
		Long.parseLong("03707344", 16),
		//0x03707344, 
		Long.parseLong("A4093822", 16),
		//0xA4093822, 
		Long.parseLong("299F31D0", 16),
		//0x299F31D0, 
		Long.parseLong("082EFA98", 16),
		//0x082EFA98, 
		Long.parseLong("EC4E6C89", 16),
		//0xEC4E6C89, 
		Long.parseLong("452821E6", 16),
		//0x452821E6, 
		Long.parseLong("38D01377", 16),
		//0x38D01377, 
		Long.parseLong("BE5466CF", 16),
		//0xBE5466CF, 
		Long.parseLong("34E90C6C", 16),
		//0x34E90C6C, 
		Long.parseLong("C0AC29B7", 16),
		//0xC0AC29B7, 
		Long.parseLong("C97C50DD", 16),
		//0xC97C50DD, 
		Long.parseLong("3F84D5B5", 16),
		//0x3F84D5B5, 
		Long.parseLong("B5470917", 16),
		//0xB5470917
	};
	
	public static final short[] t = {0, 0};
	
	public static long[] h = Arrays.copyOf(IV, 8);
	
	public static final short [][] P = 
	{
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
