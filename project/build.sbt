if (sys.props("gilt.internal.build") == "true")
  addSbtPlugin("com.giltgroupe" % "gilt-sbt-build" % "3.1.9")
else seq()
