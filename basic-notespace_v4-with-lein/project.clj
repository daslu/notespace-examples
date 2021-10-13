(defproject basic-notespace_v4-with-lein "0.1.0-SNAPSHOT"
  :description "Using Notespace v4 in a Leiningen project"
  :url "https://github.com/scicloj/notespace-examples/tree/main/basic-notespace_v4-with-lein"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [scicloj/notespace "4-alpha-4"] ]
  :repl-options {:nrepl-middleware [scicloj.notespace.v4.nrepl/middleware]})
