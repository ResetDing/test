package hfm;


public class HuffmenNode implements Comparable<HuffmenNode> {
    //�洢���ַ�(��Byte����byte��ԭ���ǣ������´����Ľڵ���û���ַ��ģ���data����Ϊnull)
    Byte data;
    //Ȩ��(��¼���ֵĴ���)
    int weight;
 
    HuffmenNode leftNode;
    HuffmenNode rightNode;
 
    public HuffmenNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }
 
    @Override
    public String toString() {
        return "HuffmenNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
 
    @Override
    public int compareTo(HuffmenNode o) {
        return o.weight - this.weight;
    }
}