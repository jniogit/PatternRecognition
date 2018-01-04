package io.swagger.recognition;

import java.util.Comparator;

import io.swagger.model.Point;

public class Utility implements Comparator<io.swagger.model.Point> {

	// compare points by slope
	// public final Comparator<io.swagger.model.Point> SLOPE_ORDER = new
	// Comparator<io.swagger.model.Point>() {
	// public int compare(io.swagger.model.Point o1, io.swagger.model.Point o2) {
	// double slope1 = slopeTo(o1);
	// double slope2 = slopeTo(o2);
	// if (slope1 == slope2) {
	// return 0;
	// }
	// if (slope1 < slope2) {
	// return -1;
	// }
	// return 1;
	// }
	// };

	/***********************************************************************
	 * Bottom-Up merge sorting functions
	 ***********************************************************************/

	// stably merge a[lo..m] with a[m+1..hi] using aux[lo..hi]
	private static void merge(io.swagger.model.Point[] a, io.swagger.model.Point[] aux, int lo, int m, int hi,
			Comparator<io.swagger.model.Point> comparator) {
		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		// merge back to a[]
		int i = lo, j = m + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > m) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(comparator, aux[j], aux[i])) {
				a[k] = aux[j++];
			} else
			{
				a[k] = aux[i++];
			}
		}
	}

	// bottom-up mergesort
	public static void sort(io.swagger.model.Point[] a, Comparator<io.swagger.model.Point> comparator) 
	{
		int N = a.length;
		io.swagger.model.Point[] aux = new io.swagger.model.Point[N];
		for (int n = 1; n < N; n = n + n) 
		{
			for (int i = 0; i < N - n; i += n + n) 
			{
				int lo = i;
				int m = i + n - 1;
				int hi = Math.min(i + n + n - 1, N - 1);
				merge(a, aux, lo, m, hi, comparator);
			}
		}
	}

	/***********************************************************************
	 * Helper sorting functions
	 ***********************************************************************/

	// is v < w ?
	private static boolean less(Comparator<io.swagger.model.Point> comparator, io.swagger.model.Point v,
			io.swagger.model.Point w) {
		return comparator.compare(v, w) < 0;
	}

	@Override
	public int compare(Point o1, Point o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
