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
