package maoda;

public class wanshu
{
	public static boolean isWanShu(int a){
        int cup = 0;
        for(int i=1; i<a; i++){
            if(a%i == 0)
                cup = cup + i;
        }
        return (cup == a);
    }
    
    public static void main(String[] args) {
        for(int i=1; i<1000; i++){
            if(isWanShu(i)){
                System.out.print(i + ",");
            }
        }
    }
}
