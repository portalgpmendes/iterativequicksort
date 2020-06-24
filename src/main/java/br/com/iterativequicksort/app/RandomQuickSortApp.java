package br.com.iterativequicksort.app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.iterativequicksort.algorithm.RandomQuickSort;
import br.com.iterativequicksort.util.ArrayUtil;

public class RandomQuickSortApp {
	
	private static int[] array;

	private static FileWriter arq;
	private static PrintWriter gravarArq;
	
	public static void randomQuickSort(int n) {
		array = ArrayUtil.makeUnsorted(n);
		RandomQuickSort rqs = new RandomQuickSort(array);
		rqs.sort(0, array.length - 1);
	}

	public static void main(String[] args) throws IOException {
		arq = new FileWriter("randomquicksort.txt");
		gravarArq = new PrintWriter(arq);
		
		for (int i = 40000; i <= 150000; i+=10000) {
			long startTime = System.currentTimeMillis();
			randomQuickSort(i);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			gravarArq.printf(i + "," + totalTime + "\n");
		}
	    
		arq.close();
	}

}
