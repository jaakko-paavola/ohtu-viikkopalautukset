/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author jaakkpaa
 */
public class All implements Matcher {
	private Matcher[] matchers;

	@Override
	public boolean matches(Player p) {
		return true;	
	}

	public All(Matcher... matchers) {
        this.matchers = matchers;		
	}
	
}
