class syn{//PV������

    int count=0;//�ź���

    syn(){}

    syn(int a){count=a;}

    public synchronized void Wait(){ //�ؼ��� synchronized ��֤�˴˲�����һ����ԭ�

        count--;

        if(count<0){//����0 ����һ�����̽������ٽ���

            try {         //С��0��abs(count)=�����Ľ�����Ŀ

                this.wait();

            } catch (InterruptedException e) {

                e.printStackTrace();  

            }  

        }  

    }  

    public synchronized void Signal(){   //�ؼ��� synchronized ��֤�˴˲�����һ����ԭ�

        count++;

        if(count<=0){//����н�������

            this.notify();//All

        }

    }  

}