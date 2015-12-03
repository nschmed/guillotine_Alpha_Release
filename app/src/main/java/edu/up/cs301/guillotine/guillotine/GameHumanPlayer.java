package edu.up.cs301.guillotine.guillotine;

import android.os.Handler;
import android.util.Log;


/**
 * class GameHumanPlayer
 * 
 * is an abstract base class for a player that is controlled by a human. For any
 * particular game, a subclass should be created that can display the current
 * game state and responds to user commands.
 *
 * @author Nathan Schmedake
 * @author Muhammed Acar
 * @author Melanie Martinell
 * @author Linnea Bair
 * @version November 2015
 * 
 */
public abstract class GameHumanPlayer implements GamePlayer{
	/**
	 * instance variables
	 */
	protected GuillotineState gameState; // the game
	protected int playerNum = 0; // my player ID
	protected String name; // my player's name
	private Handler myHandler; // my thread's handler
	private MainActivity myActivity; // the current activity

	/**
	 * constructor
	 * 
	 * @param name
	 */
	public GameHumanPlayer(String name) {
		// set the name via the argument
		this.name = name;
		
		// get new handler for this thread
		this.myHandler = new Handler();
	}
	
	/**
	 * Start's the GUI's thread, setting up handler.
	 */
	public void start() {
		// Don't need to do anything since I'm already looping
		// and have a handler.
	}
	
	/**
	 * perform any initialization that needs to be done after the player
	 * knows what their game-position and opponents' names are.
	 */
	protected void initAfterReady() {
		// by default, we do nothing
	}
	
	/**
	 * Sets this player as the one attached to the GUI. Saves the
	 * activity, then invokes subclass-specific method.
	 */
	public final void gameSetAsGui(MainActivity a) {
		myActivity = a;
	}

	/**
	 * Sends a 'state' object to the local game's thread.
	 */
	public GuillotineState sendState() {
		// if handler somehow does not exit, ignore
		if (myHandler == null) {
			Log.d("Info", "No handler!");
			return null;
		}

		return gameState;
	}

	/**
	 * Callback method, called when player gets a message
	 * 
	 * @param curState
	 * 		the message
	 */
	public void receiveState(GuillotineState curState){

	}

	
	/**
	 * Helper-class that runs the on the GUI's main thread when
	 * there is a message to the player.
	 */
	private class MyRunnable implements Runnable {
		// the message to send to the player
		private GuillotineState curState;
		
		// constructor
		public MyRunnable(GuillotineState state) {
			curState = state;
		}
		
		// the run method, which is run in the main GUI thread
		public void run() {
				// pass the state on to the subclass
				receiveState(curState);

		}
	}
	
	/**
	 * Tells whether this class requires a GUI to run
	 * 
	 * @return true, since this player needs to be running as a GUI
	 */
	public final boolean requiresGui() {
		return true;
	}
	
	/**
	 * Tells whether this class supports the running in a GUI
	 * 
	 * @return true, since this player actually needs to be running as a GUI
	 */	
	public final boolean supportsGui() {
		return true;
	}

	/**
	 * Invoked whenever the player's timer has ticked. It is expected
	 * that this will be overridden in many games.
	 */

}// class GameHumanPlayer

