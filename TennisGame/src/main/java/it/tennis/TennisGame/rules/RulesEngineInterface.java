package it.tennis.TennisGame.rules;

import it.tennis.TennisGame.models.GameScore;

public interface RulesEngineInterface {

	public abstract GameScore initScore();

	/**
	 * Updates values in the GameScore parameters and returns "is game running"
	 * @param gameScore
	 * @return
	 */
	public abstract boolean assignPointA(GameScore gameScore);

	/**
	 * Updates values in the GameScore parameters and returns "is game running".
	 * Uses a dirty hack because of poor design of GameScore
	 * @param gameScore
	 * @return
	 */
	public abstract boolean assignPointB(GameScore gameScore);

}