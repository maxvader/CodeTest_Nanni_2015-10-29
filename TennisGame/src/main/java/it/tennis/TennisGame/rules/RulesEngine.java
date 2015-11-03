package it.tennis.TennisGame.rules;

import it.tennis.TennisGame.GameScore;
import it.tennis.TennisGame.Constants.PlayerScore;

public class RulesEngine {

	public GameScore initScore() {
		return new GameScore(PlayerScore.LOVE, PlayerScore.LOVE);
	}

	public boolean assignPointA(GameScore gameScore) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean assignPointB(GameScore gameScore) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
