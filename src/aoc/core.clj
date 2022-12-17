(ns aoc.core
  (:require [clojure.java.io :as io]
            [clojure.string :as s]))


(def d1-input (io/resource "day1.txt"))


(defn- group-elves [elves]
  (reduce (fn [acc item]
            (let [rest (pop acc)
                  items (last acc)]
              (prn items)
              (if (s/blank? item)
                (conj acc [])
                (conj rest (conj items (Integer/parseInt item))))))
          [[]]
          elves))


(defn- sum-calories [items]
  (map #(reduce + %) items))

(defn- sorted-elves []
  (with-open [r (io/reader d1-input)]
    (let [c (line-seq r)
          d (into [] c)
          elf-groups (group-elves d)]
      (sort > (sum-calories elf-groups)))))

(def ^:private elves (vec (sorted-elves)))


(defn top []
  (first elves))

(defn topn [n]
  (subvec elves 0 n))
