package com.ly;

import java.util.List;

public class InputMethod {
	
	
	
	
	public static void main(String[] args) {
         InputMethodService inputMethodService = new InputMethodService();
         inputMethodService.initMap();
         int [] inputArray = {3};
         List<String> resultList = inputMethodService.input(inputArray);
         inputMethodService.output(resultList);
	}
}
