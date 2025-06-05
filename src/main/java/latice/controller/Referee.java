package latice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import latice.cell.CellType;
import latice.cell.Position;
import latice.gameboard.GameBoard;
import latice.player.Player;
import latice.player.Pool;
import latice.player.Rack;
import latice.tile.Color;
import latice.tile.Shape;
import latice.tile.Tile;

public class Referee {
	
	private final GameBoard gameboard;

    public List<Player> players;
    public List<Player> playersCycle = new ArrayList<>();
    
    
    private final Integer RACKSIZE = 5;
    private final Integer NB_PLAYER = 2; // Number of players, can be adjusted as needed
    public int currentPlayerIndex = 0; // Index of the current player in the cycle
    
    // Constructor to initialize the referee with a list of players
    public Referee() {
    	
    	gameboard = new GameBoard();
    	
    	this.players = new ArrayList<>();
    	
    	for (int i = 0; i < NB_PLAYER; i++) {
			this.players.add(new Player("Player " + (i + 1)));
		}
    	
    	createPlayerPool();
    	
    	for (Player player : this.players) {
			player.setRack(new Rack());
			draw(player.getRack(), player.getPool());
		}
    	
    	createCycle();
    	
    }
    
    // Draw tiles from the pool and add them to the player's rack
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
    
    
    
    // Choose a random player from the list of players
    public Player choosePlayer() {
    	Random rand = new Random();
    	int randomIndex = rand.nextInt(players.size());
    	Player chosenPlayer = players.get(randomIndex);
    	
    	return chosenPlayer;
    }


    public static boolean isPlacementValid(Position position, Tile tile) {
    	
    	String color = tile.getColor();
    	String shape = tile.getShape();
    	Position centerPosition = new Position(GameBoard.MID_ROW, GameBoard.MID_COL);
    	boolean haveNeighbors = false;
    	
    	if (GameBoard.cells.containsKey(position)) {
    		// Check if the center position is occupied by a tile
    		if (GameBoard.cells.get(centerPosition).getTile() != null) {
    			
    			if (GameBoard.cells.get(position).getTile() != null) {
    				return false; // Position already occupied
    			}
    			else {
    				// Check if the adjacency Tile are the same color or shape
    				for (Position neighbor : position.getNeighbors()) {
						if (GameBoard.cells.containsKey(neighbor)) {
							Tile neighborTile = GameBoard.cells.get(neighbor).getTile();
							if (neighborTile != null) {
								haveNeighbors = true; // At least one neighbor exists
								if (!neighborTile.getColor().equals(color) && !neighborTile.getShape().equals(shape)) {
									return false; // Adjacent tile does not match color or shape
								}
							}
						}
					
					}
    				if (!haveNeighbors) {
						return false; // No adjacent tiles to match with
					}
    			}
    			
    		}
    		else if (!position.equals(centerPosition)) {
					return false; // Center position must be occupied by any tile
				}
			}
    		
    		
    			 
		return true; // Position does not exist on the game board
    	
        
    }
    
    public void pointCalcul(Position position, Tile tile, Player player) {
        if (isPlacementValid(position, tile)) {
        	if (GameBoard.getCell(position).getType()== CellType.SUN) {
        		player.addPoint(2); // Add 1 point for placing a tile on a SUN cell
        	}
            switch (position.getNeighbors().size()) {
                case 2:
                    // Two neighbors, 1 points
                    player.addPoint(1);
                    break;
                case 3:
                    // Three neighbors, 2 points
                    player.addPoint(2);
                    break;
                case 4:
                    // Four neighbors, 4 points
                    player.addPoint(4);
                    break;
                default:
                    // No neighbors or one neighbors, 0 points
                    break;
            }
        } 
    }

    // Method to end the game and determine the winner(s)
    public void gameEnd() {
    	//TODO
    }
    
    // Method to end the turn for the current player
    public void turnEnd() {
    	if (currentPlayerIndex < playersCycle.size() - 1) {
			currentPlayerIndex++;
		} else {
			currentPlayerIndex = 0; // Reset to the first player
		}
    }

    // Method to create a cycle of players 
    public void createCycle() {
    	while (playersCycle.size() != NB_PLAYER){
    		Player currentPlayer = choosePlayer();
    		if (!playersCycle.contains(currentPlayer)) {
				playersCycle.add(currentPlayer);
			} else {
				continue; // If player already in the list, skip to next iteration
			}
    	}
    }
	
    
    public GameBoard getGameBoard() {
    	return gameboard;
    }
}