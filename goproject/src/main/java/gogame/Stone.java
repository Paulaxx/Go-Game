package gogame;

public class Stone {
	
	int x,y;

	public Stone(int x,int y) {
		
	this.x=x;
	this.y=y;	
	
	}
	
	public void setX( final int x ) {
        this.x = x;
    }

    public void setY( final int y ) {
        this.y = y;
    }

    public int getX() {
        return ( this.x );
    }

    public int getY() {
        return ( this.y );
    }
	
}
