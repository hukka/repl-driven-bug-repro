(ns repro
  (:require
   [repro2]
   [clojure.tools.logging :refer [info]]))

(defn func-b []
  (info "Called func-b: 1")
  (repro2/read))

(comment
  (func-b))

(comment
  "To reproduce
  0) Launch a new, clean REPL
  1) evaluate this buffer
  2) evaluate above commented funtion call
     observe the prints
  3) change and re-evaluate repro2/read
  4) evaluate above funtion call
     observe that the logged strings didn't change: `repro2/read` is still original

  To work around, try:
  0) Launch a new, clean REPL
  1) evaluate this buffer
  2) evaluate `func-b` again
  3) try changing repro2/read, evaluate it, evaluate the funtion call and observe that new version of `repro2/read` is actually called

  Also note that this behaviour is identical if the function `repro2/read` is named like any other function in core.
  If it is named anything else, like read2, the problem cannot be reproduced.
  ")
