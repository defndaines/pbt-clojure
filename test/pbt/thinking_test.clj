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
