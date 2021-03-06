/**
 * 
 */
package it.tennis.TennisGame.simpleImpl;

import it.tennis.TennisGame.interfaces.AbstractFactory;
import it.tennis.TennisGame.interfaces.AbstractGame;
import it.tennis.TennisGame.rules.RulesEngineInterface;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mnanni
 *
 */
@Named
public class SimpleFactory implements AbstractFactory {
	private static Logger LOG = LoggerFactory.getLogger(SimpleFactory.class);
	
	@Inject
	RulesEngineInterface rulesEngine;
	
	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.interfaces.AbstractFactory#createGame()
	 */
	@Override
	public AbstractGame createGame() {
		LOG.debug("Creating game instance");
		return new ConsoleLoggingGame(rulesEngine);
	}

}
