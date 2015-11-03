package it.tennis.TennisGame.rules;

import it.tennis.TennisGame.models.GameScore;
/**
 * Rules engine, it could and should have been a interface implementation,
 * injected in the game BY the factory!!!
 *  not done for lack of time
 * @author mnanni
 *
 */
public class RulesEngine {

	public GameScore initScore() {
		return new GameScore(GameScore.PlayerScore.LOVE, GameScore.PlayerScore.LOVE);
	}

	/**
	 * Updates values in the GameScore parameters and returns "is game running"
	 * @param gameScore
	 * @return
	 */
	public boolean assignPointA(GameScore gameScore) {
		return assignPointToFirst(gameScore);
	}

	private boolean assignPointToFirst(GameScore gameScore) {
		int numA = gameScore.getScoreA().ordinal();
		int numB = gameScore.getScoreB().ordinal();
		if(numA<3){
			numA++;
			gameScore.setScoreA(GameScore.PlayerScore.values()[numA]);
			if(numA==3 && numB==3){
				gameScore.setScoreA(GameScore.PlayerScore.DEUCE);
				gameScore.setScoreB(GameScore.PlayerScore.DEUCE);
			}
		}else {if(numA>=3){
			if(numB==5){
				gameScore.setScoreA(GameScore.PlayerScore.ADVANTAGE);
				gameScore.setScoreB(GameScore.PlayerScore.FORTY);
			}else{
				gameScore.setScoreA(GameScore.PlayerScore.WON);
				return false;
			}
		}
		}
		return true;
	}

	/**
	 * Updates values in the GameScore parameters and returns "is game running".
	 * Uses a dirty hack because of poor design of GameScore
	 * @param gameScore
	 * @return
	 */
	public boolean assignPointB(GameScore gameScore) {
		GameScore swapCopy = swapScore(new GameScore(gameScore));
		boolean tmp = assignPointToFirst(swapCopy);
		gameScore.setScoreA(swapCopy.getScoreB());
		gameScore.setScoreB(swapCopy.getScoreA());
		return tmp;
	}

	private GameScore swapScore(GameScore gs){
		return new GameScore(gs.getScoreB(), gs.getScoreA());
	}


}
