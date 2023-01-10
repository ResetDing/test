package Dijkstra;
import java.util.PriorityQueue;

public class GrfDijkstra {
	// Ϊ�˾���������ֱ�ۺÿ�һЩ��������Լ����·��Ȩֵȡֵ��ΧΪ��[1,10]��ȨֵΪ999��ʾ����ͨ
	// ����������Ȩֵ�ĺ�С��999
	
	private final int MAX = 999;
	// ��������
	private int total;
	// ������Ϣ
	private String[] nodes;
	// �������
	private int[][] matirx;
	// Դ�㵽������ľ���
	private int[] dis;
	// �����Ƿ��ѱ��
	private int[] mark;

	public GrfDijkstra(int total, String[] nodes) {
		this.total = total;
		this.nodes = nodes;
		this.matirx = new int[total][total];
		this.dis = new int[total];
		this.mark = new int[total];
	}

	private void printMatrix() {
		System.out.println("--------- weighted directed matrix ---------");
		System.out.println("---0---1---2---3---4---5---6---7---8---");
		System.out.println("---A---B---C---D---E---F---G---H---I---");
		for (int i = 0; i < this.total; i++) {
			System.out.print("-" + this.nodes[i] + "|");
			for (int j = 0; j < this.total; j++) {
				System.out.print(String.format("%03d", this.matirx[i][j]) + "-");
			}
			System.out.print("\n");
		}
		System.out.println("--------- weighted directed matrix ---------");
	}

	/**
	 * Dijkstra�㷨-(�Ͻ�˹����)�㷨֮����ʵ��
	 * 
	 * @param s Դ��(���)
	 */
	public void dijkstra(int s) {
		// ��ʼ��
		for (int i = 0; i < this.total; i++) {
			// ��ʼ����δ���
			this.mark[i] = 0;
			// ��Դ���ֱ���ڽӵ���ϳ�ʼȨֵ
			this.dis[i] = this.matirx[s][i];
		}

		// ��Դ��s�����ѱ��
		this.mark[s] = 1;
		// ���㵽����ľ���Ϊ0
		this.dis[s] = 0;
		// ��ʱ��̾���
		int min = -1;
		// ��ʱ��̾���Ķ���
		int k = -1;

		this.printDis(0, "JIN", "��ʼ��");

		// ��ȥԴ��s������ľ���Ϊ0�⣬��Ҫ���ϵĽ��о�������(Դ��s����������(��total-1��)����̾���)
		for (int i = 1; i < this.total; i++) {
			// �ӵ�ǰ���µģ�Դ�㵽����������ľ�����Ϣ����dis[]�У��ҵ�һ��û�б�ǹ��ģ�
			// ���Ҿ���(��Դ�㵽��ĳ����)��̵Ķ���
			min = MAX;
			for (int j = 0; j < this.total; j++) {
				if (this.mark[j] == 0 && this.dis[j] < min) {
					min = this.dis[j];
					k = j;
				}
			}

			// ��Ǹö���
			this.mark[k] = 1;

			/**
			 * ����У��<br/>
			 */
			for (int j = 0; j < this.total; j++) {
				if (this.mark[j] == 0 && (this.matirx[k][j] + this.dis[k]) < this.dis[j]) {
					this.dis[j] = this.matirx[k][j] + this.dis[k];
				}
			}

			this.printDis(i, this.nodes[k], "������");
		}
	}

