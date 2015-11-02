/**
 * 
 */
package it.tennis.TennisGame.simpleImpl;

import it.tennis.TennisGame.Constants.PlayerScore;
import it.tennis.TennisGame.GameScore;
import it.tennis.TennisGame.exception.GameAlreadyOverException;
import it.tennis.TennisGame.interfaces.AbstractGame;
import it.tennis.TennisGame.rules.RulesEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mnanni
 *
 */
public class ConsoleLoggingGame implements AbstractGame {
	private static Logger LOG = LoggerFactory.getLogger(ConsoleLoggingGame.class);
	
	private boolean gameRunning=Boolean.TRUE;
	private RulesEngine re = new RulesEngine();
	private GameScore gameScore = re.initScore();
	
	
	public ConsoleLoggingGame() {
		LOG.debug("creating ConsoleLoggingGame instance");
	}
	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.interfaces.AbstractGame#assignPointPlayerA()
	 */
	@Override
	public AbstractGame assignPointPlayerA() throws GameAlreadyOverException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.interfaces.AbstractGame#assignPointPlayerB()
	 */
	@Override
	public AbstractGame assignPointPlayerB() throws GameAlreadyOverException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.interfaces.AbstractGame#isGameRunning()
	 */
	@Override
	public boolean isGameRunning() {
		return gameRunning;
	}

	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.interfaces.AbstractGame#getScore()
	 */
	@Override
	public GameScore getScore() {
		return gameScore;
	}

}
