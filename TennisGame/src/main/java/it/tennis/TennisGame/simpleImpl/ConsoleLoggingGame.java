/**
 * 
 */
package it.tennis.TennisGame.simpleImpl;

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
	//can potentially inject custom rules engine but will skip this time.
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
		gameRunning = re.assignPointA(gameScore);
		LOG.debug(this.getScore().toString());
		return this;
	}

	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.interfaces.AbstractGame#assignPointPlayerB()
	 */
	@Override
	public AbstractGame assignPointPlayerB() throws GameAlreadyOverException {
		gameRunning = re.assignPointB(gameScore);
		LOG.debug(this.getScore().toString());
		return this;
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
