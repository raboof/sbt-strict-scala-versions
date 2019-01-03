package net.bzzt.strictscalaversions

import sbt.AutoPlugin
import sbt.settingKey
import sbt.Keys.crossScalaVersions
import sbt.Keys.scalaVersion

object StrictScalaVersionsPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    val strictScalaVersionCheck = settingKey[Unit]("strict-scala-version-check")
  }
  import autoImport._

  override lazy val projectSettings = Seq(
    strictScalaVersionCheck := {
      if (!crossScalaVersions.value.contains(scalaVersion.value))
        throw new IllegalStateException(
          s"Scala version ${scalaVersion.value} not allowed, " +
          s"""choose one of ${crossScalaVersions.value.mkString("[", ", ", "]")}.""")
      ()
    }
  )
}
