package it.tennis.TennisGame.rules;

import it.tennis.TennisGame.models.GameScore;

import javax.inject.Named;
/**
 * Rules engine
 * @author mnanni
 *
 */
@Named
public class RulesEngine implements RulesEngineInterface {

	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.rules.RulesEngineInterface#initScore()
	 */
	@Override
	public GameScore initScore() {
		return new GameScore(GameScore.PlayerScore.LOVE, GameScore.PlayerScore.LOVE);
	}

	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.rules.RulesEngineInterface#assignPointA(it.tennis.TennisGame.models.GameScore)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see it.tennis.TennisGame.rules.RulesEngineInterface#assignPointB(it.tennis.TennisGame.models.GameScore)
	 */
	@Override
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
