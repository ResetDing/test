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
        System.out.println("文件压缩前的大小：" + srcBytes.length);
        //使用哈夫曼压缩
        byte[] tarBytes = huffmenZip(srcBytes);
        System.out.println("文件压缩后的大小：" + tarBytes.length);
        //计算压缩率
        double before=srcBytes.length;
        double after=tarBytes.length;
        System.out.println("压缩率"+after/before);
        //输出文件不仅包含压缩后的字节数据，还包含产生的哈夫曼编码，故使用包装类ObjectOutputStream
        //将压缩后的文件放在新文件中，此时是new.txt。
        OutputStream out = new FileOutputStream(dst);
        //将产生的哈夫曼编码对应表保存到hafumenmap中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\hafumenmap.txt"));  
        out.write(tarBytes);//将压缩后的字节都传到指定压缩文件里面去
        oos.writeObject(mapCode);
        oos.close();
        out.close();
        System.out.println(src+"压缩成功");
    }
//********************************解压部分代码*****************************************************
    /**
     * 解压文件
     *
     * @param zipPath
     * @param newPath
     */
    public static void decodeZip(String zipPath, String newPath) throws IOException, ClassNotFoundException {
        InputStream in = new FileInputStream(zipPath);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Lenovo\\Desktop\\hafumenmap.txt"));
        //读取byte数组
        byte[] filedatas = new byte[in.available()];
        int len;
        int i=0;
        while((len=in.read())!=-1) {
        	filedatas[i]=(byte)len;
        	i++;
        }
        //读取哈夫曼编码表
        Map<Byte, String> mapCode = (Map<Byte, String>) ois.readObject();
        System.out.println("哈夫曼编码表："+mapCode);
        //解码
        byte[] source = decodeByHuffmen(filedatas, mapCode);
        //byte[]输出到文件
        OutputStream out = new FileOutputStream(newPath);
        out.write(source);
        ois.close();
        out.close();
        System.out.println("成功解压到"+newPath);
    }
    /**
     * 使用赫夫曼编码解压
     */
    private static byte[] decodeByHuffmen(byte[] tar, Map<Byte, String> huffmenCode) {
        StringBuffer sb = new StringBuffer();
        //将byte[]转为二进制字符串
        for (int i = 0; i < tar.length; i++) {
            if (i == tar.length - 1) {
                sb.append(end); //当扫描到最后一段字节的时候呢，比价特殊，直接加上我们之前的哈夫曼码，不进行特殊处理
            } else {
            	//不是最后一个字节需要进行或运算，这样才能获取到八位，否则如果前面是0.就只能获取后面的，不能获得八位了
                sb.append(byteToString(tar[i]));
            }
        }
        two=sb.toString();
        System.out.println("解压时侯哈夫曼编码值："+sb.toString());
        System.out.println("解压前后哈夫曼编码是否相同"+one.equals(two));
        //将哈夫曼编码表里面的键值对互换，方便下一步查询
        Map<String, Byte> temp = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmenCode.entrySet()) {
            temp.put(entry.getValue(), entry.getKey());
        }
       // System.out.println("哈夫曼编码表键值对互换:" + temp);
        //根据哈夫曼编码表将二进制字符串转换成原数据
        List<Byte> source = getSource(sb.toString(), temp);
