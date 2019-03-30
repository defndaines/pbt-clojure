(ns pbt.core)

(defn biggest
  "Find the biggest integer in a list."
  [v]
  (loop [[head & tail] v
         big head]
    (cond
      (nil? head) big
      (<= big head) (recur tail head)
      (< head big) (recur tail big))))

(defn increments?
  "Question 2"
  [s]
  (loop [[head & tail] s]
    (let [[n & _] tail]
      (cond
        (nil? n) true
        (= n (+ 1 head)) (recur tail)
        :else false))))
