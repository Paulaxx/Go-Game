package gogame;

public class GameLogic implements Logic {

	int size=9,breath_count=0;
	
	public GameLogic(int size) {
		 this.size = size;
	}
	
	public String[][] Board = new String[size+1][size+1];
	public String[][] copyBoard = new String[size+1][size+1];
	public String actualColor="white",opponentColor="black",empty="";
	
	@Override
	public void resetBoard() {
		
		for(int i=0;i<size+1;i++) {
			for(int j=0;j<size+1;j++) {
			 
				if(i == 0 || j == 0 || i == size || j == size) {
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
		
		for(int i=0;i<size+1;i++) {
			for(int j=0;j<size+1;j++) {
			 
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
		for(i=0;i<size+1;i++) {
			
			for(j=0;j<size+1;j++) {
				
				copyBoard[i][j]=Board[i][j];
				
			}
			
		}
		
	}
	
	public boolean CanYouInsert(int x,int y) {
		
		if(Board[x][y].equals("empty")) {
			
			
			if(HowManyBreaths(x,y) == 0) {
				
				if(CanTakeOpponentChain(x+1,y) == true || CanTakeOpponentChain(x-1,y) == true || CanTakeOpponentChain(x,y+1) == true || CanTakeOpponentChain(x,y-1) == true) {
					
					return true;	
				}
				else {
					
					if(Board[x + 1][y].equals(opponentColor) && Board[x][y + 1].equals(opponentColor) && Board[x - 1][y].equals(opponentColor) && Board[x][y - 1].equals(opponentColor)) {
						
						return false;
					}
					else
					{
						changeColor();
						if(CanTakeOpponentChain(x,y) == true) {
							changeColor();
							return false;
							
						}
						else {
							changeColor();
							return true;
						}
						
					}
							
					
				}
				
			}
			else {
				
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
	
	public int ChainBreaths(int x,int y) {
	
		String curColor = copyBoard[x][y];
		
		if(copyBoard[x+1][y].equals(curColor) ) {
			
			copyBoard[x][y]="checked";
			if(HowManyBreaths(x,y) > 0) {
				
				return 1;
				// nie do poprawy
			}
				
			return ChainBreaths(x+1,y);	
			
		}
		 if(copyBoard[x-1][y].equals(curColor) ) {
			
			 copyBoard[x][y]="checked";
			if(HowManyBreaths(x,y) > 0) {
					
				return 1;
			}
					
			return ChainBreaths(x-1,y);	
			
			
		}
		 if(copyBoard[x][y+1].equals(curColor) ) {
				
			 copyBoard[x][y]="checked";
			if(HowManyBreaths(x,y) > 0) {
					
				return 1;
			}
					
			return ChainBreaths(x,y+1);	
			
			
		}
		 if(copyBoard[x][y-1].equals(curColor) ) {
				
			 copyBoard[x][y]="checked";
			if(HowManyBreaths(x,y) > 0) {
					
				return 1;
			}
					
			return ChainBreaths(x,y-1);	
			
			
		}
		 return 0;
		
	}
	
	public boolean CanTakeOpponentChain(int x,int y) {
		
		
		CopyTheBoard();
		copyBoard[x][y]="checking";
		if(CanTakeOpponentChain2(x,y) == 1) {
			breath_count=0;
			return true;
		}
		else {
			breath_count=0;
			return false;
		}
		
	}
	
	public int CanTakeOpponentChain2(int x,int y) {
		
		if(copyBoard[x+1][y].equals(opponentColor)) {
		
			breath_count+=HowManyBreaths(x+1,y);
			if(breath_count > 0) {
			
				return 0;
			}
			else {
				copyBoard[x+1][y]="checked";
				return  CanTakeOpponentChain2(x+1,y) + CanTakeOpponentChain2(x-1,y) + CanTakeOpponentChain2(x,y+1) + CanTakeOpponentChain2(x,y-1);
			}
		}
		
		if(breath_count > 0) {
			return 0;
		}
	
		if(copyBoard[x-1][y].equals(opponentColor)) {
		
			breath_count+=HowManyBreaths(x-1,y);
			if(breath_count > 0) {
			
				return 0;
			}
			else {
				copyBoard[x-1][y]="checked";
				return CanTakeOpponentChain2(x+1,y) + CanTakeOpponentChain2(x-1,y) + CanTakeOpponentChain2(x,y+1) + CanTakeOpponentChain2(x,y-1);
			}
		}
		
		if(breath_count > 0) {
			return 0;
		}
	
		if(copyBoard[x][y+1].equals(opponentColor)) {
		
			breath_count+=HowManyBreaths(x,y+1);
			if(breath_count > 0) {
			
				return 0;
			}
			else {
				copyBoard[x][y+1]="checked";
				return CanTakeOpponentChain2(x+1,y) + CanTakeOpponentChain2(x-1,y) + CanTakeOpponentChain2(x,y+1) + CanTakeOpponentChain2(x,y-1);
			}
		}
		
		if(breath_count > 0) {
			return 0;
		}
		
		if(copyBoard[x][y-1].equals(opponentColor)) {
		
			breath_count+=HowManyBreaths(x,y-1);
			if(breath_count > 0) {
			
				return 0;
			}
			else {
				copyBoard[x][y-1]="checked";
				return CanTakeOpponentChain2(x+1,y) + CanTakeOpponentChain2(x-1,y) + CanTakeOpponentChain2(x,y+1) + CanTakeOpponentChain2(x,y-1);
			}
		}
		
		if(breath_count > 0) {
			return 0;
		}
		
	return 1;
		
		
		
	}
	

}
