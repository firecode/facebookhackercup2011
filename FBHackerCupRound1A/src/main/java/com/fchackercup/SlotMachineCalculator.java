package com.fchackercup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
 * @author raghurambongula
 *
 */
public class SlotMachineCalculator {

	public static final String NEW_LINE = System.getProperty("line.separator");

	
	public static void main(String[] args) throws IOException {
		SlotMachineCalculator wc = new SlotMachineCalculator();

		FileInputStream fstream = new FileInputStream("/fb/input.txt");

		BufferedWriter out = new BufferedWriter(
				new FileWriter("/fb/output.txt"));

		DataInputStream in = new DataInputStream(fstream);

		StringBuilder builder = new StringBuilder();
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));
			String strLine;
			// Read File Line By Line
			int i = 0;
			while ((strLine = br.readLine()) != null) {
				if (i == 0) {
					i++;
					continue;
				}
				i++;
				String[] inputs = strLine.split(" ");

				long g = Long.valueOf(inputs[0]);
				long w = Long.valueOf(inputs[1]);

				long warriorsRequired = wc.calculate(g, w);

				builder.append(warriorsRequired);
				builder.append(WarriorCalculator.NEW_LINE);
			}

			out.write(builder.toString());

		} finally {
			// Close the input stream
			in.close();
			out.close();
		}
	}



	private static long calculate(long complete, long initialLimit) {
		
		long limit = initialLimit;
		
		long i = 1;
		long z = 0;
   
		while(true){
			if(initialLimit > complete){
				if(z == complete- 1){
					z = i;
					break;
				}
			}else{
				if(z == complete){
					z = i;
					break;
				}
			}
			
			
			i = i+limit;
			while(i >= complete){
				i = i - complete;
			}
			if(i == 0){
				i = i + 1;
			}
			z++;
			limit++;
		}
		return z;
	}

}
