package gogame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moves")
public class Stone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name="`gameId`")
	private Integer gameId=1;
	
	@Column(name="`x`")
	private int x;
	
	@Column(name="`y`")
	private int y;
	
	@Column(name="`color`")
	private String color;
	
	public void setX(int x) {
	    this.x=x;
	}
	
	public void setY(int y) {
	    this.y=y;
	}
	
	public void setColor(String color) {
	    this.color=color;
	}
	
	public void setGameId(Integer gameId) {
		this.gameId=gameId;
	}
}
