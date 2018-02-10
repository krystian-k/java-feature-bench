package org.hcm.jfbench.hr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JimAndTheOrders {

	private static final String testInput = "5\n8 1\n4 2\n5 6\n3 1\n4 3\n";
	private static final String testOutput = "4 2 5 1 3 ";

	static class Order {
		final int seqNo;
		final long timeReady;

		Order(int seqNo, long timeReady) {
			this.seqNo = seqNo;
			this.timeReady = timeReady;
		}

		long getReady() {
			return timeReady * 1000 + seqNo;
		}
	}

	public static void main(String[] args) {
		final Scanner in = new Scanner(testInput);
		final int ordersCnt = in.nextInt();
		List<Order> orders = new ArrayList<>(ordersCnt);
		int time, duration;
		for (int i = 0; i < ordersCnt; i++) {
			time = in.nextInt();
			duration = in.nextInt();
			orders.add(new Order(i+1, time + duration));
		}
		orders.sort(Comparator.comparingLong(Order::getReady));
		for (Order o : orders) {
			System.out.print(String.format("%d ", o.seqNo));
		}
		System.out.println();
	}
}