	/**
	 * Dijkstra�㷨-(�Ͻ�˹����)�㷨֮���ȶ���ʵ��
	 */
	public void dijkstraPQ() {
		// Item��PriorityQueue��Ԫ�أ�ʵ����Comparable�ӿڣ����ȶ����ô˽ӿڽ�������
		class Item implements Comparable<Item> {
			// �ڵ���������±�
			public int idx;
			// ���Ľڵ����ʱ��СȨֵ��
			public int weight;

			public Item(int idx, int weight) {
				this.idx = idx;
				this.weight = weight;
			}

			@Override
			public int compareTo(Item item) {
				if (this.weight == item.weight) {
					return 0;
				} else if (this.weight < item.weight) {
					return -1;
				} else {
					return 1;
				}
			}
		}

		// ֵ��С��Ԫ�����������ȶ��е�ͷ����ֵ�ϴ��Ԫ�����������ȶ��е�β��
		PriorityQueue<Item> pq = new PriorityQueue<Item>();

		// ��Դ��(�����)���뵽���ȶ���
		pq.offer(new Item(0, 0));

		Item itm = null;
		while (!pq.isEmpty()) {
			itm = pq.poll();

			// ͼ��ĳ�ڵ��±�
			int idx = itm.idx;
			// ��ĳ�ڵ����ʱ��СȨֵ��
			int weight = itm.weight;

			// �����Ԫ�ػ�δ��ǣ��������СȨֵ��
			if (this.mark[idx] == 0) {
				this.dis[idx] = weight;
			}

			// �ҳ���Ԫ��(����A)������δ��ǵ��ڽӵ�(����B)
			// ��Դ�㵽B�ľ���ɱ�ʾΪ��(Դ�㵽A�ľ���) + (A��B�ľ���)
			// ��Դ�㵽B�ľ�����뵽���ȶ�����
			for (int i = 0; i < this.total; i++) {
				if (this.mark[i] == 0) {
					pq.offer(new Item(i, this.dis[idx] + this.matirx[idx][i]));
				}
			}
		}
	}

	private void printDis(int i, String node, String pre) {
		System.out.print("\n" + pre + "," + node + "," + i + "--->");
		for (int t = 0; t < this.dis.length; t++) {
			System.out.print(t + ",");
		}
		System.out.print("\n" + pre + i + "--->");
		for (int t : this.dis) {
			System.out.print(t + ",");
		}
		System.out.print("\n");
	}

	// ��ʼ��ͼ����
	// 0---1---2---3---4---5---6---7---8---
	// A---B---C---D---E---F---G---H---I---
	private void initGrf() {
		// ��ʼ������Ϊ���ֵ(���ڵ㶼����ͨ)
		for (int i = 0; i < this.total; i++) {
			for (int j = 0; j < this.total; j++) {
				if (i == j) {
					this.matirx[i][j] = 0;
				} else {
					this.matirx[i][j] = MAX;
				}
			}
		}

		// �ֶ���������·��
		// A->B, A->E, A->D
		this.matirx[0][1] = 2;
		this.matirx[0][4] = 3;
		this.matirx[0][3] = 1;
		// B->C
		this.matirx[1][2] = 2;
		// C->F
		this.matirx[2][5] = 1;
		// D->E, D->G
		this.matirx[3][4] = 5;
		this.matirx[3][6] = 2;
		// E->F, E->H
		this.matirx[4][5] = 6;
		this.matirx[4][7] = 1;
		// F->I
		this.matirx[5][8] = 3;
		// G->H
		this.matirx[6][7] = 4;
		// H->F, H->I
		this.matirx[7][5] = 1;
		this.matirx[7][8] = 2;
	}

	public static void main(String[] args) {
		System.out.println("�����µĵϽ�˹�����㷨");
		String[] nodes = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
		GrfDijkstra grf = new GrfDijkstra(nodes.length, nodes);
		grf.initGrf();
		grf.printMatrix();

		System.out.println();
		System.out.println("------ Dijkstra�㷨-(�Ͻ�˹����)�㷨֮������ʼ ------");
		grf.dijkstra(0);
		grf.printDis(0, "JIN", "����ֵ");
		System.out.print("\n");
		System.out.println("------ Dijkstra�㷨-(�Ͻ�˹����)�㷨֮�������� ------");

		System.out.println();
		System.out.println("------ Dijkstra�㷨-(�Ͻ�˹����)�㷨֮���ȶ��п�ʼ ------");
		grf.dijkstraPQ();
		grf.printDis(0, "JIN", "����ֵ");
		System.out.print("\n");
		System.out.println("------ Dijkstra�㷨-(�Ͻ�˹����)�㷨֮���ȶ��н��� ------");
	}
}