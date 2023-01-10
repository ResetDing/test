package sf;


public class One {
	int tile=1;//表示L型骨牌的编号
	int[][] board = new int[8][8];//表示棋盘
	public void chessBoard(int tr,int tc,int dr,int dc,int size) {
		if(size==1)
			return;
		int t=tile++;
		int s=size/2;
		if(dr<tr+s&&dc<tc+s) {
			chessBoard(tr, tc, dr, dc, s);
		}else {
			board[tr+s-1][tc+s-1]=t;
			chessBoard(tr, tc, tr+s-1, tc+s-1, s);
		}
		if(dr<tr+s&&dc>=tc+s) {
			chessBoard(tr, tc+s, dr, dc, s);
		}else {
			board[tr+s-1][tc+s]=t;
			chessBoard(tr, tc+s, tr+s-1, tc+s, s);
		}
		if(dr>=tr+s&&dc<tc+s) {
			chessBoard(tr+s, tc, dr, dc, s);
		}else {
			board[tr+s][tc+s-1]=t;
			chessBoard(tr+s, tc, tr+s, tc+s-1, s);
		}
		if(dr>=tr+s&&dc>=tc+s) {
			chessBoard(tr+s, tc+s, dr, dc, s);
		}else {
			board[tr+s][tc+s]=t;
			chessBoard(tr+s,  tc+s, tr+s, tc+s, s);
		}
}

public static void main(String[] args){
	System.out.println("丁丽媛的棋盘覆盖程序：");
	One o = new One();
	o.chessBoard(0,0,1,0,8);
	for(int i = 0; i <8; i++){	
		for(int j = 0; j <8; j++) {
			if(o.board[i][j]>=10)
				System.out.print(o.board[i][j]+"  ");
			if(o.board[i][j]<10)
				System.out.print("0"+o.board[i][j]+"  ");
		}
		   
	System.out.println();
	}
}
}