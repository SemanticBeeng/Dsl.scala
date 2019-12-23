// shadow sbt-scalajs' crossProject(JSPlatform, JVMPlatform) and CrossType from Scala.js 0.6.x
import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

lazy val `compilerplugins-BangNotation` = project
  .dependsOn(DslJVM % Test, DslJVM % Provided)
  .settings(
    scalacOptions in Test += raw"""-Xplugin:${(packageBin in Compile).value}""",
    scalacOptions in Test += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
  )

lazy val `compilerplugins-ResetEverywhere` = project.dependsOn(DslJVM % Test, DslJVM % Provided)

lazy val Dsl =
  crossProject(JSPlatform, JVMPlatform).crossType(CrossType.Pure).build()
lazy val DslJS = Dsl.js
lazy val DslJVM = Dsl.jvm

lazy val `domains-task` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(`keywords-Shift`, `keywords-Fork` % Test, `keywords-Using` % Test, `keywords-Yield` % Test)
lazy val `domains-taskJS` = `domains-task`.js
lazy val `domains-taskJVM` = `domains-task`.jvm

lazy val `keywords-Fork` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl, `keywords-Shift`, `keywords-Catch`, `keywords-Continue`, `keywords-Each`)
lazy val `keywords-ForkJS` = `keywords-Fork`.js
lazy val `keywords-ForkJVM` = `keywords-Fork`.jvm

lazy val `keywords-Return` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl)

lazy val `keywords-ReturnJS` = `keywords-Return`.js
lazy val `keywords-ReturnJVM` = `keywords-Return`.jvm

lazy val `keywords-Continue` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl, `keywords-Each` % Test)

lazy val `keywords-ContinueJS` = `keywords-Continue`.js
lazy val `keywords-ContinueJVM` = `keywords-Continue`.jvm

lazy val `keywords-Get` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl)

lazy val `keywords-GetJS` = `keywords-Get`.js
lazy val `keywords-GetJVM` = `keywords-Get`.jvm

lazy val `keywords-Put` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl, `keywords-Get` % Test, `keywords-Yield` % Test, `keywords-Return` % Test)
lazy val `keywords-PutJS` = `keywords-Put`.js
lazy val `keywords-PutJVM` = `keywords-Put`.jvm

lazy val `keywords-AsynchronousIo` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(`keywords-Shift`)
lazy val `keywords-AsynchronousIoJS` = `keywords-AsynchronousIo`.js
lazy val `keywords-AsynchronousIoJVM` = `keywords-AsynchronousIo`.jvm

lazy val `keywords-Shift` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl)
lazy val `keywords-ShiftJS` = `keywords-Shift`.js
lazy val `keywords-ShiftJVM` = `keywords-Shift`.jvm

lazy val `keywords-Using` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl, `keywords-Shift`, `keywords-Catch`)
lazy val `keywords-UsingJS` = `keywords-Using`.js
lazy val `keywords-UsingJVM` = `keywords-Using`.jvm

lazy val `keywords-Catch` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl, `keywords-Shift`, `keywords-Yield` % Test)
lazy val `keywords-CatchJS` = `keywords-Catch`.js
lazy val `keywords-CatchJVM` = `keywords-Catch`.jvm

lazy val `keywords-NoneSafe` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl, `keywords-Return`)
lazy val `keywords-NoneSafeJS` = `keywords-NoneSafe`.js
lazy val `keywords-NoneSafeJVM` = `keywords-NoneSafe`.jvm

lazy val `keywords-NullSafe` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl)
lazy val `keywords-NullSafeJS` = `keywords-NullSafe`.js
lazy val `keywords-NullSafeJVM` = `keywords-NullSafe`.jvm

lazy val `keywords-Each` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl, `keywords-Shift`, `keywords-Yield` % Test)
lazy val `keywords-EachJS` = `keywords-Each`.js
lazy val `keywords-EachJVM` = `keywords-Each`.jvm

