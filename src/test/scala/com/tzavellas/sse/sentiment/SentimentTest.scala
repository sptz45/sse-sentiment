package com.tzavellas.sse.sentiment

import org.junit.Test
import org.junit.Assert._

class SentimentTest {

  @Test
  def test_comparative(): Unit = {
    val s = Sentiment(2, 10, Set.empty, Set.empty)
    assertEquals(0.2, s.comparative, delta)
  }

  private def delta = 0.001
}