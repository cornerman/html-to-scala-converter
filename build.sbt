enablePlugins(ScalaJSPlugin)

name := "HtmlToScalaTagsConverter"

version := "1.0.0"

scalaVersion := "2.13.6"

scalaJSUseMainModuleInitializer := true

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "1.2.0",
  "com.lihaoyi" %%% "scalatags" % "0.9.4"
)
