package com.tzavellas.sse.sentiment

import scala.io.{ Source, Codec }
import scala.collection.mutable

object WordListLoader {

  private implicit val codec = Codec.UTF8

  private val defaultFile = "/AFINN/AFINN-111.txt"

  def loadDefault(): WordList = {
    val in = getClass.getResourceAsStream(defaultFile)
    WordListLoader.loadFrom(Source.fromInputStream(in))
  }

  def loadFrom(source: Source): WordList = {
    val words = mutable.Map[String, Int]()
    for (line <- source.getLines()) {
      val parsed = parseLine(line)
      words += (parsed(0) -> parsed(1).toInt)
    }
    new WordList(words.toMap)
  }

  private def parseLine(line: String) = line.split("\\t")
}
