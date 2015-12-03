package edu.up.cs301.guillotine.guillotine;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * A class that represents the state of a game. This contains the current
 * players and the GuillotineState object that runs the entire game.
 * 
 * @author Nathan Schmedake
 * @author Melanie Martinell
 * @author Linnea Bair
 * @author Muhammed Acar
 * @version November 2015
 */
public class GuillotineLocalGame {

	// the game's state and players
	private GuillotineState gameState;
	private ArrayList<GamePlayer> playerList = new ArrayList<GamePlayer>();
	int currentPlayer;

	

	/**
	 * This constructor should be called when a new Guillotine game is started
	 */
	public GuillotineLocalGame(int numCompPlayers, int difficulty, String playerName) {
		// initialize the game state
		gameState = new GuillotineState(numCompPlayers, playerName, difficulty);
		playerList.add(new GuillotineHumanPlayer(playerName));
		for (int i = 1; i<=numCompPlayers; i++){
			if(difficulty == 0) {
				playerList.add(new GuillotineComputerPlayerEasy(i));
			}
			else if(difficulty == 1) {
				playerList.add(new GuillotineComputerPlayerHard(i));
			}
		}
		currentPlayer = gameState.getCurrentPlayer();
		playerList.get(currentPlayer).receiveState(gameState);

	}

	//Receives the current game state from the respective object
	public void receiveState(GuillotineState curState){
		gameState = curState;
		checkIfGameOver();

	}

	//Sends the current game state to an object
	public GuillotineState sendState(){
		return gameState;
	}
	
	/**
	 * Check if the game is over. It is over, return a string that tells
	 * who the winner(s), if any, are. If the game is not over, return null;
	 * 
	 * @return
	 * 		a message that tells who has won the game, or null if the
	 * 		game is not over
	 */
	public void checkIfGameOver() {

	}

}// class GuillotineLocalGame
