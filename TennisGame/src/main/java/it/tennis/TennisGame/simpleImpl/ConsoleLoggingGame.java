/**
 * 
 */
package it.tennis.TennisGame.simpleImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.tennis.TennisGame.GameScore;
import it.tennis.TennisGame.exception.GameAlreadyOverException;
import it.tennis.TennisGame.interfaces.AbstractGame;

/**
 * @author mnanni
 *
 */
public class ConsoleLoggingGame implements AbstractGame {
	private static Logger LOG = LoggerFactory.getLogger(ConsoleLoggingGame.class);
	
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
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.interfaces.AbstractGame#getScore()
	 */
	@Override
	public GameScore getScore() {
		// TODO Auto-generated method stub
		return null;
	}

}
