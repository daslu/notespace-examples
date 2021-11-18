; # Notespace v4 tutorial

; ## Setup

(ns basic-notespace-v4-with-deps.demo
  (:require [scicloj.notespace.v4.api :as notespace]
            [scicloj.kindly.api :as kindly]
            [scicloj.kindly.kind :as kind]))

;; To start (or restart) Notespace, use the following call:
(comment
  (notespace/restart!))

;; Browse localhost:1903 to see the browser view.

(+ 1 2)
