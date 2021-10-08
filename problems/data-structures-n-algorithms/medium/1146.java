// 1146. Snapshot Array
// https://leetcode.com/problems/snapshot-array/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SnapshotArray {
	List<Snapshot>[] array;
	int length;
	int snap;

	public SnapshotArray (int length) {
		this.length = length;
		snap = 0;
		array = new ArrayList[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = new ArrayList<>();
			array[i].add(new Snapshot(snap, 0));
		}
	}

	public void set (int index, int val) {
		List<Snapshot> snaps = array[index];
		if (snaps.get(snaps.size() - 1).getSnap() != snap) {
			snaps.add(new Snapshot(snap, val));
		} else {
			snaps.get(snaps.size() - 1).setValue(val);
		}
	}

	public int snap () {
		return snap++;
	}

	public int get (int index, int snap_id) {
		List<Snapshot> list = array[index];
		if (list.size() == 0) {
			return 0;
		}
		return list.get(getIndex(list, snap_id)).getValue();
	}

	public int getIndex (List<Snapshot> snaps, int snap) {
		int low = 0;
		int high = snaps.size() - 1;
		int mid = 0;
		while (low < high) {
			mid = (low + high) / 2 + 1;

			if (snaps.get(mid).getSnap() < snap) {
				low = mid;
			} else if (snaps.get(mid).getSnap() > snap) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return low;
	}

	class Snapshot {
		int snap;
		int value;

		Snapshot (int snap, int value) {
			this.snap = snap;
			this.value = value;
		}

		int getSnap () {
			return snap;
		}

		void setSnap (int val) {
			snap = val;
		}

		int getValue () {
			return value;
		}

		void setValue (int val) {
			value = val;
		}
	}
}

class S1146 {
	public static void main (String[] args) {
		// SnapshotArray snapshotArray = new SnapshotArray(1);
		// snapshotArray.set(0, 15);
		// snapshotArray.snap();
		// snapshotArray.snap();
		// snapshotArray.snap();
		// snapshotArray.get(0, 2);

		// SnapshotArray snapshotArray = new SnapshotArray(4);
		// snapshotArray.snap();
		// snapshotArray.snap();
		// snapshotArray.get(3, 1);
		// snapshotArray.set(2, 4);
		// snapshotArray.snap();
		// snapshotArray.set(1, 4);

		SnapshotArray snapshotArray = new SnapshotArray(3);
		snapshotArray.set(1, 6);
		snapshotArray.snap();
		snapshotArray.snap();
		snapshotArray.set(1, 19);
		snapshotArray.set(0, 4);
		snapshotArray.get(2, 1);
		snapshotArray.get(2, 0);
		snapshotArray.get(0, 1);

		// SnapshotArray snapshotArray = new SnapshotArray(3);
		// snapshotArray.set(1, 14);
		// snapshotArray.snap();
		// snapshotArray.snap();
		// snapshotArray.snap();
		// snapshotArray.set(0, 14);
		// snapshotArray.snap();
		// snapshotArray.snap();
		// snapshotArray.set(2, 0);
		// snapshotArray.set(0, 5);
		// snapshotArray.get(0, 3);
		// snapshotArray.snap();
		// snapshotArray.snap();

		// SnapshotArray snapshotArray = new SnapshotArray(2);
		// snapshotArray.set(0, 8);
		// snapshotArray.snap();
		// snapshotArray.set(0, 9);
		// snapshotArray.snap();
		// snapshotArray.snap();
		// snapshotArray.set(0, 11);
		// snapshotArray.snap();
		// snapshotArray.get(1, 1);
		// snapshotArray.snap();
		// snapshotArray.snap();
		// snapshotArray.set(0, 1);
		// snapshotArray.snap();
		// snapshotArray.get(0, 1);
		// snapshotArray.set(0, 0);
		// snapshotArray.snap();
		// snapshotArray.set(0, 3);
		// snapshotArray.set(1, 13);

		// SnapshotArray snapshotArray = new SnapshotArray(1);
		// snapshotArray.set(0, 1);
		// snapshotArray.set(0, 2);
		// snapshotArray.snap();
		// snapshotArray.snap();
		// snapshotArray.get(0, 0);
		// snapshotArray.get(0, 0);
		// snapshotArray.snap();
	}
}

/**
 * Your SnapshotArray object will be instantiated and called as such: SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val); int param_2 = obj.snap(); int param_3 = obj.get(index,snap_id);
 */