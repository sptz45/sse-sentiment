package com.tzavellas.sse.sentiment

import org.junit.Test
import org.junit.Assert._

class TokenizerTest {

  @Test
  def should_convert_to_lower_case(): Unit = {
    assertEqualTokens(Seq("hello"), Tokenizer.tokenize("Hello"))
  }
  
  @Test
  def should_remove_non_alpha_characters(): Unit = {
    assertEqualTokens(Seq("onlyalphachars"), Tokenizer.tokenize("#only??alphach^^ars!!!"))
    assertEqualTokens(Seq("onlyalphachars"), Tokenizer.tokenize("#only??ALPHAch^^ars!!!"))
  }

  @Test
  def should_split_the_words(): Unit = {
    assertEqualTokens(Seq("hello", "world"), Tokenizer.tokenize("Hello World!"))
    assertEqualTokens(Seq("hello", "world"), Tokenizer.tokenize("Hello    World!"))
    assertEqualTokens(Seq("hello", "world"), Tokenizer.tokenize("Hello\nWorld!"))
  }

  private def assertEqualTokens(expected: Seq[String], actual: Array[String]) = {
    assertEquals(expected, actual.toSeq)
  }
}