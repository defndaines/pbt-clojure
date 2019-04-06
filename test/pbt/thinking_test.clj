(ns pbt.thinking-test
  (:require [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [pbt.thinking :as pbt]))


;; Chapter 3. Thinking in Properties
;; Find biggest element in list.

(declare model-biggest)

(defspec prop-biggest
  100
  (prop/for-all [v (gen/such-that not-empty (gen/vector gen/int))]
    (= (model-biggest v)
       (pbt/biggest v))))

(defn model-biggest  ; note: The function doesn't have to appear before use!
  [s]
  (last (sort s)))


(defspec prop-last
  100
  ;; pick a list and a last number.
  (prop/for-all [gend-list (gen/vector gen/int)
                 known-last gen/int]
    (let [known-list (conj gend-list known-last)]
      (= known-last (last known-list)))))


(defn ordered?
  "Given a sequence, assert if each pair is ordered."
  [s]
  (every?
    (fn ordered-pair [[a b]] (<= 0 (compare b a)))
    (partition 2 1 s)))

(def gen-list-of-comparable
  "Unlike in Erlang, where all terms are comparable, we must limit our tests
  against sort to things that extend java.lang.Comparable. Additionally, all
  elements of a list must be sortable amongst themselves (i.e., we cannot
  compare a number to a string). For doubles, NaN is not comparable, so
  exclude."
  (gen/one-of [(gen/list gen/boolean)
               (gen/list gen/byte)
               (gen/list gen/char)
               (gen/list (gen/double* {:NaN? false}))
               (gen/list gen/keyword)
               (gen/list gen/keyword-ns)
               (gen/list gen/large-integer)
               (gen/list gen/ratio)
               (gen/list gen/string)
               (gen/list gen/uuid)]))

(defspec prop-sort
  100
  (prop/for-all [s gen-list-of-comparable]
    (ordered? (sort s))))
