/*
 * Timothy Shine
 * Computing Prime Numbers
 * 27 November 2015
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Runner {

	public static void main(String args[]) {
		System.out.println("Enter upper limit: ");
		Scanner input = new Scanner(System.in);
		int MAX = input.nextInt(); // User input upper number to be checked for primality
		boolean primes[];
		primes = new boolean[MAX];
		System.out.println("\nComputing Prime Numbers Between 1 and " + MAX + "\n");
		computePrimes(primes);
		displayPrimes(primes);

	}

	// Finds the prime numbers of the array
	private static void computePrimes(boolean[] primes) {
		primes[0] = false;
		primes[1] = false;

		// Starts all numbers as primes
		for (int x = 2; x < primes.length; x++) {
			primes[x] = true;
		}
		// Checks every number above 2 for primality
		for (int y = 2; y < primes.length; y++) {
			if (primes[y] == true) {
				for (int j = y * y; j < primes.length; j += y) {
					primes[j] = false;
				}
			}
		}
	}

	// Displays the prime numbers
	private static void displayPrimes(boolean[] primes) {
		DecimalFormat output = new DecimalFormat("0000");
		int lineCounter = 0; // Used to have line feed every 16 entries
		for (int x = 2; x < primes.length; x++) {
			if (primes[x] == true) {
				System.out.print(output.format(x) + " ");
				lineCounter++;
				// Line feed every 16 entries for wrapping text
				if (lineCounter % 16 == 0)
					System.out.println();
			}
		}
	}
}
