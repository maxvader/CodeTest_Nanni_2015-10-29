package it.tennis.TennisGame.models;


/**
 * Represents the game score
 * @author mnanni
 *
 */
public class GameScore {
	/**
	 * Represents score for a player
	 * @author mnanni
	 *
	 */
	public enum PlayerScore{
		LOVE,
		FIFTEEN,
		THIRTY,
		FORTY,
		ADVANTAGE,
		DEUCE,
		WON
	}

	private GameScore.PlayerScore scoreA,scoreB;

	public GameScore(GameScore.PlayerScore scoreA, GameScore.PlayerScore scoreB) {
		super();
		this.scoreA = scoreA;
		this.scoreB = scoreB;
	}

	public GameScore() {
		super();
	}
	
	public GameScore(GameScore gameScore) {
		this.scoreA = gameScore.getScoreA();
		this.scoreB = gameScore.getScoreB();
	}

	public GameScore.PlayerScore getScoreA() {
		return scoreA;
	}

	public void setScoreA(GameScore.PlayerScore scoreA) {
		this.scoreA = scoreA;
	}

	public GameScore.PlayerScore getScoreB() {
		return scoreB;
	}

	public void setScoreB(GameScore.PlayerScore scoreB) {
		this.scoreB = scoreB;
	}
	
	@Override
	public String toString() {
		return "Player A score: " + this.scoreA.toString() + " Player B score: " + this.scoreB.toString();
	}

}
