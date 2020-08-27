package com.ly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputMethodService {
	
	public Map<String,String> map = new HashMap<String,String>(12);
	
	/**
	 * 
	 * @param 初始化数据 
	 */
	public void initMap() {
		map.put("1","1");
		map.put("2","abc");
		map.put("3","def");
		map.put("4","ghi");
		map.put("5","jkl");
		map.put("6","mno");
		map.put("7","pqrs");
		map.put("8","tuv");
		map.put("9","wxyz");
		map.put("0","0");
	}
	/**
	 * 
	 * @param inputArray 输入数字集合
	 * @return 
	 */
	public List<String> input(int [] inputArray){
		int currentIndex = 0;
		List<String> outputList = new ArrayList<>();
		if(inputArray.length <=0) {
			System.out.println("请输入数字");
			return null;
		}
		char [] charArray = map.get(inputArray[currentIndex]+"").toCharArray();
		if(currentIndex == inputArray.length-1) {//当前数组只有一个数值
			for(int i =0 ; i < charArray.length;i++) {
				String result = charArray[i]+"";
				outputList.add(result);
			}
		}else {
			for(int i =0 ; i < charArray.length;i++) {//当前数组有多个数值			
				String result = charArray[i]+"";
				combination(inputArray,currentIndex,outputList,result);
			}
			
		}
		return outputList;
	}
	
	public void output(List<String> resultList){
		if(resultList != null) {
			for(int i =0 ; i < resultList.size(); i++) {
				System.out.println(resultList.get(i));
			}
		}
	}
	/**
	 * 
	 * @param inputArray //输入的一个或多个数值转换的数组
	 * @param currentIndex //当前递归的层次(输入的数组的下标值)
	 * @param outputList //结果集
	 * @param result //递归拼接的单个结果
	 * @return
	 */
	public String combination(int [] inputArray,int currentIndex,List<String> outputList,String result) {
		currentIndex++;
		char [] charArray = map.get(inputArray[currentIndex]+"").toCharArray();
		if(currentIndex == inputArray.length-1) {//递归到末端时拼接结果集
			for(int i =0 ; i < charArray.length;i++) {
				String str = "";
				str = result + charArray[i];
				outputList.add(str);
			}
		}else {			
			for(int i =0 ; i < charArray.length;i++) {			
				String str = result + charArray[i];
				str = combination(inputArray,currentIndex,outputList,str);
			}
			return result;
		}

		
		return null;
	}
}
