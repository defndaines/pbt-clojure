(ns pbt.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]
            [pbt.core :as pbt]))


;; Sanity check of test.check

(defn a-boolean [_] true)

(defspec prop-boolean
  100
  (prop/for-all [x gen/any]
    (a-boolean x)))


;; Chapter 2. Writing Properties
;; Find biggest element in list.

(defspec prop-biggest
  100
  (prop/for-all [v (gen/such-that not-empty (gen/vector gen/int))]
    (= (last (sort v))
       (pbt/biggest v))))


(comment

  (require '[clojure.test.check :as tc])
  (require '[clojure.test.check.generators :as gen])
  (require '[clojure.test.check.properties :as prop])

  (def boolean-property
    (prop/for-all [x gen/any]
      (a-boolean x)))

  (tc/quick-check 100 boolean-property)

  )
