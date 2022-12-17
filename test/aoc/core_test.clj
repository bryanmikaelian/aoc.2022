(ns aoc.core.test
  (:require [clojure.test :as t :refer [is  testing]]
            [aoc.core :as aoc]))



(testing "Advent of Code 2022"
  (testing "day1"
    (is (= 71924 (aoc/top)))
    (is (= 210406 (reduce + (aoc/topn 3))))))

(t/run-all-tests)
