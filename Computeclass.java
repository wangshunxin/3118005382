package xiangsidu;
public class Computeclass {
    /*
     * �������ƶ�
     * */
    public static double SimilarDegree(String strA, String strB){
        String newStrA = removeSign(strA);
        String newStrB = removeSign(strB);
        //�ýϴ���ַ���������Ϊ��ĸ�������Ӵ���Ϊ���Ӽ�����ִ����ƶ�
        int temp = Math.max(newStrA.length(), newStrB.length());
        int temp2 = longestCommonSubstring(newStrA, newStrB);
        return temp2 * 1.0 / temp;
    }
    /*
     * ���ַ�����������������д��һ��
     * */
    public static String removeSign(String str) {
        StringBuffer sb = new StringBuffer();
        //�����ַ���str,����Ǻ������ֻ���ĸ����׷�ӵ�ab����
        for (char item : str.toCharArray())
            if (charReg(item)){
                sb.append(item);
            }
        return sb.toString();
    }
    /*
     * �ж��ַ��Ƿ�Ϊ���֣����ֺ���ĸ��
     * ��Ϊ�Է��Ž������ƶȱȽ�û��ʵ�����壬�ʷ��Ų����뿼�Ƿ�Χ��
     * */
    public static boolean charReg(char charValue) {
        return (charValue >= 0x4E00 && charValue <= 0X9FA5) || (charValue >= 'a' && charValue <= 'z')
                || (charValue >= 'A' && charValue <= 'Z')  || (charValue >= '0' && charValue <= '9');
    }


    /*
     * �󹫹��Ӵ������ö�̬�滮�㷨��
     * �䲻Ҫ������õ��ַ����������ַ������������ġ�
     *
     * */
    public static int longestCommonSubstring(String str1, String str2) {
        int length1 = (short) str1.length();
        int length2 = (short) str2.length();
        int[][] result = new int[2][length2 + 1];   //��������,��ʡ�ռ�ֻ������ǰ���������
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    result[i % 2][j] = (short) (result[(i - 1) % 2][j - 1] + 1);
                else
                    result[i % 2][j] = result[(i - 1) % 2][j] > result[i % 2][j - 1] ? result[(i - 1) % 2][j] : result[i % 2][j - 1];
            }
        }
        return result[length1 % 2][length2];
    }
}