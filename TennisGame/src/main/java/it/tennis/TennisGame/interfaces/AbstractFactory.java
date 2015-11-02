/**
 * 
 */
package it.tennis.TennisGame.interfaces;

/**
 * @author mnanni
 *Abstract Factory to access implementation specific factories.
 */
public interface AbstractFactory {
	public AbstractGame createGame();
}
