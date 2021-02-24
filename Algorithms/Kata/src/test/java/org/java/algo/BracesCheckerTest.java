package org.java.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class BracesCheckerTest {
  private BracesChecker checker = new BracesChecker();

  @Test
  public void testValid() {
    assertEquals(true, checker.isValid("()"));
    assertEquals(true, checker.isValid("(){}[]"));

  }

  @Test
  public void testInvalid() {
    assertEquals(false, checker.isValid("[(])"));
    assertEquals(false, checker.isValid("[({})](]"));

  }
}