package it.tennis.TennisGame;

import it.tennis.TennisGame.play.SimpleMatchSimulator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

	private static Logger LOG = LoggerFactory.getLogger(Launcher.class);

		public static void main(String[] args) {
			LOG.info("loading application context");
			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"META-INF/application-context.xml");

			SimpleMatchSimulator tennis = context.getBean(SimpleMatchSimulator.class);
			LOG.info("starting game");
			tennis.playGame();
		}
}
