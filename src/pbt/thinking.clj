(ns pbt.thinking
  "Chapter 3: Thinking in Properties.")

(defn biggest
  "Find the biggest integer in a list."
  [v]
  (loop [[head & tail] v
         big head]
    (cond
      (nil? head) big
      (<= big head) (recur tail head)
      (< head big) (recur tail big))))
