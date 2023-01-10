package hfm;

import java.io.*;
import java.util.*;

public class HuffmenCodeTest {
	static String end="";
	static String one="";
	static String two="";

    public static void zipFile(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        byte[] srcBytes = new byte[in.available()];
        in.read(srcBytes);
        in.close();
        System.out.println("�ļ�ѹ��ǰ�Ĵ�С��" + srcBytes.length);
        //ʹ�ù�����ѹ��
        byte[] tarBytes = huffmenZip(srcBytes);
        System.out.println("�ļ�ѹ����Ĵ�С��" + tarBytes.length);
        //����ѹ����
        double before=srcBytes.length;
        double after=tarBytes.length;
        System.out.println("ѹ����"+after/before);
        //����ļ���������ѹ������ֽ����ݣ������������Ĺ��������룬��ʹ�ð�װ��ObjectOutputStream
        //��ѹ������ļ��������ļ��У���ʱ��new.txt��
        OutputStream out = new FileOutputStream(dst);
        //�������Ĺ����������Ӧ���浽hafumenmap��
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\hafumenmap.txt"));  
        out.write(tarBytes);//��ѹ������ֽڶ�����ָ��ѹ���ļ�����ȥ
        oos.writeObject(mapCode);
        oos.close();
        out.close();
        System.out.println(src+"ѹ���ɹ�");
    }
//********************************��ѹ���ִ���*****************************************************
    /**
     * ��ѹ�ļ�
     *
     * @param zipPath
     * @param newPath
     */
    public static void decodeZip(String zipPath, String newPath) throws IOException, ClassNotFoundException {
        InputStream in = new FileInputStream(zipPath);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Lenovo\\Desktop\\hafumenmap.txt"));
        //��ȡbyte����
        byte[] filedatas = new byte[in.available()];
        int len;
        int i=0;
        while((len=in.read())!=-1) {
        	filedatas[i]=(byte)len;
        	i++;
        }
        //��ȡ�����������
        Map<Byte, String> mapCode = (Map<Byte, String>) ois.readObject();
        System.out.println("�����������"+mapCode);
        //����
        byte[] source = decodeByHuffmen(filedatas, mapCode);
        //byte[]������ļ�
        OutputStream out = new FileOutputStream(newPath);
        out.write(source);
        ois.close();
        out.close();
        System.out.println("�ɹ���ѹ��"+newPath);
    }
    /**
     * ʹ�úշ��������ѹ
     */
    private static byte[] decodeByHuffmen(byte[] tar, Map<Byte, String> huffmenCode) {
        StringBuffer sb = new StringBuffer();
        //��byte[]תΪ�������ַ���
        for (int i = 0; i < tar.length; i++) {
            if (i == tar.length - 1) {
                sb.append(end); //��ɨ�赽���һ���ֽڵ�ʱ���أ��ȼ����⣬ֱ�Ӽ�������֮ǰ�Ĺ������룬���������⴦��
            } else {
            	//�������һ���ֽ���Ҫ���л����㣬�������ܻ�ȡ����λ���������ǰ����0.��ֻ�ܻ�ȡ����ģ����ܻ�ð�λ��
                sb.append(byteToString(tar[i]));
            }
        }
        two=sb.toString();
        System.out.println("��ѹʱ�����������ֵ��"+sb.toString());
        System.out.println("��ѹǰ������������Ƿ���ͬ"+one.equals(two));
        //�����������������ļ�ֵ�Ի�����������һ����ѯ
        Map<String, Byte> temp = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmenCode.entrySet()) {
            temp.put(entry.getValue(), entry.getKey());
        }
       // System.out.println("������������ֵ�Ի���:" + temp);
        //���ݹ�����������������ַ���ת����ԭ����
        List<Byte> source = getSource(sb.toString(), temp);
//        System.out.println(source);
        //�Ѽ���ת�������
        byte[] byteSource = new byte[source.size()];
        for (int i = 0; i < byteSource.length; i++) {
            byteSource[i] = source.get(i);
        }
        return byteSource;
    }
 
    private static List<Byte> getSource(String codeStr, Map<String, Byte> byteMap) {
        List<Byte> tempList = new ArrayList<>();
        int t=0;
   	 	for (int i = 0; i <= codeStr.length(); i++) {
            if (byteMap.keySet().contains(codeStr.substring(t, i))) {
                tempList.add(byteMap.get(codeStr.substring(t, i)));//ͨ����������õ���Ӧ���ֽ�����Ȼ��浽�ֽ��б� 
                //��δ���ĺ���˼������ҵ�ƥ���֮��ͽ��Ŵ���һλ��ʼѰ��ƥ����
                t=i;
            }
        }
        return tempList;
    }

 //������ȡ��λ����������������ֻ��ú������Ķ�������
    private static String byteToString(byte b) {
        //��8λ����32λ������ �� ���㣬��ȡԭ����ֵ�е�8λ
        int temp = b;
        temp |= 256;
        String str = Integer.toBinaryString(temp);
        //����temp=3�������ת���������11��ת������ַ���Ϊ00000011��
        return str.substring(str.length() - 8);
    }
    
 //***************************************ѹ�����ִ���********************************   
    
 //ѹ�����ܺͲ���
    private static byte[] huffmenZip(byte[] bytes) {
        //�Ƚ�ÿ��byteԪ���Լ����ֵĴ�����װ��HuffmanNode�ڵ㣬����ڵ��б�
        List<HuffmenNode> nodeList = getNodeList(bytes);

        //�����ִ����Ĵ�С����(�Ӵ�С)
        Collections.sort(nodeList);

        //������������
        HuffmenNode rootNode = createHuffmenTree(nodeList);

        //���������������
        Map<Byte, String> byteStringMap = createHuffmenCode(rootNode);

        //���չ�����������ԭbytes���б���
        byte[] targetBytes = encodeByHuffmenCode(bytes, byteStringMap);
        return targetBytes;
    }
 
    /**
     * ����ѹ��
     * ���ݹ�����������ԭbytes���б���
     *
     * @param bytes          ԭbytes����
     * @param huffmenCodeMap �����������
     * @return
     */
    private static byte[] encodeByHuffmenCode(byte[] bytes, Map<Byte, String> huffmenCodeMap) {
        //��bytesת���ɶ������ַ���
        StringBuffer sb = new StringBuffer();
        //�������е�ԭʼ�ֽڣ�Ȼ��ȡ������������ƥ��ȥ��Ȼ�󻻳ɹ������������ַ������棨ע������������Ǳ����ϵĶ����Ƶ���ʽ��
        for (byte b : bytes) {
            String str = huffmenCodeMap.get(b);
            sb.append(str);
        }
        one=sb.toString();
        System.out.println("ѹ��ʱ�����������ֵ��"+sb);
        int len = sb.length();
        //�ѹ���������˸���Ϊһ��byte
        int newLenght = (len % 8 == 0) ? (len / 8) : (len / 8 + 1);
        byte[] targetBytes = new byte[newLenght];
        for (int i = 0; i < targetBytes.length; i++) {
            if ((i + 1) * 8 > len) {//�������*8�����˾ͻ�������⣬�����޷�ȷ��ǰ���м����㣬����ֱ�Ӽ�¼����ι�������
            	end=sb.substring(i * 8);
                targetBytes[i] = (byte) Integer.parseInt(sb.substring(i * 8), 2);//��������Ƕ�����������ת���ɶ�Ӧʮ�������֣����ʮ�����Ǹ�ascll��
            } else {				//�������*8С���˹���������ĳ��Ⱦ�ֱ�Ӵ��Ǹ�λ�������8λ��Ϊһ��byte����i
            	if((i + 1) * 8 == len) {//������ڵĻ�������end�����������һ��
            		end=sb.substring(i*8);
            	}else {
                    targetBytes[i] = (byte) Integer.parseInt(sb.substring(i * 8, (i + 1) * 8), 2);
            	}
            }
        }
     
        return targetBytes;
    }

    //��ʱ�洢�����
    static Map<Byte, String> mapCode = new HashMap();
 
    private static Map<Byte, String> createHuffmenCode(HuffmenNode rootNode) {
        StringBuffer sb = new StringBuffer();
        if (rootNode != null) {
            getCodes(rootNode.leftNode, "0", sb);
            getCodes(rootNode.rightNode, "1", sb);
            return mapCode;  //�������hashmap
        }
        return null;
    }
 
    private static void getCodes(HuffmenNode node, String s, StringBuffer sb) {
        StringBuffer tempSb = new StringBuffer(sb);
        tempSb.append(s);
        if (node.data == null) {
            getCodes(node.leftNode, "0", tempSb);//�ݹ鰡�ݹ�
            getCodes(node.rightNode, "1", tempSb);
        } else {
            mapCode.put(node.data, tempSb.toString()); //�ڴ����������ֽڵĹ���������
        }
    }
 
 
    /**
     * ������������
     *
     * @param nodeList
     */
    private static HuffmenNode createHuffmenTree(List<HuffmenNode> nodeList) {
        int length = nodeList.size();

        while (length > 1) { //ֱ��һ����ʱ��ֹͣ
            HuffmenNode huffmenNode01 = nodeList.get(length - 1);//����С�ĸ���
            HuffmenNode huffmenNode02 = nodeList.get(length - 2);//�ڶ�С�ĸ���
            //���ݹ��������Ĵ���ԭ��Ҫ����һ��emmȨֵΪ��С�ڵ�Ȩֵ�ĺ͵Ŀսڵ�ŵ���������ȥ
            HuffmenNode huffmenNodeNew = new HuffmenNode(null, huffmenNode01.weight + huffmenNode02.weight);
            huffmenNodeNew.leftNode = huffmenNode01;//��С�ķ������
            huffmenNodeNew.rightNode = huffmenNode02;
            nodeList.remove(huffmenNode01);//ɾ���ɵ�
            nodeList.remove(huffmenNode02);
            nodeList.add(huffmenNodeNew);//�����µ�
            Collections.sort(nodeList);//��������
            length = nodeList.size();//���³���
        }
        return nodeList.get(0);//���ظ��ڵ㣬���������Ǹ�����Ϊ�����ǴӴ�С����
    }
 
    /**
     * ��bytes���е�Ԫ���Լ����ִ�����װ��HuffmanNode�б�
     *
     * @param bytes
     * @return
     */
    private static List<HuffmenNode> getNodeList(byte[] bytes) {
        List<HuffmenNode> nodeList = new ArrayList<>();  //����һ���ڵ����͵ļ���
        Map<Byte, Integer> byteIntegerMap = new HashMap<>();//����һ��hashmap
        for (byte b : bytes) {
            Integer count = byteIntegerMap.get(b); //�����ֽ����飬�ж�map��û��������ֽ�Ϊ���ļ�ֵ�ԣ���û���򴴽��������һ
            if (count == null) {
                byteIntegerMap.put(b, 1);
            } else {
                byteIntegerMap.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> item : byteIntegerMap.entrySet()) {//����hashmap����ȡ����Ȩֵ�������������ڵ�
            Byte b = item.getKey();
            Integer weigth = item.getValue();
            HuffmenNode node = new HuffmenNode(b, weigth);
            nodeList.add(node);//��ӹ������ڵ�
        }
        return nodeList; //���ع������ڵ��ֵ
    }
 
}