class Global{

    static syn empty=new syn(8);

    static syn full=new syn(0);

    static syn pMutex=new syn(1);//��֤������֮�以��

    static syn cMutex=new syn(1);//��֤������֮�以��

    static int buffer []=new int[8];//������

    static int pCount=0;

    static int cCount=0;

}