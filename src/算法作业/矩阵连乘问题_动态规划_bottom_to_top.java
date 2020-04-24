package �㷨��ҵ;

public class ������������_��̬�滮_bottom_to_top {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int[] p = { 1, 2, 3, 4, 5, 6, 7 };
		int n = p.length - 1;
		int m[][] = new int[n + 1][n + 1];
		int s[][] = new int[n + 1][n + 1];
		MatrixChain(m, n, s, p);
		Traceback(s, 1, 2);
	}

	private static void MatrixChain(int m[][], int n, int s[][], int p[]) {
		for (int i = 1; i <= n; i++) {
			m[i][i] = 0;// �Խ����ϵ�ֵ��Ϊ0
		}
		// ���δ�����Ϊ[2:n]�����ֱ���㲻ͬ�����ľ�����������ֵ
		for (int l = 2; l <= n; l++) {
			// ����������Ϊrʱ��i��ȡֵ��Χ
			for (int i = 1; i <= n - l + 1; i++) {
				// j��i�Ĺ�ϵ
				int j = i + l - 1;
				
				// 3����k��[i+1:j-1]��������������ֵ,����֮ǰ�ѱ��������ֵ�Աȣ�ȡС��
				for (int k = i + 1; k < j; k++) {
					int temp = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (temp < m[i][j]) {
						m[i][j] = temp;
						s[i][j] = k;
					}
				}
			}

		}
		System.out.println(m[1][n]);
	}

//ͨ���ݹ�ķ����ҵ��ϵ� ��������
	private static void Traceback(int[][] s, int i, int j) {
		if (i == j) {
			System.out.print("A" + i);
		} else {
			System.out.print("(");
			Traceback(s, i, s[i][j]);
			Traceback(s, s[i][j] + 1, j);
			System.out.print(")");
		}
	}
}
