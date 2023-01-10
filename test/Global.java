class Global{

    static syn empty=new syn(8);

    static syn full=new syn(0);

    static syn pMutex=new syn(1);//保证生产者之间互斥

    static syn cMutex=new syn(1);//保证消费者之间互斥

    static int buffer []=new int[8];//缓冲区

    static int pCount=0;

    static int cCount=0;

}