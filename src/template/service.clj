(ns template.service
  (:require [com.stuartsierra.component :as component]
            [ring.adapter.jetty :as r]
            [template.http.api :refer [api]]))

(defrecord WebServer [handler port join server]
  component/Lifecycle

  (start [component]
    (println "Starting jetty")

    (let [server (r/run-jetty (api) {:port port
                                     :join? join})]
      (println "Done")
      (assoc component :server server)))

  (stop [component]
    (println "Stopping jetty")
    (.stop (:server component))
    (println "Done")
    (assoc component :server nil)))

(defn new-server [handler port join]
  (map->WebServer {:handler handler
                   :port port
                   :join join}))


(defn new-service [config]
  (let [{:keys [handler port join]} config]
    (component/system-map
      :api (component/using 
             (new-server handler port join)
             []))))

(defn start
  [config]
  (component/start (new-service config)))
