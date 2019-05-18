(ns pbt.generators-test
  "Tests for Chapter 4: Custom Generators."
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.test.check.generators :as gen]
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

(defn avg-length
  "Get the average length of a sequence of strings."
  [s]
  (float
   (/ (reduce (fn [acc e] (+ acc (count e))) 0 s)
      (count s))))

(defn report-on-size
  "Report, aka `println`, statistics about a sequence of strings."
  [s]
  (println
   "Size:" (count s)
   "Average:" (avg-length s)
   "Smallest:" (apply min (map count s))
   "Largest:" (apply max (map count s))))

(deftest prop-resize
  (testing "Use of resize to compare to a baseline size."
    (let [size 100
          base-strings (gen/sample gen/string size)
          resized-strings (gen/sample (gen/resize 150 gen/string) size)]
      (println "Difference between sample of strings with resize of 150 applied.")
      (report-on-size base-strings)
      (report-on-size resized-strings)
      (is (< (avg-length base-strings)
             (avg-length resized-strings))))))
