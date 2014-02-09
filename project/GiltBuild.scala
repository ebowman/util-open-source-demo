package gilt.os

import sbt._
import sbt.Keys._
import java.lang.reflect._

object GiltProject extends Plugin {
  lazy val inhouse = sys.props("gilt.internal.build") == "true"
  def jarSettings: Seq[Project.Setting[_]] = if (inhouse) {
    val clz = Class.forName("gilt.GiltProject$")
    val method = clz.getMethod("jarSettings")
    val module = clz.getField("MODULE$").get(null)
    println(seq().getClass)
    method.invoke(module).asInstanceOf[Seq[sbt.Project.Setting[_]]]
  } else seq()
}
