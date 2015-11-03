/**
 * 
 */
package it.tennis.TennisGame.interfaces;

/**
 * @author mnanni
 *Abstract Factory to access implementation specific factories.
 *Should have managed the rules engine injection.
 */
public interface AbstractFactory {
	public AbstractGame createGame();
}
