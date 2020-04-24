package �㷨��ҵ;

public class ����������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "13456778";
		String str2 = "357486782";
		System.out.println("��󹫹�������Ϊ��"+LCS(str1, str2));
	}

	private static String LCS(String str1, String str2) {
		// TODO Auto-generated method stub
		int[][] lcsnum = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {//��Ӧ��ʽ�ڶ������
					lcsnum[i][j] = lcsnum[i - 1][j - 1] + 1;
				} else {//��Ӧ��ʽ�����������
					lcsnum[i][j] = Math.max(lcsnum[i - 1][j], lcsnum[i][j - 1]);
				}
			}
		}
		int i = str1.length();
		int j = str2.length();
		StringBuffer sb = new StringBuffer();
		while (i > 0 && j > 0) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					sb.append(str1.charAt(i-1));
					i--;
					j--;
			}else {
				if(lcsnum[i-1][j]<lcsnum[i][j-1]) {
					j--;
				}else if(lcsnum[i-1][j]>lcsnum[i][j-1]) {
					i--;
				}else {
					i--;
				}
			}
		}
		return sb.reverse().toString();
	}
}