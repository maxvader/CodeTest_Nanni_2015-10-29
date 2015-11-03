/**
 * 
 */
package it.tennis.TennisGame.simpleImpl;

import it.tennis.TennisGame.exception.GameAlreadyOverException;
import it.tennis.TennisGame.interfaces.AbstractGame;
import it.tennis.TennisGame.models.GameScore;
import it.tennis.TennisGame.rules.RulesEngine;
import it.tennis.TennisGame.rules.RulesEngineInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mnanni
 *
 */
public class ConsoleLoggingGame implements AbstractGame {
	private static Logger LOG = LoggerFactory.getLogger(ConsoleLoggingGame.class);
	
	private boolean gameRunning=Boolean.TRUE;
	private RulesEngineInterface rulesEngine;
	private GameScore gameScore;
	
	
	public ConsoleLoggingGame(RulesEngineInterface rulesEngine) {
		LOG.debug("creating ConsoleLoggingGame instance");
		this.rulesEngine = rulesEngine;
		this.gameScore = this.rulesEngine.initScore();
	}
	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.interfaces.AbstractGame#assignPointPlayerA()
	 */
	@Override
	public AbstractGame assignPointPlayerA() throws GameAlreadyOverException {
		if(!this.isGameRunning()) throw new GameAlreadyOverException("game already over");
		gameRunning = rulesEngine.assignPointA(gameScore);
		LOG.debug(this.getScore().toString());
		return this;
	}

	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.interfaces.AbstractGame#assignPointPlayerB()
	 */
	@Override
	public AbstractGame assignPointPlayerB() throws GameAlreadyOverException {
		if(!this.isGameRunning()) throw new GameAlreadyOverException("game already over");
		gameRunning = rulesEngine.assignPointB(gameScore);
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
