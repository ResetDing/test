class Producer implements Runnable{

    int ID=0;

    Producer(){}

    Producer(int id){ID=id;}

    public void run(){

        while(Global.pCount<20){

            Global.empty.Wait();

            Global.pMutex.Wait();

            //�ٽ���

            int index=Global.pCount%8;

            Global.buffer[index]=Global.pCount;

            System.out.println("������"+ID+"�ڻ�����"+index+"����������Ʒ"+Global.pCount);

            Global.pCount++;

            try {

                Thread.sleep(10);

            } catch (InterruptedException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }

            // end of �ٽ���

            Global.pMutex.Signal();

            Global.full.Signal();

        }

    }

}