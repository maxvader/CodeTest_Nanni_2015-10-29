/**
 * 
 */
package it.tennis.TennisGame.play;

import it.tennis.TennisGame.exception.GameAlreadyOverException;
import it.tennis.TennisGame.interfaces.AbstractFactory;
import it.tennis.TennisGame.interfaces.AbstractGame;

import java.util.Random;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mnanni
 *
 */
public class SimpleMatchSimulator {
	private static Logger LOG = LoggerFactory
			.getLogger(SimpleMatchSimulator.class);

	@Inject
	AbstractFactory abstractFactory;

	public void playGame() {
		Random rand = new Random();
		AbstractGame game = abstractFactory.createGame();
		while (game.isGameRunning()) {
			int value = rand.nextInt(2);
			try {
				if (value == 0) {
					game.assignPointPlayerA();

				} else {
					game.assignPointPlayerB();
				}
			} catch (GameAlreadyOverException e) {
				LOG.error("Attempting to assign point but game already over", e);
				return;
			}
		}
		System.out.println("Game result is " + game.getScore());
	}
}
