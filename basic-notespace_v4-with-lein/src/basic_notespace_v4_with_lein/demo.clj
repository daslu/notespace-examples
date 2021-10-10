(ns basic-notespace-v4-with-lein.demo
  (:require [scicloj.notespace.v4.api :as notespace]))

(comment
  (notespace/restart! {})
  (notespace/restart-events!))

(+ 1 2)
