package edu.up.cs301.guillotine.guillotine;

import android.os.Handler;
import android.os.Looper;

/**
 * An abstract computerized game player player. This is an abstract class, that
 * should be sub-classed to implement different AIs. The subclass must implement
 * the {@link #receiveState} method.
 * 
 * @author Steven R. Vegdahl
 * @author Andrew Nuxoll
 * @version July 2013
 */
public abstract class GameComputerPlayer implements GamePlayer{
	/**
	 * the current game state
	 */
	protected GuillotineState curState; // the gameState object
	protected int playerNum; // which player number I am
	private Handler myHandler; // the handler for this player's thread
	private boolean running; // whether the player's thread is running
	private boolean gameOver = false; // whether the game is over

	/**
	 * constructor
	 * 
	 * @param index
	 * 			the player's index
	 */
	public GameComputerPlayer(int index) {
		this.playerNum = index;
	}
	
	/**
	 * Method used to send updated state to this player.
	 * 
	 * @param curState
	 * 			the state to send
	 */
	public final void sendInfo(GuillotineState curState) {
		// post the state to the player's thread
		while (myHandler == null) Thread.yield();
		myHandler.post(new MyRunnable(curState));
	}
	
	/**
	 * Starts the player.
	 */
	public final void start() {
		// if the player's thread is not presently running, start it up, keeping
		// track of its handler so that messages can be sent to the thread.
		synchronized(this) {
			if (running) return;
			running = true;
			Runnable runnable = new Runnable() {
				public void run() {
					Looper.prepare();
					myHandler = new Handler();
					Looper.loop();
				}
			};
			Thread thread = new Thread(runnable);
			thread.setName("Computer Player");
			thread.start();
		}
	}
	
	/**
	 * Callback-method implemented in the subclass whenever updated
	 * state is received.
	 * 
	 * @param info
	 * 			the object representing the information from the game
	 */
	public void receiveState(GuillotineState info){
		curState = info;
	}
	
	/**
	 * Helper-class to post a message to this player's thread
	 *
	 */
	private class MyRunnable implements Runnable {
		
		// the object to post
		private Object data;
		
		// constructor
		public MyRunnable(Object data) {
			this.data = data;
		}
		
		// run-method: executed in this player's thread, handling a message from
		// the game
		public void run() {
			


		}
	}
	
	/**
	 * Sleeps for a particular amount of time. Utility method.
	 * 
	 * @param milliseconds
	 * 			the number of milliseconds to sleep for
	 */
	protected void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}
	
	/**
	 * Tells whether this player requires a GUI. Since this is a computer
	 * player, the answer should be 'false'.
	 */
	public final boolean requiresGui() {
		return false;
	}
	
	/** tells whether this player supports a GUI. Some computer players may be
	 * implemented to do so. In that case, they should implement the 'setAsGui'
	 * method.
	 */
	public boolean supportsGui() {
		return false;
	}

}// class GameComputerPlayer
