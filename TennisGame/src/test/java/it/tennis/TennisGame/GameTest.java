package it.tennis.TennisGame;

import it.tennis.TennisGame.exception.GameAlreadyOverException;
import it.tennis.TennisGame.interfaces.AbstractFactory;
import it.tennis.TennisGame.interfaces.AbstractGame;
import it.tennis.TennisGame.models.GameScore;

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
	AbstractFactory simpleFactory;

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
				GameScore.PlayerScore.LOVE.equals(score.getScoreA()) && 
				GameScore.PlayerScore.LOVE.equals(score.getScoreB()));
	}
	
	@Test(expected=GameAlreadyOverException.class)
	public void testMoreThanAllowedPoints() throws GameAlreadyOverException{
		AbstractGame ag = simpleFactory.createGame();
		for(int i=0; i <= 5; i++){
			ag.assignPointPlayerA();
		}
	}
	
	@Test
	public void testDeuce() throws GameAlreadyOverException{
		AbstractGame ag = simpleFactory.createGame();
		GameScore score = ag.assignPointPlayerA().assignPointPlayerA().assignPointPlayerA()
				.assignPointPlayerB().assignPointPlayerB().assignPointPlayerB().getScore();
		Assert.assertTrue(
				GameScore.PlayerScore.DEUCE.equals(score.getScoreA()) && 
				GameScore.PlayerScore.DEUCE.equals(score.getScoreB()));
	}
	
	/**
	 * Case for b should be coded
	 * @throws GameAlreadyOverException
	 */
	@Test
	public void testAdvantageA() throws GameAlreadyOverException{
		AbstractGame ag = simpleFactory.createGame();
		GameScore score = ag.assignPointPlayerA().assignPointPlayerA().assignPointPlayerA()
				.assignPointPlayerB().assignPointPlayerB().assignPointPlayerB().assignPointPlayerA().getScore();
		Assert.assertTrue(
				GameScore.PlayerScore.ADVANTAGE.equals(score.getScoreA()) && 
				GameScore.PlayerScore.FORTY.equals(score.getScoreB()));
	}
	
	/**
	 * Case for b shuld be coded
	 * @throws GameAlreadyOverException
	 */
	@Test
	public void testWinA() throws GameAlreadyOverException{
		AbstractGame ag = simpleFactory.createGame();
		GameScore score = ag.assignPointPlayerA().assignPointPlayerA().assignPointPlayerA()
				.assignPointPlayerB().assignPointPlayerB().assignPointPlayerB().assignPointPlayerA()
				.assignPointPlayerA().getScore();
		Assert.assertTrue(
				GameScore.PlayerScore.WON.equals(score.getScoreA()) && 
				GameScore.PlayerScore.FORTY.equals(score.getScoreB()));
	}

}
