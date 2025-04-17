package latice.application;

import java.util.List;

import latice.player.Player;
import latice.player.Pool;
import latice.player.Rack;
import latice.tile.Tile;

public class Referee {

    private List<Player> players;
    private GameBoard gameboard;

    public Referee(List<Player> players, GameBoard gameboard) {
        this.players = players;
        this.gameboard = gameboard;
    }

    public void distribute(Rack rack, Pool pool) {
        for (int i = 0; i < 5; i++) {
            if (!pool.isEmpty()) {
                Tile tile = pool.drawTile();
                rack.addTile(tile);
            }
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