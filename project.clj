(defproject pbt "0.1.0-SNAPSHOT"
  :description "A Clojure work-through of the book Property-Based Testing with
               PropEr, Erlang, and Elixir by Fred Hebert."
  :url "https://github.com/defndaines/pbt-clojure"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/test.check "0.9.0"]]
  :repl-options {:init-ns pbt.core}
  :cljfmt {:remove-consecutive-blank-lines? false
           :indents {for-all [[:inner 0]]}})