lazy val `keywords-Await` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl, `keywords-Yield` % Test, `domains-task` % Test, `keywords-Return` % Test, `keywords-Catch` % Test)
lazy val `keywords-AwaitJS` = `keywords-Await`.js
lazy val `keywords-AwaitJVM` = `keywords-Await`.jvm

lazy val `keywords-Yield` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl, `keywords-Shift` % Test)
lazy val `keywords-YieldJS` = `keywords-Yield`.js
lazy val `keywords-YieldJVM` = `keywords-Yield`.jvm

lazy val `keywords-Monadic` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .dependsOn(Dsl)
lazy val `keywords-MonadicJS` = `keywords-Monadic`.js
lazy val `keywords-MonadicJVM` = `keywords-Monadic`.jvm

lazy val `domains-scalaz` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl,
               `keywords-Catch`,
               `keywords-Monadic`,
               `keywords-Return`,
               `keywords-Shift` % Test,
               `keywords-Yield` % Test)
lazy val `domains-scalazJS` = `domains-scalaz`.js
lazy val `domains-scalazJVM` = `domains-scalaz`.jvm

lazy val `domains-cats` =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .settings(
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
      scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
    )
    .dependsOn(Dsl,
               `keywords-Catch`,
               `keywords-Monadic`,
               `keywords-Return`,
               `keywords-Shift` % Test,
               `keywords-Yield` % Test)

lazy val `domains-catsJVM` = `domains-cats`.jvm
lazy val `domains-catsJS` = `domains-cats`.js

lazy val `package` = project
  .settings(
    scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-BangNotation` in Compile).value}""",
    scalacOptions += raw"""-Xplugin:${(packageBin in `compilerplugins-ResetEverywhere` in Compile).value}"""
  )
  .dependsOn(
    `domains-catsJVM`,
    `domains-scalazJVM`,
    `keywords-GetJVM`,
    `keywords-PutJVM`,
    `keywords-ContinueJVM`,
    `keywords-ReturnJVM`,
    `keywords-ShiftJVM`,
    `keywords-EachJVM`,
    `keywords-YieldJVM`,
    `keywords-ForkJVM`,
    `keywords-NoneSafeJVM`,
    `keywords-NullSafeJVM`,
    `keywords-AwaitJVM`,
    `keywords-AsynchronousIoJVM`,
    `keywords-UsingJVM`,
    `domains-taskJVM`,
    DslJVM
  )

organization in ThisBuild := "com.thoughtworks.dsl"

scalacOptions in ThisBuild ++= {
  if (scalaBinaryVersion.value == "2.11") {
    Some("-Ybackend:GenBCode")
  } else {
    None
  }
}

lazy val unidoc =
  project
    .enablePlugins(ScalaUnidocPlugin)
    .settings(
      publishArtifact := false,
      unidocProjectFilter in ScalaUnidoc in BaseUnidocPlugin.autoImport.unidoc := {
        import Ordering.Implicits._
        if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
          // Workaround for https://github.com/scala/bug/issues/11045
          (
            inDependencies(`package`) ||
            inDependencies(`compilerplugins-BangNotation`) ||
            inDependencies(`compilerplugins-ResetEverywhere`)
          ) --
            inProjects(DslJVM,
                       `keywords-ContinueJVM`,
                       `keywords-YieldJVM`,
                       `domains-taskJVM`,
                       `keywords-EachJVM`,
                       `keywords-ForkJVM`)
        } else {
          inDependencies(`package`) ||
          inDependencies(`compilerplugins-BangNotation`) ||
          inDependencies(`compilerplugins-ResetEverywhere`)
        }
      },
      addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.7"),
      scalacOptions += "-Xexperimental",
      scalacOptions ++= {
        import Ordering.Implicits._
        if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
          Seq("-Ymacro-annotations")
        } else {
          Nil
        }
      },
      libraryDependencies ++= {
        import Ordering.Implicits._
        if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
          Nil
        } else {
          Seq(compilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full))
        }
      }
    )

skip in publish := true

parallelExecution in Global := {
  import Ordering.Implicits._
  VersionNumber(scalaVersion.value).numbers >= Seq(2L, 12L)
}

