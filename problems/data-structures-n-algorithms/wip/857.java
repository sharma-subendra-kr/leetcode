// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
// 857. Minimum Cost to Hire K Workers

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class S857 {
	public static void main (String[] args) {
		int quality[], wage[], k;

		quality = new int[]{10,20,5};
		wage = new int[]{70,50,30};
		k = 2;
		double result;

		result = mincostToHireWorkers(quality, wage, k);

		System.out.println(result);
	}

	static class Data {
		int quality;
		int wage;
	}
	public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
		Data data[] = new Data[quality.length];
		for (int i = 0; i < quality.length; i++) {
			data[i] = new Data();
			data[i].quality = quality[i];
			data[i].wage = wage[i];
		}

		Arrays.sort(data, new Comparator<Data>() {
			@Override
			public int compare (Data o1, Data o2) {
				return o1.quality/o1.wage - o2.quality/o2.wage;
			}
		});
		return 0;
	}
}