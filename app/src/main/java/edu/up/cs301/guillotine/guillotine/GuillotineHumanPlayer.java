package edu.up.cs301.guillotine.guillotine;

import android.view.View;
import android.view.View.OnClickListener;

import edu.up.cs301.guillotine.R;

/**
 * This class describes what a human player can do/how it works
 *
 * @author Muhammed Acar
 * @author Linnea Bair
 * @author Melanie Martinell
 * @author Nathan Schmedake
 * @version November 2015
 */
public class GuillotineHumanPlayer implements OnClickListener, GamePlayer {

	/* instance variables */
	// the most recent game state, as given to us by the GuillotineLocalGame
	private GuillotineState state;

	private String playerName;

	// the android activity that we are running
	private MainActivity myActivity;
	
	/**
	 * constructor
	 * @param name
	 * 		the player's name
	 */
	public GuillotineHumanPlayer(String name) {
		playerName = name;
//		setAsGui(new MainActivity());
	}
	
	/**
	 * sets the counter value in the text view
	 */
	protected void updateDisplay() {

	}

	/**
	 * this method gets called when the user clicks one of the buttons
	 * 
	 * @param button
	 * 		the button that was clicked
	 */
	public void onClick(View button) {

	}// onClick
	
	/**
	 * callback method when we get a message (e.g., from the game)
	 * 
	 * @param curState
	 * 		the message
	 */
	@Override
	public void receiveState(GuillotineState curState) {
		
		// update our state; then update the display
		this.state = curState;
		updateDisplay();
	}
	
	/**
	 * callback method--our game has been chosen/rechosen to be the GUI,
	 * called from the GUI thread
	 * 
	 * @param activity
	 * 		the activity under which we are running
	 */
	public void setAsGui(MainActivity activity) {
		
		// remember the activity
		myActivity = activity;

		// the buttons being used all need to be initialized here, which will allow us
		// to use the main activity

	    // Load the layout resource for our GUI
		activity.setContentView(R.layout.activity_main);
		
		// if we have a game state, "simulate" that we have just received
		// the state from the game so that the GUI values are updated
		if (state != null) {
			receiveState(state);
		}
	}

	@Override
	public GuillotineState sendState() {
		return null;
	}

	@Override
	public void start() {

	}

	@Override
	public boolean requiresGui() {
		return true;
	}

	@Override
	public boolean supportsGui() {
		return true;
	}
}// class GuillotineHumanPlayer

