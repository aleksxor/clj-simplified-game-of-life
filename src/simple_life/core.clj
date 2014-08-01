(ns simple-life.core
  (:gen-class))

(defn next-cell [coll]
  (if (= 1 (reduce + coll))
    1
    0))

(defn next-gen [coll]
  (map next-cell
       (partition 3 1 (concat '(0) coll '(0)))))

(defn age [num-gens universe]
  (def u (atom universe))
  (dotimes [n num-gens]
    (swap! u next-gen))
  (deref u))

(defn universe [num-cells]
  (take num-cells (repeatedly #(rand-int 2))))

(defn -main
  "Runs a random universe of num-cells for num-gens generations"
  [num-cells num-gens]
  (println (age (Integer/parseInt num-gens)
                (universe (Integer/parseInt num-cells)))))
