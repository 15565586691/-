package �㷨��ҵ;

public class ������������ {
	
	public static void main(String[] args) {
		//������һ���������ά�ȵ�����
		int []p= {1,2,3,4,5,6,7};
		int n=p.length-1;
		//����һ������ϵ��λ��
		int [][]s=new int[n+1][n+1];
		//��A1...A6���˵���С����
        System.out.println("A1...A6����С������Ϊ"+RecurMatrixChain(1,6,p,s));
        Traceback(s,1,6);
	}

	private static int  RecurMatrixChain(int i, int j, int[] p, int[][] s) {
		// TODO Auto-generated method stub
		if(i==j) {
			return 0;
		}
		//ȡ��һ���Ͽ�λ��ʱ������Ϊ��ʼֵ
		int m=RecurMatrixChain(i, i, p,s)+RecurMatrixChain(i+1, j, p,s)+p[i-1]*
				p[i]*p[j];
		//�ƶϵ�Ϊi
		s[i][j]=i;
		for (int k = i+1; k < j; k++) {
			int temp=RecurMatrixChain(i, k, p,s)+RecurMatrixChain(k+1,j, p,s)+p[i-1]*
					p[k]*p[j];
			//ȡ��С�ļ������͵�ǰ�Ķϵ�λ��k
			if(temp<m) {
				m=temp;
				s[i][j]=k;
			}
			
		}
		return m;
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