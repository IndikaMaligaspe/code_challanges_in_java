package coding_challanges.binary_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Misc {
	static List<Integer> prices = new ArrayList<>(Arrays.asList(3,4,2,3));
	static List<Integer> distance = new ArrayList<>(Arrays.asList(10,10,5,20));
	
	private static int calculate(List <Integer> prices, List<Integer> distances) {
		
		int minPrice;
		
		int minPriceIndex = 0;

		List<Integer> priceCopy = new ArrayList(Arrays.asList(prices));
		
		int[] priceIndexArr = new int [prices.size()];
		int i = 0;
		minPrice = priceCopy.get(0);
		minPriceIndex = 0;
		while(priceCopy.size() > 0) {
			if(priceCopy.get(i) < minPrice) {
				minPrice =  priceCopy.get(i);
				minPriceIndex = i;
			}
		}
		
		int distnceSum = 0; 
		int pos = 0;
		int[] distnceToStation = new int[distances.size()];
		for(int distance : distances ) {
			distnceSum += distance;
			distnceToStation[pos] = distnceSum;
			pos +=1;
		}
		
		System.out.println(distnceSum);
		
//		for(int sortedPrice : sortedPrices) {
//			for(int i=0;i < prices.size();i++) {
//				if(prices.get(i) == sortedPrice) {
//					
//				}
//			}
//		}
//		
		
//		System.out.println(minPrice+" - "+minPriceIndex+" - "+sortedPrices);
		return 0;
	}
	
	public static void main(String[] args) {
		Misc.calculate(prices, distance);
	}
}
