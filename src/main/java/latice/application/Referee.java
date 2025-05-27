package latice.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import latice.player.Player;
import latice.player.Pool;
import latice.player.Rack;
import latice.tile.Color;
import latice.tile.Shape;
import latice.tile.Tile;

public class Referee {

    public List<Player> players;

    
    private final Integer RACKSIZE = 5;
    private final Integer NB_PLAYER = 2; // Number of players, can be adjusted as needed
    
    // Constructor to initialize the referee with a list of players
    public Referee() {
    	
    	this.players = new ArrayList<>();
    	
    	for (int i = 0; i < NB_PLAYER; i++) {
			this.players.add(new Player("Player " + (i + 1)));
		}
    	
    	createPlayerPool();
    	
    	for (Player player : this.players) {
			player.setRack(new Rack());
			draw(player.getRack(), player.getPool());
		}
    	
    	
    	
    }
    
    
    public Rack draw(Rack rack, Pool pool) {
    	
        for (int i = 0; i < RACKSIZE; i++) {
            if (!pool.isEmpty()) {
                Tile tile = pool.drawTile();
                rack.addTile(tile);
            }
        }
        return rack;
    }

    
    // Create a pool of tiles for each player
    public void createPlayerPool() {
    	List<Tile> mainTiles = new ArrayList<>();
    	
    	for (Color color : Color.values()) {
    		if (color != Color.RESET && color != Color.WHITE) {
    			for (Shape shape : Shape.values()) {
    				mainTiles.add(new Tile(color, shape));
    				mainTiles.add(new Tile(color, shape));
    			}
    		}
     	}    	
    	
    	Collections.shuffle(mainTiles);

        int tilesPerPlayer = mainTiles.size() / players.size();

        for (Player player : players) {
            List<Tile> playerTiles = new ArrayList<>();

            for (int i = 0; i < tilesPerPlayer; i++) {
                if (!mainTiles.isEmpty()) {
                    playerTiles.add(mainTiles.remove(0));
                }
            }

            Pool playerPool = new Pool(playerTiles);
            player.setPool(playerPool);
        }
    }
    
    
    
    
    // TODO: Implement the logic to choose which player plays
    public void choosePlayer() {
        
    }

    // TODO: Implement the logic to display a player's rack
    public void showRack() {
        
    }

    // TODO: Implement the logic to validate tile placement
    public boolean isPlacementValid() {
    	
        return false; 
    }
    
}