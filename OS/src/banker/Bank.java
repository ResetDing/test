package banker;

import java.util.Scanner;


public class Bank {

// private Sources sysSources = new Sources(10, 5, 7);

private Sources allSources = new Sources(3, 3, 2);// TODO

 

// ��Դ�����һ��������Դ;

class Sources {

private int A;

private int B;

private int C;

 

public Sources(int B, int A, int C) {

super();

this.B = B;

this.A = A;

this.C = C;

}

public Sources(Sources sources) {

super();

this.B = sources.getB();

this.A = sources.getA();

this.C = sources.getC();

}

public int getB() {

return B;

}

 

public void setB(int B) {

this.B = B;

}

 

public int getA() {

return A;

}

 

public void setA(int A) {

this.A = A;

}

 

public int getC() {

return C;

}

 

public void setC(int C) {

this.C = C;

}

}

 

// ������,������ʹ������ڴ�,��ǰ�ѷ����ڴ�,����Ҫ�����ڴ�

class Processor {

private String name;

private Sources maxSources;

private Sources allSources;

private Sources needSources;

 

public String getName() {

return name;

}

 

public void setName(String name) {

this.name = name;

}

 

public Sources getMaxSources() {

return maxSources;

}

 

public void setMaxSources(Sources maxSources) {

this.maxSources = maxSources;

}

 

public Sources getNeedSources() {

return needSources;

}

 

public void setNeedSources(Sources needSources) {

this.needSources = needSources;

}

 

public Sources getAllSources() {

return allSources;

}

 

public void setAllSources(Sources allSources) {

this.allSources = allSources;

}

 

}

 

// ��ʾ��ǰϵͳ�͸������̵���Դʹ�����

public void showdata(Processor[] processors) {

// ��ʾ��ǰ������Դ

System.out.print("��ǰϵͳ�ɷ�����ԴΪ:");

showSources(allSources);

System.out.println("-----------------����״̬-------------");

System.out.println("���̺�      Max    Allocation      Need   ");

System.out.println("     A B C     A B C       A B C");

for (int i = 0; i < processors.length; i++) {

System.out.print(processors[i].getName() + "   "

+ processors[i].getMaxSources().getA() + " "

+ processors[i].getMaxSources().getB() + " "

+ processors[i].getMaxSources().getC() + "     ");

System.out.print(processors[i].getAllSources().getA() + " "

+ processors[i].getAllSources().getB() + " "

+ processors[i].getAllSources().getC() + "       ");

System.out.println(processors[i].getNeedSources().getA() + " "

+ processors[i].getNeedSources().getB() + " "

+ processors[i].getNeedSources().getC() + " ");

}

System.out.println("-----------------------------------");

}

 

// ��ʾ��Դ������

public void showSources(Sources sources) {

System.out.println("A:" + sources.getA() + " B:" + sources.getB()

+ " C:" + sources.getC());

}

 

public boolean assign(Processor[] processors, int requestNum, Sources req) {

Processor pro = processors[requestNum];

if (!(req.getA() <= pro.getNeedSources().getA()

&& req.getB() <= pro.getNeedSources().getB() && req.getC() <= pro

.getNeedSources().getC())) {

System.out.println("�������Դ������������Ҫ�����ֵ���������");

return false;

}

if (!(req.getA() <= allSources.getA()

&& req.getB() <= allSources.getB() && req.getC() <= allSources

.getC())) {

System.out.println("�����㹻��Դ���䣬����ȴ�");

return false;

}

// ������Դ

allSources.setA(allSources.getA() - req.getA());

allSources.setB(allSources.getB() - req.getB());

allSources.setC(allSources.getC() - req.getC());

pro.getAllSources().setA(pro.getAllSources().getA() + req.getA());

pro.getAllSources().setB(pro.getAllSources().getB() + req.getB());

pro.getAllSources().setC(pro.getAllSources().getC() + req.getC());

pro.getNeedSources().setA(pro.getNeedSources().getA() - req.getA());

pro.getNeedSources().setB(pro.getNeedSources().getB() - req.getB());

pro.getNeedSources().setC(pro.getNeedSources().getC() - req.getC());

boolean flag = checkSafeQueue(processors, allSources);// ���а�ȫ�Լ�鲢�����Ƿ�ȫ

if (flag == true) {

System.out.println("�ܹ���ȫ����");

return true;

} else {

System.out.println("���ܹ���ȫ����");

return false;

}

}

 

public boolean checkSafeQueue(Processor[] pros, Sources all) {

Sources temp = new Sources(all);


boolean assigned[] = new boolean[5];

int i = 0;

while (i < 5) {

if (!assigned[i] && temp.getA() >= pros[i].getNeedSources().getA()

&& temp.getB() >= pros[i].getNeedSources().getB()

&& temp.getC() >= pros[i].getNeedSources().getC()) {

temp.setA(temp.getA() + pros[i].getAllSources().getA());

temp.setB(temp.getB() + pros[i].getAllSources().getB());

temp.setC(temp.getC() + pros[i].getAllSources().getC());

System.out.println("����ɹ�����:" + pros[i].getName());

assigned[i] = true;

i = 0;

} else {

i++;

}

}

for (i = 0; i < 5; i++) {

if (assigned[i] == false)

return false;

}

return true;

}

 

public void test() {

int processNum = 5;

// ��ʼ����������

Sources[] all = new Sources[processNum];

Sources[] max = new Sources[processNum];

Sources[] need = new Sources[processNum];

int[][] allData = { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 2 }, { 2, 1, 1 },

{ 0, 0, 2 } };

int[][] maxData = { { 7, 5, 3 }, { 3, 2, 2 }, { 9, 0, 2 }, { 2, 2, 2 },

{ 4, 3, 3 } };

int[][] needData = { { 7, 4, 3 }, { 1, 2, 2 }, { 6, 0, 0 },

{ 0, 1, 1 }, { 4, 3, 1 } };

for (int i = 0; i < processNum; i++) {

all[i] = new Sources(allData[i][0], allData[i][1], allData[i][2]);

max[i] = new Sources(maxData[i][0], maxData[i][1], maxData[i][2]);

need[i] = new Sources(needData[i][0], needData[i][1],

needData[i][2]);

}

 

Processor[] processors = new Processor[processNum];

for (int i = 0; i < processors.length; i++) {

processors[i] = new Processor();

processors[i].setName("P" + i);

processors[i].setMaxSources(max[i]);

processors[i].setAllSources(all[i]);

processors[i].setNeedSources(need[i]);

}

showdata(processors);

 

Scanner s = new Scanner(System.in);

int requestNum = 0;

int[] input = { 0, 0, 0 };

Sources requestSources = new Sources(0, 0, 0);

while (true)// ѭ�����з���

{

System.out.println("������Ҫ����Ľ��̺ţ�0--4����");

requestNum = s.nextInt();

System.out.println("�������������Դ��Ŀ:");

for (int i = 0; i < 3; i++) {

input[i] = s.nextInt();

}

requestSources.setA(input[0]);

requestSources.setB(input[1]);

requestSources.setC(input[2]);

assign(processors, requestNum, requestSources);

showdata(processors);

}

}

 

public static void main(String[] args) {

new Bank().test();

}

}