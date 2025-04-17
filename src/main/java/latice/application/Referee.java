package latice.application;

import java.util.List;
import latice.player.Player;
import latice.player.Rack;

public class Referee {

    private List<Player> players;
    private GameBoard gameboard;

    public Referee(List<Player> players, GameBoard gameboard) {
        this.players = players;
        this.gameboard = gameboard;
    }

    // TODO: Implement the logic to distribute tiles to players
    public void distribute() {
        
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