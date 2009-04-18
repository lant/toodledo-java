package org.loststone.toodledo.util;

/**
 * Static classes and singletons are bad. God kills a kitten every time you code one of those.
 * Really. What's the problem in instating an object?
 * @author lant
 *
 */
public class TextEncoder {
	public String encode(String original) {
		return original.replace("&", "%26").replace(";", "%3B");
	}
}
