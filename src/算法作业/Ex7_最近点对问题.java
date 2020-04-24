package �㷨��ҵ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex7_���������� {

	public static void main(String[] args) {
		
		Point[] points = new Point[7];
		points[0] = new Point(1, 1);
		points[1] = new Point(1, 9);
		points[2] = new Point(2, 5);
		points[3] = new Point(3, 1);
		points[4] = new Point(4, 4);
		points[5] = new Point(5, 8);
		points[6] = new Point(6, 2);

		// Ԥ��������x���������򣬱��ڷ��η�ʵʩ
		Arrays.sort(points, new Comparator<Point>() {
			
			@Override
			public int compare(Point p1, Point p2) {
		
				return (p1.x > p2.x) ? 1 : (p1.x == p2.x) ? 0 : -1;
			}
		});

		System.out.println(divide(0, points.length - 1, points));
	}

	private static double divide(int left, int right, Point[] points) {
		// ��ǰ��С������룬��ʼֵ����Ϊ�����
		double curMinDis = 1e20;
		// ���ֻ��һ����
		if (left == right) {
			return curMinDis;
		}
		if (left + 1 == right) {
			return distance(points[left], points[right]);
		}
		// ���η�����һ��������������ȡ���ҷ�����С�������
		// ͨ�����������2����������к���Ļ��֣�ʹ���������߱��ִ�����ȸ�����
		int middle = (left + right) >> 1;
		double leftMinDis = divide(left, middle, points);
		double rightMinDis = divide(middle, right, points);
		curMinDis = (leftMinDis < rightMinDis) ? leftMinDis : rightMinDis;
		// ���η��ڶ���������������������ֱ������Ҿ���
		// �ؼ����룬��������������㣬һ��λ���������һ��λ���ұ�����,x��������Χ[middle-curMinDis, middle+curMinDis]
		// ��¼���������ڵĵ�����������ڽ�һ��������С����
		List<Integer> validPointIndex = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (Math.abs(points[middle].x - points[i].x) <= curMinDis) {
				validPointIndex.add(i);
			}
		}
		// ������������һ������������С�������
		for (int i = 0; i < validPointIndex.size() - 1; i++) {
			for (int j = i + 1; j < validPointIndex.size(); j++) {
				// �������������y��������curMinDis�����������
				if (Math.abs(points[validPointIndex.get(i)].y - points[validPointIndex.get(j)].y) > curMinDis) {
					continue;
				}
				double tempDis = distance(points[validPointIndex.get(i)], points[validPointIndex.get(j)]);
				curMinDis = (tempDis < curMinDis) ? tempDis : curMinDis;
			}
		}
		return curMinDis;
	}

	private static double distance(Point p1, Point p2) {
		// TODO Auto-generated method stub
		return Math.sqrt((p2.y - p1.y) * (p2.y - p1.y) + (p2.x - p1.x) * (p2.x - p1.x));
	}

}

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {

		this.x = x;
		this.y = y;
	}

}
