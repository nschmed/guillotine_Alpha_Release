package edu.up.cs301.guillotine.guillotine;

/**
 * This is a computer player that will switch between easy and hard based on the constructor and play a card.
 *
 * @author Muhammed Acar
 * @author Linnea Bair
 * @author Melanie Martinell
 * @author Nathan Schmedake
 * @version November 2015
 */
public class GuillotineComputerPlayerHard extends GameComputerPlayer implements GamePlayer {

	/**
	 * Constructor for objects of class GuillotineComputerPlayerEasy
	 *
	 * @param index
	 * 		the player's difficulty
	 */
	public GuillotineComputerPlayerHard(int index) {
		super(index);
	}

	/**
	 * callback method--game's state has changed

	 */
	protected void receiveState() {

	}

	@Override
	public GuillotineState sendState() {
		return null;
	}
}
