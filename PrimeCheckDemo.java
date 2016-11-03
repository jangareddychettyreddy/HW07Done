package com.abc.pp.prime;

public class PrimeCheckDemo {
	public static void main(String[] args) {

		Runnable r1 = new Runnable() {
			public void run() {

				long nsStart = System.nanoTime();
				long start = 2;
				long limit = 100;
				System.out.printf(
						"Checking for prime numbers between %,d and %,d%n",
						start, (limit / 2));
				long primeCount = 0;
				for (long candidate = start; candidate <= (limit / 2); candidate++) {
					try {
						Thread.sleep(1 * 10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (PrimeTools.isPrime(candidate)) {
						primeCount++;
						System.out.println(candidate);
					}
				}

				long nsElapsed = System.nanoTime() - nsStart;
				System.out
						.printf("Found %,d prime numbers between %,d and %,d in %.5f seconds%n",
								primeCount, start, (limit / 2), nsElapsed / 1e9);
			}
		};

		Runnable r2 = new Runnable() {
			public void run() {

				long nsStartTime = System.nanoTime();
				// long start = 2;
				long limit = 100;
				System.out.printf(
						"Checking for prime numbers between %,d and %,d%n",
						(limit / 2), limit);
				long primeCount = 0;
				for (long candidate = (limit / 2); candidate <= limit; candidate++) {
					try {
						Thread.sleep(1 * 10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (PrimeTools.isPrime(candidate)) {
						primeCount++;
						System.out.println(candidate);
					}
				}

				long nsElapsed = System.nanoTime() - nsStartTime;
				System.out
						.printf("Found %,d prime numbers between %,d and %,d in %.5f seconds%n",
								primeCount, (limit / 2), limit, nsElapsed / 1e9);
			}
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}