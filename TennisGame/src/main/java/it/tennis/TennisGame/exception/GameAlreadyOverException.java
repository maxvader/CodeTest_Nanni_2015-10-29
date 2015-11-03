/**
 * 
 */
package it.tennis.TennisGame.exception;

/**
 * @author mnanni
 *
 */
public class GameAlreadyOverException extends Exception {

	private static final long serialVersionUID = -2349136022836854427L;

	public GameAlreadyOverException(String string) {
		super(string);
	}

}
