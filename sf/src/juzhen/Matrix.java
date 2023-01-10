package juzhen;

public class Matrix {
    //����ֵ����
    private int[][] m;
    //���ŶϿ�λ������
    private int[][] s;
    //��������
    private int[] p;

    public Matrix(){
        p=new int[]{30, 35, 15, 5, 5, 10, 20, 25};
        m=new int[6][6];
        s=new int[6][6];
    }
    public Matrix(int n){
        this.p = randomCreateMatrix(n + 1);
        this.m = new int[n][n];
        this.s = new int[n][n];
    }

    /**
     * ����������˾���
     * @param n
     */
    public int [] randomCreateMatrix(int n){
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*89+10);//10-99
        }
        return arr;
    }

    /**
     * ����
     */
    public int MatrixDAR(int startIndex, int endIndex){
        if(startIndex == endIndex)
            return 0;
        m[startIndex][endIndex] = MatrixDAR(startIndex, startIndex) + MatrixDAR(startIndex+1, endIndex) + p[startIndex] * p[startIndex + 1] * p[endIndex + 1];
        s[startIndex][endIndex] = startIndex;
        for(int k = startIndex + 1; k < endIndex; k++){
            int t = MatrixDAR(startIndex, k) + MatrixDAR(k+1, endIndex) + p[startIndex] * p[k+1] * p[endIndex + 1];
            if(t < m[startIndex][endIndex]){
                m[startIndex][endIndex] = t;
                s[startIndex][endIndex] = k;
            }
        }
        return m[startIndex][endIndex];
    }


    /**
     * ����¼����
     * @return
     */
    public int memorizedMatrixChain(){
        int n = m.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++)
                m[i][j] = 0;
        }
        return lookUpChain(0, n-1);
    }



    public int lookUpChain(int startIndex, int endIndex){
        if(m[startIndex][endIndex] != 0)
            return m[startIndex][endIndex];
        if(startIndex == endIndex)
            return 0;
        m[startIndex][endIndex] = lookUpChain(startIndex, startIndex) + lookUpChain(startIndex+1, endIndex) + p[startIndex] * p[startIndex + 1] * p[endIndex + 1];
        s[startIndex][endIndex] = startIndex;
        for(int k = startIndex + 1; k < endIndex; k++){
            int t = lookUpChain(startIndex, k) + lookUpChain(k+1, endIndex) + p[startIndex] * p[k+1] * p[endIndex + 1];
            if(t < m[startIndex][endIndex]){
                m[startIndex][endIndex] = t;
                s[startIndex][endIndex] = k;
            }
        }
        return m[startIndex][endIndex];
    }


    /**
     * ��̬�滮
     */
    public void MatrixChain(){
        int n = m.length;
        for(int i = 0; i < n; i++)
            m[i][i] = 0;
        for(int r = 2; r <= n; r++){
            for(int i = 0; i <= n - r; i++){
                int j = i + r - 1;
                m[i][j] = m[i+1][j] + p[i] * p[i+1] * p[j+1];
                s[i][j] = i;
                for(int k = i + 1; k < j; k++){
                    int t = m[i][k] + m[k+1][j] + p[i] * p[k+1] * p[j];
                    if(t < m[i][j]){
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }

    }

    //����(�������)
    public void traceback(int startIndex, int endIndex){
        if(startIndex < endIndex){
            System.out.println("(");
            traceback(startIndex, s[startIndex][endIndex]);
            traceback(s[startIndex][endIndex] + 1, endIndex);
            System.out.println(")");
            System.out.print("Multipy A" + startIndex + "," + s[startIndex][endIndex]);
            System.out.println(" and A" + (s[startIndex][endIndex] + 1) + "," + endIndex);
        }

    }

    //����(���)
    public void tracebackResult(int startIndex, int endIndex){
        if(startIndex == endIndex){
            System.out.print("A" + startIndex);
        }else {
            System.out.print("(");
            tracebackResult(startIndex, s[startIndex][endIndex]);
            tracebackResult(s[startIndex][endIndex] + 1, endIndex);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        System.out.println("�����µľ�������");
        Matrix matrix = new Matrix(1024);
        /*ִ�ж�̬�滮����*/
        long t1 = System.currentTimeMillis();
        matrix.MatrixChain();
        long t2 = System.currentTimeMillis();
        /*��ӡ���*/
//        matrix.traceback(0,1023);
//        matrix.tracebackResult(0,1023);

        /*ִ�ж�̬�滮����¼����*/
//        long t3 = System.currentTimeMillis();
//        matrix.memorizedMatrixChain();
//        long t4 = System.currentTimeMillis();

        /*ִ�з��η���*/
//        long t5 = System.currentTimeMillis();
//        matrix.MatrixDAR(0,99);
//        long t6 = System.currentTimeMillis();
        System.out.println("\n���ھ�������\n����ʱ��Ϊ:" + (t2 - t1) + "ms");
    }
}