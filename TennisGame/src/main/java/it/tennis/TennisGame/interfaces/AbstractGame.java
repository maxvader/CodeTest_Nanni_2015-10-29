package it.tennis.TennisGame.interfaces;

import it.tennis.TennisGame.GameScore;
import it.tennis.TennisGame.exception.GameAlreadyOverException;

/**
 * 
 * @author mnanni
 *
 */
public interface AbstractGame {
	public AbstractGame assignPointPlayerA() throws GameAlreadyOverException;
	public AbstractGame assignPointPlayerB() throws GameAlreadyOverException;
	public boolean isGameRunning();
	public GameScore getScore();
}
