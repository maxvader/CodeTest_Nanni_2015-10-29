package it.tennis.TennisGame;

import it.tennis.TennisGame.Constants.PlayerScore;
import it.tennis.TennisGame.interfaces.AbstractGame;
import it.tennis.TennisGame.simpleImpl.SimpleFactory;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-context.xml" })
public class GameTest {
	@Inject
	SimpleFactory simpleFactory;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewGameNotOver() {
		AbstractGame ag = simpleFactory.createGame();
		Assert.assertTrue(ag.isGameRunning());
	}
	
	@Test
	public void testInitialScore(){
		AbstractGame ag = simpleFactory.createGame();
		GameScore score = ag.getScore();
		Assert.assertTrue(
				PlayerScore.LOVE.equals(score.getScoreA()) && 
				PlayerScore.LOVE.equals(score.getScoreB()));
	}

}
