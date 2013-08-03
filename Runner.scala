class Runner(val filename: String, val title: String, val columns: Int, val extension: String = "png") {
  import s4gnuplot.Gnuplot
  val (terminal, outputfile) = 
    (extension match {
      case "pdf" => "pdf"
      case "png" => "png transparent"
      case "eps" => "postscript eps"
      case "svg" => "svg"
    }, s"graphs/eval_$filename.$extension")
  val inputfile = s"csv_files/$filename.csv"
  // val terminal = 
    // "pdf"
    // "pngcairo transparent"
    // "png transparent"
  Gnuplot.run(s"""
set terminal $terminal enhanced font "Verdana,12" size 600, 400 
set output '$outputfile'
set key inside left top vertical noreverse noenhanced autotitles
set datafile missing '-'
set datafile separator ","
set style data linespoints
set xlabel "Number of Iterations"
set ylabel "Time (ms)"
set xtics border in scale 1,0.5 nomirror offset character 0, 0, 0 autojustify
set xtics  norangelimit font ",8"
set xtics   ()
set title "$title" 
set title font ",16,bold" 
n = ${columns + 1}
plot '$inputfile' using 2:xtic(1) title columnheader(2), for [i=3:n] '' using i title columnheader(i)
    """)
}