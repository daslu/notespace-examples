;; # Notespace v4

;; Nov. 29th, 2021

:_
;; # Setup

(ns notespace-2021-11-29.demo
  (:require [scicloj.notespace.v4.api :as notespace]
            [scicloj.kindly.api :as kindly]
            [scicloj.kindly.kind :as kind]
            [scicloj.kindly.kindness :as kindness]
            [scicloj.viz.api :as viz]
            [aerial.hanami.templates :as ht]
            [tablecloth.api :as tc]))

;; To start (or restart) Notespace, use the following call:
(comment
  (notespace/restart!))

;; Browse localhost:1903 to see the browser view.

:_

;; # demo

;; hello

(+ 1 21433)

(def x 9)

x

(rand)


;; # Why

;; - documentation -- [scicloj.ml](https://github.com/scicloj/scicloj.ml) -- [models](https://scicloj.github.io/scicloj.ml-tutorials/userguide-models.html)

;; - testable docs / literate testing -- [clojisr](https://github.com/scicloj/clojisr) -- [codgen](https://scicloj.github.io/clojisr/doc/clojisr/v1/codegen-test/)

;; - visual documents -- [clojisr-examples](https://github.com/scicloj/clojisr-examples) -- [ridgeline](https://scicloj.github.io/clojisr-examples/doc/clojisr-examples/graph-gallery/ridgeline/)

;; - reproducible research -- [notespace-sicmutils-example](https://github.com/scicloj/notespace-sicmutils-example) -- [the double pendulum](https://scicloj.github.io/notespace-sicmutils-example/docs/notespace-sicmutils-example/double-pendulum/)

;; - study, exploration -- [ml-study](https://clojurians.zulipchat.com/#narrow/stream/264992-ml-study) -- [image processing](https://scicloj.github.io/ml-study/projects/image-demo-1/docs/image-demo-1/session2-1/) from the ml-study group -- [data visualizations](https://www.youtube.com/watch?v=2tGk1Jh7dJs)

:_


;; # Landscape

;; * browser-based notebooks: **Gorilla-REPL, Clojupyter, IClojure, Nextjournal, Maria.cloud**

;; * literate programming in plaintext: **Org-babel-Clojure, RMarkdown-Clojure**

;; * a unique browser UI: **Saite**

;; * sending visualizations from the REPL - **Reveal, Portal**

;; * a whole stack for diverse UI experiences: **Pink-Gorilla (Goldly, Reval)**

;; * visualizations inside the editor: **REPL-Tooling, Chlorine, Clover**

;; * namespace-as-a-notebook: **Marginalia, Oz, Notespace, Clerk, Goldly**

:_

;; # ns --> notebook

;; - Oz
;; - Notespace
;; - Clerk
;; - Goldly

:_

;; # principles

;; - community driven

;; - flows with the REPL

:_

;; # Interaction

;; - file change

;; - namespace load

;; - region eval

;; - tabs

:_

;; # kinds

;; **code kind**

^kind/hiccup
[:div
 [:p "a plot"]
 [:p/sparklinespot ; Gorilla-UI
 {:data      (->> #(- (rand) 0.5)
                  (repeatedly 99)
                  (reductions +))
  :svgHeight 50}]]

^kind/hiccup
(->> (range 9 99 10)
     (map (fn [i]
            [:p/sparklinespot
             {:data      (->> #(- (rand) 0.5)
                              (repeatedly i)
                              (reductions +))
              :svgHeight 50}]))
     (into [:div]))


;; **value kind**

(-> {:description "A simple bar chart with embedded data."
     :height 50
     :data        {:values [{:a "A" :b 28} {:a "B" :b 55}
                            {:a "C" :b 43}
                            {:a "D" :b (+ 91 (rand-int 9))}
                            {:a "E" :b 81} {:a "F" :b 53}
                            {:a "G" :b 19} {:a "H" :b 87}
                            {:a "I" :b 52}]}
     :mark        :bar
     :encoding    {:x {:field :a :type :nominal :axis {:labelAngle 0}}
                   :y {:field :b :type :quantitative}}}
    (kindly/consider kind/vega))

;; **kindness**

(deftype BigBigBigText [text]
  kindness/Kindness
  (->behaviour [this]
    {:render-src?   true
     :value->hiccup (fn [value]
                      [:big [:big [:big (.text value)]]])}))

(BigBigBigText. "hi!")

;; # Delays

;; When the evaluation value is a Clojure [delay](https://clojuredocs.org/clojure.core/delay), will render by dereferencing the delay.

(delay
  (Thread/sleep 3500)
  (+ 1 233333))

:_

;; # Examples

;; Math in markdown: $\alpha^2$
;;
;; $$x + 1$$
;;

^kind/hiccup
[:div
 [:p/math "\\alpha^2"]
 [:p/math "\\beta^2"]]

(-> {:x (range 9)
     :y (repeatedly 9 rand)}
    (tc/dataset {:dataset-name "my dataset"}))

(-> {:x (range 99)
     :y (->> #(- (rand) 0.5)
             (repeatedly 99)
             (reductions +))}
    viz/data
    (viz/type ht/line-chart)
    viz/viz
    (assoc :height 100))

(import java.awt.image.BufferedImage
        java.awt.Color
        sun.java2d.SunGraphics2D)

(let [n 600
      bi (BufferedImage. (* 2 n) n BufferedImage/TYPE_INT_RGB)
      ^SunGraphics2D g (-> (.createGraphics ^BufferedImage bi))]
  (.setBackground g (Color. 220 210 200))
  (.clearRect g 0 0 (* 2 n) n)
  (dotimes [i 200]
    (->> #(rand-int 128)
         (repeatedly 3)
         (apply #(Color. %1 %2 %3))
         (.setColor g))
    (doseq [j (range (/ n 2))]
        (->> #(+ j (rand-int j))
             (repeatedly 4)
             (apply #(if (< (rand) 0.1)
                       (.drawOval g
                                  (-> (* %2 %2)
                                      (/ (/ n 2))
                                      (rem (* 2 n)))
                                  (-> %1
                                      (Math/sqrt)
                                      (* (+ 1 (/ (Math/sin (/ j 40)) 2)))
                                      (* 20)
                                      (Math/round))
                                  (/ %3 8)
                                  (/ %4 8)))))))
  bi)

;;

:_

;; # Challenges

;; - ergonomics

;; - stability

;; - compatibility

;; - where to go now?

:_



