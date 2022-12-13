(ns user
  (:require [template.service :as service]
            [clojure.tools.namespace.repl :refer (refresh)]
            [com.stuartsierra.component :as component]))


(def system nil)

(defn init []
  (alter-var-root #'system
                  (constantly (service/new-service {:port 3000
                                                    :join false}))))


(defn start
  []
  (alter-var-root #'system component/start))

(defn stop
  []
  (alter-var-root #'system component/stop))

(defn reset
  []
  (stop)
  (refresh))

(defn go []
  (init)
  (start))
