# sbt-strict-scala-versions

Ensures sbt is only started with Scala versions that are allowed by the build

## Usage

Simply add the plugin to your `project/plugins.sbt`:

    addSbtPlugin("net.bzzt" % "sbt-reproducible-builds" % "<current_version>")

## Behavior

When you have specified `scalaVersion := "2.12.8"` in your build, after loading
this plugin you can no longer start sbt with `sbt ++2.12.7 shell`.

### Cross-scala versions

When you have specified `crossScalaVersions := Seq("2.12.8", "2.13.0")` in your
build, you can start sbt with `sbt ++2.12.8 shell` or `sbt ++2.13.0 shell`, but
not `sbt ++2.12.9 shell`.
