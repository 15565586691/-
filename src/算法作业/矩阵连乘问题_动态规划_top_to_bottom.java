package �㷨��ҵ;

public class ������������_��̬�滮_top_to_bottom {

	public static void main(String[] args) {
		int[] p = { 5,10,15,20 };
		int n = p.length - 1;

		int[][] m = new int[n + 1][n + 1];
		int[][] s = new int[n + 1][n + 1];
		System.out.println("��С������Ϊ"+MatrixChain(1, 3, m, s,p));
		Traceback(s,1,3);
	}



	private static int MatrixChain(int i, int j, int[][] m, int[][] s, int[] p) {
		//�����ά�������Ѿ���������Ҫ�ҵ�ֵ�򷵻�
		if (m[i][j] != 0) {
			return m[i][j];
		} else {
			if (i == j) {
				m[i][j] = 0;
			}
			if (j > i) {
				//ȡ��һ���Ͽ�λ��ʱ������Ϊ��ʼֵ
				m[i][j]=MatrixChain(i, i, m, s,p)+MatrixChain(i+1, j, m, s, p)+p[i-1]*
						p[i]*p[j];
				s[i][j]=i;
                for (int k = i+1; k < j; k++) {
					int t=MatrixChain(i, k, m, s,p)+MatrixChain(k+1, j, m, s, p)+p[i-1]*
							p[k]*p[j];
					if(t<m[i][j]) {
						m[i][j]=t;
						s[i][j]=k;
					}
				}
			}
		}
		return m[i][j];
	}
	private static void Traceback(int[][] s, int i, int j) {
		if(i==j) {
			System.out.print("A"+i);
		}
		else {
        System.out.print("(");
        Traceback(s, i, s[i][j]);
		Traceback(s,s[i][j]+1,j);
		System.out.print(")");
		}
	}

}
