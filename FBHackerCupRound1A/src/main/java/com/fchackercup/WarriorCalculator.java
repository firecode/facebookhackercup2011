package com.fchackercup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * The following is the equation used to solve the problem:
 * 
 * x is number of warriors 
 * y is number of shield generators
 * G is cost of shield
 * W is cost of warrior
 * D is maximum damage
 * T is total amount available
 * 
 * based on the problem 
 * 
 * Eq 1: Gx + Wy = T
 * Eq 2: x * y = D
 * 
 * so 
 * 
 * based on Eq 1; y = (T - Gx)/W
 * 
 * substituting y into Eq 2; we get 
 * 
 * D = x*(T-Gx)/W
 * 
 * taking differentiation of the above equation and setting the value to zero for maximum D value
 * 
 * we get 
 * 
 * T - 2Gx = 0
 * 
 * which means x = T/2G;
 * 
 * using this one in the solution below
 * 
 * 
 * @author raghurambongula
 *
 */
public class WarriorCalculator {

	public static final String NEW_LINE = System.getProperty("line.separator");

	public long calculate(long totalAmount, int g, int w) {

		// based on the equation mentioned in the comments

		long warriorsRequired = totalAmount / (2 * g);
		return warriorsRequired;
	}

	public static void main(String[] args) throws IOException {
		WarriorCalculator wc = new WarriorCalculator();

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

				long totalAmount = Long.valueOf(inputs[2]);
				int g = Integer.valueOf(inputs[0]);
				int w = Integer.valueOf(inputs[1]);

				long warriorsRequired = wc.calculate(totalAmount, g, w);

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

}
