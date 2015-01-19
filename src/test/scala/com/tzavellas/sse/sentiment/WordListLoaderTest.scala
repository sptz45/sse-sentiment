package com.tzavellas.sse.sentiment

import org.junit.Test
import org.junit.Assert._
import scala.io.Source

class WordListLoaderTest {
  
  @Test
  def should_load_the_default_list(): Unit = {
    val wl = WordListLoader.loadDefault()
    assertEquals(2, wl.valenceOf("zealous"))
  }
  
  @Test
  def should_load_any_tab_separated_file(): Unit = {
    val src = Source.fromString("zealous\t2\nbad\t3")
    val wl = WordListLoader.loadFrom(src)
    assertEquals(2, wl.valenceOf("zealous"))
    assertEquals(3, wl.valenceOf("bad"))
  }

}