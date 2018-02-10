package org.hcm.jfbench.hr;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RoadsAndLibs {
	// https://www.hackerrank.com/challenges/torque-and-development

	private static long calculateMinimalCost(Map<Integer, Set<Integer>> cityConnections, int numOfCities, long costOfLib, long costOfRoad) {
		long finalCost;

		if (costOfRoad < costOfLib) {
			int uniqueGroupId = 1;
			int curGroupId;
			int[] citiesConns = new int[cityConnections.size()];
			int[] cityGroup = new int[numOfCities];
			int singleGroupCities = numOfCities - citiesConns.length;

			int c = 0;
			for (int city : cityConnections.keySet()) {
				citiesConns[c++] = city;
			}

			for (int i : citiesConns) {
				Set<Integer> cityConns = cityConnections.get(i);
				curGroupId = cityGroup[i];
				if (curGroupId == 0) {
					curGroupId = uniqueGroupId++;
					cityGroup[i] = curGroupId;
				}
				for (int city : cityConns) {
					int prev_group = cityGroup[city];
					cityGroup[city] = curGroupId;
					if (prev_group != 0 && prev_group != curGroupId) {
						for (int j : citiesConns) {
							if (cityGroup[j] == prev_group) {
								cityGroup[j] = curGroupId;
							}
						}
					}
				}
			}
			int[] citiesInGroup = new int[uniqueGroupId];
			for (int i : citiesConns) {
				citiesInGroup[cityGroup[i]] ++;
			}
			finalCost = costOfLib * singleGroupCities;
			for (int cities : citiesInGroup) {
				if (cities > 0) {
					finalCost += costOfLib + costOfRoad * (cities - 1);
				}
			}
		} else {
			finalCost = costOfLib * numOfCities;
		}
		return finalCost;
	}

	public static void main(String[] args) throws IOException {
		final Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++){
			int cities = in.nextInt();
			int roads = in.nextInt();
			long costLib = in.nextLong();
			long costRoad = in.nextLong();
			Map<Integer, Set<Integer>> cityConnections = new HashMap<>(cities >> 1 );
			for (int a1 = 0; a1 < roads; a1++) {
				int city_1 = in.nextInt() - 1;
				int city_2 = in.nextInt() - 1;
				Set<Integer> city1Set = cityConnections.computeIfAbsent(city_1, k -> new HashSet<>());
				city1Set.add(city_1);
				city1Set.add(city_2);
				Set<Integer> city2Set = cityConnections.computeIfAbsent(city_2, k -> new HashSet<>());
				city2Set.add(city_1);
				city2Set.add(city_2);
			}
			System.out.println(calculateMinimalCost(cityConnections, cities, costLib, costRoad));
		}
	}
}
