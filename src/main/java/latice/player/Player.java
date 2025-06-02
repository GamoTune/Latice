package latice.player;

public class Player {
	private final String name;
	private Integer point;
	private Rack rack;
	private Pool pool;
	
	public Player(String name, Rack rack, Pool pool) {
		this.name = name;
		this.point = 0;
		this.rack = rack;
		this.pool = pool;
	}

	public Player(String name) {
		this.name = name;
		this.point = 0;
		this.rack = new Rack();
		this.pool = null;
	}
	public void setPool(Pool pool) {
	    this.pool = pool;
	}
	
	public Pool getPool() {
	    return pool;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public Rack getRack() {

		return rack;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getPoint() {
		return point;
	}
}	
