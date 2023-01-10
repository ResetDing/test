class Producer implements Runnable{

    int ID=0;

    Producer(){}

    Producer(int id){ID=id;}

    public void run(){

        while(Global.pCount<20){

            Global.empty.Wait();

            Global.pMutex.Wait();

            //临界区

            int index=Global.pCount%8;

            Global.buffer[index]=Global.pCount;

            System.out.println("生产者"+ID+"在缓冲区"+index+"中生产了物品"+Global.pCount);

            Global.pCount++;

            try {

                Thread.sleep(10);

            } catch (InterruptedException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }

            // end of 临界区

            Global.pMutex.Signal();

            Global.full.Signal();

        }

    }

}