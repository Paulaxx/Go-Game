package gogame;

import java.util.ArrayList;

public class GameLogic implements Logic {

    public int white_score=0,black_score=0,size=9,breath_count=0,breath_count1=-1,breath_count2=-1,breath_count3=-1,breath_count4=-1;
	public String[][] Board = new String[size+2][size+2];
	public String[][] copyBoard = new String[size+2][size+2];
	public String actualColor="black",opponentColor="white",curColor,empty="";
	public ArrayList<String> message = new ArrayList<>();
	
	
	public GameLogic() {

		resetBoard();
	}
	
	
	@Override
	  public void resetBoard() {
		
		for(int i=0;i<size+2;i++) {
			for(int j=0;j<size+2;j++) {
			 
				if(i == 0 || j == 0 || i == size+1 || j == size+1) {
					Board[i][j] = "border";	
				}
				else {
					Board[i][j] = "empty";
				}
			}
		}

	}

	@Override
	  public void showBoard() {
		
		for(int i=0;i<size+2;i++) {
			for(int j=0;j<size+2;j++) {
			 
			System.out.println(Board[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");

	}

	@Override
	 public void changeColor() {
		
			
			if(actualColor == "white") {
				opponentColor = actualColor;
				actualColor = "black";
			}
			else {
				opponentColor = actualColor;
				actualColor = "white";	
			}
		
			
		

	}

	@Override
	public void CopyTheBoard() {
		
		int i,j;
		for(i=0;i<size+2;i++) {
			
			for(j=0;j<size+2;j++) {
				
				copyBoard[i][j]=Board[i][j];
				
			}
			
		}
		
	}
	
    public boolean CanYouInsert(int x,int y) {
		
		breath_count1=-1;
		breath_count2=-1;
		breath_count3=-1;
		breath_count4=-1;
		
		System.out.println(x +" "+ y);
		
		if(Board[x][y].equals("empty")) {
			Board[x][y]="check";
			
			if(HowManyBreaths(x,y) == 0) {	
				if(Board[x + 1][y].equals(opponentColor)) {
					breath_count1=0;
					breath_count1+=ChainBreaths(x+1,y,opponentColor);
					//System.out.println("----  " + breath_count1);	
				}
				if(Board[x - 1][y].equals(opponentColor)) {
					breath_count2=0;
					breath_count2+=ChainBreaths(x-1,y,opponentColor);
					//System.out.println("----  " + breath_count2);		
				}
				if(Board[x][y + 1].equals(opponentColor)) {
					breath_count3=0;
					breath_count3+=ChainBreaths(x,y+1,opponentColor);
					//System.out.println("----  " + breath_count3);		
				}
				if(Board[x][y - 1].equals(opponentColor)) {
					breath_count4=0;
					breath_count4+=ChainBreaths(x,y-1,opponentColor);
					//System.out.println("----  " + breath_count4);					
				}
				
				if(breath_count1 == 0 || breath_count2 == 0 || breath_count3 == 0 || breath_count4 == 0) {
					
					breath_count1=0;
					breath_count2=0;
					breath_count3=0;
					breath_count4=0;
					Board[x][y]="empty";
					return true;	
				}
				else {
					breath_count1=0;
					breath_count2=0;
					breath_count3=0;
					breath_count4=0;
					if(Board[x + 1][y].equals(opponentColor) && Board[x][y + 1].equals(opponentColor) && Board[x - 1][y].equals(opponentColor) && Board[x][y - 1].equals(opponentColor)) {
						Board[x][y]="empty";
						return false;
					}
					else
					{
						if(Board[x + 1][y].equals(actualColor)) {
							breath_count1=0;
							breath_count1+=ChainBreaths(x+1,y,actualColor);
						}
						if(Board[x - 1][y].equals(actualColor)) {
							breath_count2=0;
							breath_count2+=ChainBreaths(x-1,y,actualColor);
						}
						if(Board[x][y + 1].equals(actualColor)) {
							breath_count3=0;
							breath_count3+=ChainBreaths(x,y+1,actualColor);
						}
						if(Board[x][y - 1].equals(actualColor)) {
							breath_count4=0;
							breath_count4+=ChainBreaths(x,y-1,actualColor);
						}
						breath_count = breath_count1+breath_count2+breath_count3+breath_count4;
						breath_count1=0;
						breath_count2=0;
						breath_count3=0;
						breath_count4=0;
						if(breath_count == 0) {
							Board[x][y]="empty";
							return false;	
						}
						else {
							Board[x][y]="empty";
							breath_count = 0;
							return true;
						}
						
					}
							
					
				}
				
			}
			else {
				Board[x][y]="empty";
				return true;
				
			}
		}
		else {	
			return false;		
		}
		
	}
	
	public int HowManyBreaths(int x,int y) {
		
		int breath=0;
		
		if(Board[x + 1][y].equals("empty"))
			breath++;
		if(Board[x][y + 1].equals("empty"))
			breath++;
		if(Board[x - 1][y].equals("empty"))
			breath++;
		if(Board[x][y - 1].equals("empty"))
			breath++;
		
		return breath;
	}
	
    public int HowManyBreathsCopy(int x,int y) {
		
		int breath=0;
		
		if(copyBoard[x + 1][y].equals("empty"))
			breath++;
		if(copyBoard[x - 1][y].equals("empty"))
			breath++;
		if(copyBoard[x][y + 1].equals("empty"))
			breath++;
		if(copyBoard[x][y - 1].equals("empty"))
			breath++;
		
		return breath;
	}
	
	
    public int ChainBreaths(int x,int y,String color) {
    		
 		CopyTheBoard();
 		curColor = color;
 		return ChainBreaths2(x,y);
 		
 	}
 	
 	public int ChainBreaths2(int x,int y) {
 		
 		if(!copyBoard[x + 1][y].equals(curColor) && !copyBoard[x - 1][y].equals(curColor) && !copyBoard[x][y + 1].equals(curColor) && !copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y);
 			//PUSTY
 		}
 		else if(copyBoard[x + 1][y].equals(curColor) && !copyBoard[x - 1][y].equals(curColor) && !copyBoard[x][y + 1].equals(curColor) && !copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x+1,y);
 			//A
 		}
 		else if(!copyBoard[x + 1][y].equals(curColor) && copyBoard[x - 1][y].equals(curColor) && !copyBoard[x][y + 1].equals(curColor) && !copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x-1,y);
 			//B
 		}
 		else if(!copyBoard[x + 1][y].equals(curColor) && !copyBoard[x - 1][y].equals(curColor) && copyBoard[x][y + 1].equals(curColor) && !copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x,y+1);
 			//C
 		}
 		else if(!copyBoard[x + 1][y].equals(curColor) && !copyBoard[x - 1][y].equals(curColor) && !copyBoard[x][y + 1].equals(curColor) && copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x,y-1);
 			//D
 		}
 		else if(copyBoard[x + 1][y].equals(curColor) && copyBoard[x - 1][y].equals(curColor) && !copyBoard[x][y + 1].equals(curColor) && !copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x+1,y) + ChainBreaths2(x-1,y);
 			//AB
 		}
 		else if(copyBoard[x + 1][y].equals(curColor) && !copyBoard[x - 1][y].equals(curColor) && copyBoard[x][y + 1].equals(curColor) && !copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x+1,y) + ChainBreaths2(x,y+1);
 			//AC
 		}
 		else if(copyBoard[x + 1][y].equals(curColor) && !copyBoard[x - 1][y].equals(curColor) && !copyBoard[x][y + 1].equals(curColor) && copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x+1,y) + ChainBreaths2(x,y-1);
 			//AD
 		}
 		else if(!copyBoard[x + 1][y].equals(curColor) && copyBoard[x - 1][y].equals(curColor) && copyBoard[x][y + 1].equals(curColor) && !copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x-1,y) + ChainBreaths2(x,y+1);
 			//BC
 		}
 		else if(!copyBoard[x + 1][y].equals(curColor) && copyBoard[x - 1][y].equals(curColor) && !copyBoard[x][y + 1].equals(curColor) && copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x-1,y) + ChainBreaths2(x,y-1);
 			//BD	
 		}
 		else if(!copyBoard[x + 1][y].equals(curColor) && !copyBoard[x - 1][y].equals(curColor) && copyBoard[x][y + 1].equals(curColor) && copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x,y+1) + ChainBreaths2(x,y-1);
 			//CD	
 		}
 		else if(copyBoard[x + 1][y].equals(curColor) && copyBoard[x - 1][y].equals(curColor) && copyBoard[x][y + 1].equals(curColor) && !copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x+1,y) + ChainBreaths2(x-1,y) + ChainBreaths2(x,y+1);
 			//ABC
 		}
 		else if(copyBoard[x + 1][y].equals(curColor) && copyBoard[x - 1][y].equals(curColor) && !copyBoard[x][y + 1].equals(curColor) && copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x+1,y) + ChainBreaths2(x-1,y) + ChainBreaths2(x,y-1);
 			//ABD
 		}
 		else if(copyBoard[x + 1][y].equals(curColor) && !copyBoard[x - 1][y].equals(curColor) && copyBoard[x][y + 1].equals(curColor) && copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x+1,y) + ChainBreaths2(x,y+1) + ChainBreaths2(x,y-1);
 			//ACD
 		}
 		else if(!copyBoard[x + 1][y].equals(curColor) && copyBoard[x - 1][y].equals(curColor) && copyBoard[x][y + 1].equals(curColor) && copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x-1,y) + ChainBreaths2(x,y+1) + ChainBreaths2(x,y-1);
 			//BCD
 		}
 		else if(copyBoard[x + 1][y].equals(curColor) && copyBoard[x - 1][y].equals(curColor) && copyBoard[x][y + 1].equals(curColor) && copyBoard[x][y - 1].equals(curColor) ){
 			copyBoard[x][y]="checked";
 			return HowManyBreathsCopy(x,y) + ChainBreaths2(x+1,y) + ChainBreaths2(x-1,y)+ ChainBreaths2(x,y+1) + ChainBreaths2(x,y-1);
 			//ABCD
 		}
 		return 0;
 	}
 	
 	 public void Insert(int x,int y) {
 		int wynik;
 		if(CanYouInsert(x,y) == true){
 			
 			message.add("T");
 			message.add(actualColor);
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));

 			System.out.println("Inserted");
 			Board[x][y]="check";
 			
 			if(Board[x + 1][y].equals(opponentColor) ) {
 				
 				if(ChainBreaths(x+1,y,opponentColor) == 0) {
 					
 				wynik=DeleteDeadStones(x+1,y,opponentColor);
 				UpdateScore(wynik);
 				}
 			}
 			if(Board[x - 1][y].equals(opponentColor) ) {
 				if(ChainBreaths(x-1,y,opponentColor) == 0) {
 					
 				wynik=DeleteDeadStones(x-1,y,opponentColor);
 				UpdateScore(wynik);	
 				}
 			}
 			if(Board[x][y + 1].equals(opponentColor) ) {
 				if(ChainBreaths(x,y+1,opponentColor) == 0) {
 					
 				wynik=DeleteDeadStones(x,y+1,opponentColor);
 				UpdateScore(wynik);	
 				}
 			}
 			if(Board[x][y - 1].equals(opponentColor) ) {
 				if(ChainBreaths(x,y-1,opponentColor) == 0) {
 				
 				wynik=DeleteDeadStones(x,y-1,opponentColor);
 				UpdateScore(wynik);	
 				}
 			}
 			Board[x][y]=actualColor;
 			changeColor();
 			
 		}
 		else {
 			message.add("N");
 			System.out.println(x + " " + y +"Not Inserted");
 		}
 		System.out.println(message);
 		
 	}
 		
 	 public void UpdateScore(int wynik) {
 		
 		if(actualColor.equals("white")) {
 			
 			white_score+=wynik;
 		}
 		else if(actualColor.equals("black")) {
 			
 			black_score+=wynik;
 		}
 	}		
 	
 	 public int DeleteDeadStones(int x,int y,String color) {
 		
 		
 		curColor = color;
 		return DeleteDeadStones2(x,y);
 		
 	}
 	
 	 public int DeleteDeadStones2(int x,int y) {
 		
 		if(!Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1;
 			//PUSTY
 		}
 		else if(Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x+1,y);
 			//A
 		}
 		else if(!Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x-1,y);
 			//B
 		}
 		else if(!Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x,y+1);
 			//C
 		}
 		else if(!Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x,y-1);
 			//D
 		}
 		else if(Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x-1,y);
 			//AB
 		}
 		else if(Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x,y+1);
 			//AC
 		}
 		else if(Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x,y-1);
 			//AD
 		}
 		else if(!Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x-1,y) + DeleteDeadStones2(x,y+1);
 			//BC
 		}
 		else if(!Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x-1,y) + DeleteDeadStones2(x,y-1);
 			//BD	
 		}
 		else if(!Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x,y+1) + DeleteDeadStones2(x,y-1);
 			//CD	
 		}
 		else if(Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x-1,y) + DeleteDeadStones2(x,y+1);
 			//ABC
 		}
 		else if(Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x-1,y) + DeleteDeadStones2(x,y-1);
 			//ABD
 		}
 		else if(Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x,y+1) + DeleteDeadStones2(x,y-1);
 			//ACD
 		}
 		else if(!Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x-1,y) + DeleteDeadStones2(x,y+1) + DeleteDeadStones2(x,y-1);
 			//BCD
 		}
 		else if(Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x));
 			message.add(Integer.toString(y));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x-1,y)+ DeleteDeadStones2(x,y+1) + DeleteDeadStones2(x,y-1);
 			//ABCD
 		}
 		return 0;
 	}
	

}
