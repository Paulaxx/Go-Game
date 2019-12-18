package gogame;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class GameLogic implements Logic {

    public int ifbot=1,pas=0,bot=0,white_score=6,randomNum,xbot,ybot,black_score=0,size=9,breath_count=0,breath_count1=-1,breath_count2=-1,breath_count3=-1,breath_count4=-1;
	public String[][] Board = new String[size+2][size+2];
	public String[][] copyBoard = new String[size+2][size+2];
	public String[][] copy2Board = new String[size+2][size+2];
	public Integer[][] botBoard = new Integer[size+2][size+2];
	public String actualColor="black",opponentColor="white",curColor,empty="";
	public ArrayList<String> message = new ArrayList<>();
	public ArrayList<Integer> botX = new ArrayList<>();
	public ArrayList<Integer> botY = new ArrayList<>();
	public ArrayList<String> message2 = new ArrayList<>();
	
	
	public GameLogic() {

		resetBoard();
		CopyTheBoard();
		CopyThe2Board();
		resetBotBoard();
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
	
	public void CopyThe2Board() {
		
		int i,j;
		for(i=0;i<size+2;i++) {
			
			for(j=0;j<size+2;j++) {
				
				copy2Board[i][j]=Board[i][j];
				
			}
			
		}
		
	}	
	
	public void showBotBoard() {
		
		for(int i=0;i<size+2;i++) {
			for(int j=0;j<size+2;j++) {
			 
			System.out.println(botBoard[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");

	}
	
	public void resetBotBoard() {
		
		for(int i=0;i<size+2;i++) {
			for(int j=0;j<size+2;j++) {
			 
				if(i == 0 || j == 0 || i == size+1 || j == size+1) {
					botBoard[i][j] = -100;	
				}
				else {
					botBoard[i][j] = 50;
				}
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
 		message2 = message;
 		
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
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1;
 			//PUSTY
 		}
 		else if(Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x+1,y);
 			//A
 		}
 		else if(!Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x-1,y);
 			//B
 		}
 		else if(!Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x,y+1);
 			//C
 		}
 		else if(!Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x,y-1);
 			//D
 		}
 		else if(Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x-1,y);
 			//AB
 		}
 		else if(Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x,y+1);
 			//AC
 		}
 		else if(Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x,y-1);
 			//AD
 		}
 		else if(!Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x-1,y) + DeleteDeadStones2(x,y+1);
 			//BC
 		}
 		else if(!Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x-1,y) + DeleteDeadStones2(x,y-1);
 			//BD	
 		}
 		else if(!Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x,y+1) + DeleteDeadStones2(x,y-1);
 			//CD	
 		}
 		else if(Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && !Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x-1,y) + DeleteDeadStones2(x,y+1);
 			//ABC
 		}
 		else if(Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && !Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x-1,y) + DeleteDeadStones2(x,y-1);
 			//ABD
 		}
 		else if(Board[x + 1][y].equals(curColor) && !Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x,y+1) + DeleteDeadStones2(x,y-1);
 			//ACD
 		}
 		else if(!Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x-1,y) + DeleteDeadStones2(x,y+1) + DeleteDeadStones2(x,y-1);
 			//BCD
 		}
 		else if(Board[x + 1][y].equals(curColor) && Board[x - 1][y].equals(curColor) && Board[x][y + 1].equals(curColor) && Board[x][y - 1].equals(curColor) ){
 			Board[x][y]="empty";
 			message.add(Integer.toString(x-1));
 			message.add(Integer.toString(y-1));
 			return 1 + DeleteDeadStones2(x+1,y) + DeleteDeadStones2(x-1,y)+ DeleteDeadStones2(x,y+1) + DeleteDeadStones2(x,y-1);
 			//ABCD
 		}
 		return 0;
 	}
 	 
 	 public int CheckDeleteDeadStones(int x,int y,String color) {
 		
 		
 		curColor = color;
 		return CheckDeleteDeadStones2(x,y);
 		
 	}
 	
 	 public int CheckDeleteDeadStones2(int x,int y) {
 		
 		if(!copy2Board[x + 1][y].equals(curColor) && !copy2Board[x - 1][y].equals(curColor) && !copy2Board[x][y + 1].equals(curColor) && !copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1;
 			//PUSTY
 		}
 		else if(copy2Board[x + 1][y].equals(curColor) && !copy2Board[x - 1][y].equals(curColor) && !copy2Board[x][y + 1].equals(curColor) && !copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x+1,y);
 			//A
 		}
 		else if(!copy2Board[x + 1][y].equals(curColor) && copy2Board[x - 1][y].equals(curColor) && !copy2Board[x][y + 1].equals(curColor) && !copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x-1,y);
 			//B
 		}
 		else if(!copy2Board[x + 1][y].equals(curColor) && !copy2Board[x - 1][y].equals(curColor) && copy2Board[x][y + 1].equals(curColor) && !copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x,y+1);
 			//C
 		}
 		else if(!copy2Board[x + 1][y].equals(curColor) && !copy2Board[x - 1][y].equals(curColor) && !copy2Board[x][y + 1].equals(curColor) && copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x,y-1);
 			//D
 		}
 		else if(copy2Board[x + 1][y].equals(curColor) && copy2Board[x - 1][y].equals(curColor) && !copy2Board[x][y + 1].equals(curColor) && !copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x+1,y) + CheckDeleteDeadStones2(x-1,y);
 			//AB
 		}
 		else if(copy2Board[x + 1][y].equals(curColor) && !copy2Board[x - 1][y].equals(curColor) && copy2Board[x][y + 1].equals(curColor) && !copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x+1,y) + CheckDeleteDeadStones2(x,y+1);
 			//AC
 		}
 		else if(copy2Board[x + 1][y].equals(curColor) && !copy2Board[x - 1][y].equals(curColor) && !copy2Board[x][y + 1].equals(curColor) && copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x+1,y) + CheckDeleteDeadStones2(x,y-1);
 			//AD
 		}
 		else if(!copy2Board[x + 1][y].equals(curColor) && copy2Board[x - 1][y].equals(curColor) && copy2Board[x][y + 1].equals(curColor) && !copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x-1,y) + CheckDeleteDeadStones2(x,y+1);
 			//BC
 		}
 		else if(!copy2Board[x + 1][y].equals(curColor) && copy2Board[x - 1][y].equals(curColor) && !copy2Board[x][y + 1].equals(curColor) && copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x-1,y) + CheckDeleteDeadStones2(x,y-1);
 			//BD	
 		}
 		else if(!copy2Board[x + 1][y].equals(curColor) && !copy2Board[x - 1][y].equals(curColor) && copy2Board[x][y + 1].equals(curColor) && copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x,y+1) + CheckDeleteDeadStones2(x,y-1);
 			//CD	
 		}
 		else if(copy2Board[x + 1][y].equals(curColor) && copy2Board[x - 1][y].equals(curColor) && copy2Board[x][y + 1].equals(curColor) && !copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x+1,y) + CheckDeleteDeadStones2(x-1,y) + CheckDeleteDeadStones2(x,y+1);
 			//ABC
 		}
 		else if(copy2Board[x + 1][y].equals(curColor) && copy2Board[x - 1][y].equals(curColor) && !copy2Board[x][y + 1].equals(curColor) && copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x+1,y) + CheckDeleteDeadStones2(x-1,y) + CheckDeleteDeadStones2(x,y-1);
 			//ABD
 		}
 		else if(copy2Board[x + 1][y].equals(curColor) && !copy2Board[x - 1][y].equals(curColor) && copy2Board[x][y + 1].equals(curColor) && copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x+1,y) + CheckDeleteDeadStones2(x,y+1) + CheckDeleteDeadStones2(x,y-1);
 			//ACD
 		}
 		else if(!copy2Board[x + 1][y].equals(curColor) && copy2Board[x - 1][y].equals(curColor) && copy2Board[x][y + 1].equals(curColor) && copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x-1,y) + CheckDeleteDeadStones2(x,y+1) + CheckDeleteDeadStones2(x,y-1);
 			//BCD
 		}
 		else if(copy2Board[x + 1][y].equals(curColor) && copy2Board[x - 1][y].equals(curColor) && copy2Board[x][y + 1].equals(curColor) && copy2Board[x][y - 1].equals(curColor) ){
 			copy2Board[x][y]="empty";
 			return 1 + CheckDeleteDeadStones2(x+1,y) + CheckDeleteDeadStones2(x-1,y)+ CheckDeleteDeadStones2(x,y+1) + CheckDeleteDeadStones2(x,y-1);
 			//ABCD
 		}
 		return 0;
 	}
 	 
 	 
 	 	public void updateBotBoard() {
		int count=0,max=-100;
		for(int i=1;i<size+1;i++) {
			for(int j=1;j<size+1;j++) {
				CopyTheBoard();
		 		CopyThe2Board();
			 
				
				if(Board[i-1][j-1].equals(actualColor))
					count++;
				if(Board[i-1][j].equals(actualColor))
					count++;
				if(Board[i-1][j+1].equals(actualColor))
					count++;
				if(Board[i][j-1].equals(actualColor))
					count++;
				if(Board[i][j+1].equals(actualColor))
					count++;
				if(Board[i+1][j-1].equals(actualColor))
					count++;
				if(Board[i+1][j].equals(actualColor))
					count++;
				if(Board[i+1][j+1].equals(actualColor))
					count++;
				
				if(count==0)
					botBoard[i][j]+=3;
				else if(count==1)
					botBoard[i][j]+=8;
				else if(count==2)
					botBoard[i][j]+=7;
				else if(count==3)
					botBoard[i][j]+=6;
				else if(count==4)
					botBoard[i][j]+=5;
				else if(count==5)
					botBoard[i][j]+=4;
				else if(count==6)
					botBoard[i][j]+=2;
				else if(count==7)
					botBoard[i][j]+=1;
				
				count=0;
				
				if(Board[i-1][j-1].equals(opponentColor))
					count++;
				if(Board[i-1][j].equals(opponentColor))
					count++;
				if(Board[i-1][j+1].equals(opponentColor))
					count++;
				if(Board[i][j-1].equals(opponentColor))
					count++;
				if(Board[i][j+1].equals(opponentColor))
					count++;
				if(Board[i+1][j-1].equals(opponentColor))
					count++;
				if(Board[i+1][j].equals(opponentColor))
					count++;
				if(Board[i+1][j+1].equals(opponentColor))
					count++;
				
				if(count==0)
					botBoard[i][j]-=2;
				else if(count==1)
					botBoard[i][j]+=3;
				else if(count==2)
					botBoard[i][j]+=2;
				else if(count==3)
					botBoard[i][j]+=1;
				else if(count==5)
					botBoard[i][j]-=1;
				else if(count==6)
					botBoard[i][j]-=3;
				else if(count==7)
					botBoard[i][j]-=4;
				else if(count==8)
					botBoard[i][j]-=5;
				
				count=0;
				
				
				botBoard[i][j]+=HowManyBreaths(i,j);
			
				//System.out.println("----");
				copy2Board[i][j]="check";
				copyBoard[i][j]="check";
				
				//System.out.println("----" + copy2Board[i + 1][j]);
				//System.out.println("----" + copy2Board[i - 1][j]);
				//System.out.println("----" + copy2Board[i][j + 1]);
				//System.out.println("----" + copy2Board[i][j - 1]);
				//System.out.println(actualColor);
			
	 			
	 			if(copy2Board[i + 1][j].equals(opponentColor) ) {
	 				//System.out.println("----" + ChainBreaths(i+1,j,opponentColor));
	 				if(ChainBreaths(i+1,j,opponentColor) == 1) {
	 					
	 					botBoard[i][j]+=6 * CheckDeleteDeadStones(i+1,j,opponentColor);
	 					//System.out.println("----" + 6*CheckDeleteDeadStones(i+1,j,opponentColor));
	 				}
	 			}
	 			if(copy2Board[i - 1][j].equals(opponentColor) ) {
	 				//System.out.println("----" + ChainBreaths(i-1,j,opponentColor));
	 				if(ChainBreaths(i-1,j,opponentColor) == 1) {
	 					
	 					botBoard[i][j]+=6 * CheckDeleteDeadStones(i-1,j,opponentColor);
	 					//System.out.println("----" + 6*CheckDeleteDeadStones(i-1,j,opponentColor));
	 				}
	 			}
	 			if(copy2Board[i][j + 1].equals(opponentColor) ) {
	 				//System.out.println("----" + ChainBreaths(i,j+1,opponentColor));
	 				if(ChainBreaths(i,j+1,opponentColor) == 1) {
	 					
	 					botBoard[i][j]+=6 * CheckDeleteDeadStones(i,j+1,opponentColor);
	 					//System.out.println("----" + 6*CheckDeleteDeadStones(i,j+1,opponentColor));
	 				}
	 			}
	 			if(copy2Board[i][j - 1].equals(opponentColor) ) {
	 				//System.out.println("----" + ChainBreaths(i,j-1,opponentColor));
	 				if(ChainBreaths(i,j-1,opponentColor) == 1) {
	 				
	 					botBoard[i][j]+=6 * CheckDeleteDeadStones(i,j-1,opponentColor);
	 					//System.out.println("----" + 6*CheckDeleteDeadStones(i,j-1,opponentColor));
	 				
	 				}
	 			}
	 			copy2Board[i][j]=actualColor;
				
	 			if(CanYouInsert(i,j) == false) {
					
					botBoard[i][j]=-50;
				}
	 			
	 			if(botBoard[i][j]>max)
	 				max = botBoard[i][j];
	
			}
		}
		
		for(int i=1;i<size+1;i++) {
			for(int j=1;j<size+1;j++) {
				
				if(botBoard[i][j] == max) {
					
					botX.add(i);
					botY.add(j);
					
				}
				
			}
		}
		max=-100;
	 randomNum = ThreadLocalRandom.current().nextInt(0, botX.size());
		
		xbot = botX.get(randomNum);
		ybot = botY.get(randomNum);
		
		botX.clear();
		botX.removeAll(botX);
		botY.clear();
		botY.removeAll(botY);
		
		
		

	}
	

}
