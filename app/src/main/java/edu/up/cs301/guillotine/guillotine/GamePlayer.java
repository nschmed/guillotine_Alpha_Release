package edu.up.cs301.guillotine.guillotine;

/**
 * A player who plays a (generic) game. Each class that implements a player for
 * a particular game should implement this interface.
 *
 * @author Muhammed Acar
 * @author Linnea Bair
 * @author Melanie Martinell
 * @author Nathan Schmedake
 * @version November 2015
 */

public interface GamePlayer {

	// sends a message to the player
	public GuillotineState sendState();
	
	// start the player
	public void start();
	
	// whether this player requires a GUI
	public boolean requiresGui();
	
	// whether this player supports a GUI
	public boolean supportsGui();

	// receives the info from the local game
	public void receiveState(GuillotineState curState);


}// interface GamePlayer
