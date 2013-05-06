package com.client.corbajms.main;

import com.client.corbajms.business.WindowBusinessLogic;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 09:29:17 01/05/2013
 */
public class Main {

	public static void main(String[] args) {
		WindowBusinessLogic windowBusinessLogic = new WindowBusinessLogic();
		windowBusinessLogic.builderWindow();
	}
	
}