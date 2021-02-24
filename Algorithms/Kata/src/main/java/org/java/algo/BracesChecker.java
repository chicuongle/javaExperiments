package org.java.algo;

import java.util.Map;
import java.util.Stack;

public class BracesChecker {
  private final Map<Character, Character> PAIR =
      Map.ofEntries(Map.entry('(', ')'), Map.entry('[', ']'), Map.entry('{', '}'));

  public boolean isValid(String braces) {
    System.out.println("Input " + braces);
    Stack<Character> stack = new Stack<>();
    boolean shouldBePopped = false;
    for (int i = 0; i < braces.length(); i++) {
      Character ch = braces.charAt(i);
      if ((stack.empty() || !otherPair(stack.peek(), ch)) && !shouldBePopped) {
        stack.push(ch);
      } else if ((!stack.empty()) && otherPair(stack.peek(), ch)) {
        stack.pop();
        shouldBePopped = !stack.empty();
      } else {
        shouldBePopped = false;
      }
    }

    return stack.empty();
  }

  private boolean otherPair(Character ch, Character char2) {
    if (!PAIR.containsKey(ch)) {
      return false;
    }
    return PAIR.get(ch).equals(char2);
  }
}