//        System.out.println(source);
        //把集合转变成数组
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
                tempList.add(byteMap.get(codeStr.substring(t, i)));//通过哈夫曼码得到对应的字节数，然后存到字节列表 
                //这段代码的核心思想就是找到匹配的之后就接着从下一位开始寻找匹配项
                t=i;
            }
        }
        return tempList;
    }

 //这样获取八位二进制数，而不是只获得后面非零的二进制数
    private static String byteToString(byte b) {
        //将8位扩大到32位，便于 或 运算，提取原来数值中的8位
        int temp = b;
        temp |= 256;
        String str = Integer.toBinaryString(temp);
        //比如temp=3，如果不转换就是输出11，转换后的字符串为00000011；
        return str.substring(str.length() - 8);
    }
    
 //***************************************压缩部分代码********************************   
    
 //压缩的总和步骤
    private static byte[] huffmenZip(byte[] bytes) {
        //先将每个byte元素以及出现的次数包装成HuffmanNode节点，输出节点列表
        List<HuffmenNode> nodeList = getNodeList(bytes);

        //按出现次数的大小排序(从大到小)
        Collections.sort(nodeList);

        //创建哈夫曼树
        HuffmenNode rootNode = createHuffmenTree(nodeList);

        //创建哈夫曼编码表
        Map<Byte, String> byteStringMap = createHuffmenCode(rootNode);

        //按照哈夫曼编码表对原bytes进行编码
        byte[] targetBytes = encodeByHuffmenCode(bytes, byteStringMap);
        return targetBytes;
    }
 
    /**
     * 数据压缩
     * 根据哈夫曼编码表对原bytes进行编码
     *
     * @param bytes          原bytes数据
     * @param huffmenCodeMap 哈夫曼编码表
     * @return
     */
    private static byte[] encodeByHuffmenCode(byte[] bytes, Map<Byte, String> huffmenCodeMap) {
        //将bytes转换成二进制字符串
        StringBuffer sb = new StringBuffer();
        //遍历所有的原始字节，然后取哈夫曼表里面匹配去，然后换成哈夫曼编码存进字符串里面（注意哈夫曼编码是表面上的二进制的形式）
        for (byte b : bytes) {
            String str = huffmenCodeMap.get(b);
            sb.append(str);
        }
        one=sb.toString();
        System.out.println("压缩时候哈夫曼编码值："+sb);
        int len = sb.length();
        //把哈夫曼编码八个作为一个byte
        int newLenght = (len % 8 == 0) ? (len / 8) : (len / 8 + 1);
        byte[] targetBytes = new byte[newLenght];
        for (int i = 0; i < targetBytes.length; i++) {
            if ((i + 1) * 8 > len) {//如果长度*8大于了就会产生问题，我们无法确定前面有几个零，所以直接记录下这段哈弗慢码
            	end=sb.substring(i * 8);
                targetBytes[i] = (byte) Integer.parseInt(sb.substring(i * 8), 2);//声明这个是二进制数，会转换成对应十进制数字，这个十进制是个ascll码
            } else {				//如果长度*8小于了哈夫曼编码的长度就直接从那个位置往后的8位作为一个byte存入i
            	if((i + 1) * 8 == len) {//如果等于的话，就用end保存下来最后一段
            		end=sb.substring(i*8);
            	}else {
                    targetBytes[i] = (byte) Integer.parseInt(sb.substring(i * 8, (i + 1) * 8), 2);
            	}
            }
        }
     
        return targetBytes;
    }

    //临时存储编码表
    static Map<Byte, String> mapCode = new HashMap();
 
    private static Map<Byte, String> createHuffmenCode(HuffmenNode rootNode) {
        StringBuffer sb = new StringBuffer();
        if (rootNode != null) {
            getCodes(rootNode.leftNode, "0", sb);
            getCodes(rootNode.rightNode, "1", sb);
            return mapCode;  //返回这个hashmap
        }
        return null;
    }
 
    private static void getCodes(HuffmenNode node, String s, StringBuffer sb) {
        StringBuffer tempSb = new StringBuffer(sb);
        tempSb.append(s);
        if (node.data == null) {
            getCodes(node.leftNode, "0", tempSb);//递归啊递归
            getCodes(node.rightNode, "1", tempSb);
        } else {
            mapCode.put(node.data, tempSb.toString()); //在此生成所有字节的哈夫曼编码
        }
    }
 
 
    /**
     * 创建哈夫曼树
     *
     * @param nodeList
     */
    private static HuffmenNode createHuffmenTree(List<HuffmenNode> nodeList) {
        int length = nodeList.size();

        while (length > 1) { //直到一个的时候停止
            HuffmenNode huffmenNode01 = nodeList.get(length - 1);//把最小的给他
            HuffmenNode huffmenNode02 = nodeList.get(length - 2);//第二小的给他
            //根据哈夫曼树的创建原则，要创建一个emm权值为俩小节点权值的和的空节点放到集合里面去
            HuffmenNode huffmenNodeNew = new HuffmenNode(null, huffmenNode01.weight + huffmenNode02.weight);
            huffmenNodeNew.leftNode = huffmenNode01;//最小的放左儿子
            huffmenNodeNew.rightNode = huffmenNode02;
            nodeList.remove(huffmenNode01);//删掉旧的
            nodeList.remove(huffmenNode02);
            nodeList.add(huffmenNodeNew);//加入新的
            Collections.sort(nodeList);//重新排序
            length = nodeList.size();//更新长度
        }
        return nodeList.get(0);//返回根节点，就是最大的那个，因为这里是从大到小排序
    }
 
    /**
     * 将bytes的中的元素以及出现次数包装成HuffmanNode列表
     *
     * @param bytes
     * @return
     */
    private static List<HuffmenNode> getNodeList(byte[] bytes) {
        List<HuffmenNode> nodeList = new ArrayList<>();  //定义一个节点类型的集合
        Map<Byte, Integer> byteIntegerMap = new HashMap<>();//创建一个hashmap
        for (byte b : bytes) {
            Integer count = byteIntegerMap.get(b); //遍历字节数组，判断map中没有用这个字节为键的键值对，若没有则创建，有则加一
            if (count == null) {
                byteIntegerMap.put(b, 1);
            } else {
                byteIntegerMap.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> item : byteIntegerMap.entrySet()) {//遍历hashmap，获取键和权值，赋给哈夫曼节点
            Byte b = item.getKey();
            Integer weigth = item.getValue();
            HuffmenNode node = new HuffmenNode(b, weigth);
            nodeList.add(node);//添加哈弗慢节点
        }
        return nodeList; //返回哈夫曼节点的值
    }
 
}