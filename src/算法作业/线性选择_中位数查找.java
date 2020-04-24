package �㷨��ҵ;

import java.util.Arrays;

public class ����ѡ��_��λ������ {

	public static int randomizedSelect(int[] a, int L, int R, int k) {

		if (L == R)

			return a[L];

		// ��ȡΪ��׼�����Ԫ�ص��±�

		int i = randomizedPartition(a, L, R);

		// jΪ���ֺ������е���׼��������׼����Ԫ�ظ���

		int j = i - L + 1;

		if (k < j)// ���kС��j��˵���ڻ�׼i�����

			return randomizedSelect(a, L, i - 1, k);

		else if (k == j)//

			return a[i];

		else// k����j ˵����i���ұ�����

			return randomizedSelect(a, i + 1, R, k - j);

	}

	public static int randomizedPartition(int[] a, int L, int R) {

		// ��ȡL---R�������

		int i = L + (int) (Math.random() * (R - L + 1));

		// �����������

		swap(a, L, i);

		int pivot = a[L];

		while (L < R) {

			while (L < R && a[R] >= pivot)

				R--;

			if (L < R)

				a[L++] = a[R];

			while (L < R && a[L] <= pivot)

				L++;

			if (L < R)

				a[R--] = a[L];

		}

		a[L] = pivot;

		return L;

	}

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];

		arr[i] = arr[j];

		arr[j] = temp;

	}

	public static int select(int[] a, int l, int r, int k) {

		if (r - l < 75) {

			insertSort(a, l, r); // �ò��������������

			return a[l + k - 1];

		}

		int group = (r - l + 5) / 5;

		for (int i = 0; i < group; i++) {

			int left = l + 5 * i;

			int right = (l + i * 5 + 4) > r ? r : l + i * 5 + 4; // ��������ұ߽�����ұ߽縳ֵ

			int mid = (left + right) / 2;

			insertSort(a, left, right);

			swap(a, l + i, mid); // ��������λ����ǰi��

		}

		int pivot = select(a, l, l + group - 1, (group + 1) / 2); // �ҳ���λ������λ��

		int p = partition(a, l, r, pivot); // ����λ������λ����Ϊ��׼��λ��

		int j = p - l + 1; // leftNum������¼��׼λ�õ�ǰ�ߵ�Ԫ�ظ���

		if (k == j)

			return a[p];

		else if (k < j)

			return select(a, l, p - 1, k);

		else // ��k�ڻ�׼λ�ӵĺ�ߣ���Ҫ�ӻ�׼λ�õĺ�����𣬼��ڣ�k - leftNum - 1����

			return select(a, p + 1, r, k - j - 1);

	}

	// ����������ʱ��ѡ���partition����

	public static int partition(int[] a, int l, int r, int pivot) {

		int i = l;

		int j = r;

		while (true) {

			while (a[i] <= pivot && i < r)

				++i; // iһֱ����ƶ���ֱ������a[i]>pivot

			while (a[j] > pivot)

				--j; // jһֱ��ǰ�ƶ���ֱ������a[j]<pivot

			if (i >= j)
				break;

			swap(a, i, j);

		}

		a[l] = a[j];

		a[j] = pivot;

		return j;

	}

	// ��������

	public static void insertSort(int[] a, int law, int high) {

		for (int i = law + 1; i <= high; i++) {

			int key = a[i];

			int j = i - 1;

			while (j >= law && a[j] > key) {

				a[j + 1] = a[j];

				j--;

			}

			a[j + 1] = key;

		}

	}

	public static void main(String[] args) {

		int[] a = { 1, 58, 8, 3, 4, 8, 13, 86, 32 };

		System.out.println(select(a, 0, a.length - 1, 8));

	}

}
