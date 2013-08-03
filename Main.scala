object Main {
  def main(args: Array[String]) {
    val filenames = args.toList match {
      case Nil => List("Selection.equalityConstant" -> "Simple Selection" -> 3,
      	"Selection.inequalityCaptured" -> "Parameterized Selection" -> 4,
        "Insertion.constantValue" -> "Inserting a Constant Value" -> 3,
        "Insertion.capturedValue" -> "Inserting Different Values" -> 3,
        "Update.constantWhereConstantUpdate" -> "Update Case I" -> 3,
        // "Update.constantWhereCapturedUpdate" -> "Update Case II" -> 3,
        "Update.capturedWhereCapturedUpdate" -> "Update Case II" -> 3,
        "Update.complex" -> "Update Case III" -> 3
      )
      case _ => List()
    }
    filenames foreach { case ((filename, title), columns) => 
      new Runner(s"$filename", title, columns, "png")
    }
  }
}