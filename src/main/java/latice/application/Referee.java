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

    private List<Player> players;
    private GameBoard gameboard;
    
    private final Integer RACKSIZE = 5;
    
    public Referee(List<Player> players) {
        this.players = players;
        //this.gameboard = gameboard;
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

    
    public void createPlayerPool() {
    	List<Tile> mainTiles = new ArrayList<>();
    	
    	for (Color color : Color.values()) {
    		if (color != Color.RESET) {
    			for (Shape shape : Shape.values()) {
    				mainTiles.add(new Tile(color, shape));
    				mainTiles.add(new Tile(color, shape));
    			}
    		}
     	}    	
    	
    	Collections.shuffle(mainTiles);
    	System.out.println("Main Tiles: " + mainTiles.size());

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