
name := "sse-sentiment"
description := "A library for simple sentiment analysis"
startYear := Some(2015)

libraryDependencies ++= Seq(
  "junit"             % "junit"           % "4.11" % Test,
  "com.novocode"      % "junit-interface" % "0.11" % Test
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q")
