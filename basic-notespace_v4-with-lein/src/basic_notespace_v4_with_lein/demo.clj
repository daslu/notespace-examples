; # Notespace v4 tutorial

; ## Setup

(ns basic-notespace-v4-with-lein.demo
  (:require [scicloj.notespace.v4.api :as notespace]
            [scicloj.kindly.api :as kindly]
            [scicloj.kindly.kind :as kind]))

;; To start (or restart) Notespace, use the following call:

(comment
  (notespace/restart!))

(+ 1 2)
