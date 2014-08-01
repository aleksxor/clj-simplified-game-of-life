(ns simple-life.core-test
  (:require [clojure.test :refer :all]
            [simple-life.core :refer :all]))

(deftest a-test
  (testing "the next-gen func should generate the next generation of the universe"
    (is (= (next-gen '(0 1 1 0)) '(1 0 0 1))))
  (testing "the age func should iterate over 2 generations of the initial universe"
    (is (= (age 2 '(0 1 1 0)) '(1 1 1 1)))))
