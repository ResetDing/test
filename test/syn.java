class syn{//PV操作类

    int count=0;//信号量

    syn(){}

    syn(int a){count=a;}

    public synchronized void Wait(){ //关键字 synchronized 保证了此操作是一条【原语】

        count--;

        if(count<0){//等于0 ：有一个进程进入了临界区

            try {         //小于0：abs(count)=阻塞的进程数目

                this.wait();

            } catch (InterruptedException e) {

                e.printStackTrace();  

            }  

        }  

    }  

    public synchronized void Signal(){   //关键字 synchronized 保证了此操作是一条【原语】

        count++;

        if(count<=0){//如果有进程阻塞

            this.notify();//All

        }

    }  

}