/**
 * 
 */
package it.tennis.TennisGame;

import it.tennis.TennisGame.Constants.PlayerScore;

/**
 * @author mnanni
 *
 */
public class GameScore {
	private PlayerScore scoreA,scoreB;

	public GameScore(PlayerScore scoreA, PlayerScore scoreB) {
		super();
		this.scoreA = scoreA;
		this.scoreB = scoreB;
	}

	public GameScore() {
		super();
	}
	
	public PlayerScore getScoreA() {
		return scoreA;
	}

	public void setScoreA(PlayerScore scoreA) {
		this.scoreA = scoreA;
	}

	public PlayerScore getScoreB() {
		return scoreB;
	}

	public void setScoreB(PlayerScore scoreB) {
		this.scoreB = scoreB;
	}

}
