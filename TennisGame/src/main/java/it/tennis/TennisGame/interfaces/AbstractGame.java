package it.tennis.TennisGame.interfaces;

import it.tennis.TennisGame.exception.GameAlreadyOverException;
import it.tennis.TennisGame.models.GameScore;

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
