(ns pbt.generators-test
  "Tests for Chapter 4: Custom Generators."
  (:require [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            #_[pbt.generators :as generators]))

(def gen-key gen/int)
(def gen-value gen/any)

(defspec prop-dupes
  20
  (prop/for-all [kv (gen/vector (gen/tuple gen-key gen-value))]
    (let [m (into {} kv)]
      (not-any?
       #(= :not-found %)
       (map
        (fn key? [[k _v]]
          (get m k :not-found))
        kv)))))
