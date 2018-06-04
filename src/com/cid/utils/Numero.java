/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cid.utils;

/**
 *
 * @author dguilcapi
 */
public class Numero {
    
    public static double round(double value, int places) {
		System.out.println("value: " + value);
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		System.out.println("value1: " + value);
		long tmp = Math.round(value);
		System.out.println("tmp: " + tmp);
		return (long) tmp / factor;
	}
    
}
