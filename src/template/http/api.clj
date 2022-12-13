(ns template.http.api
  (:require [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.util.response :refer [response not-found created bad-request]]
            [ring.middleware.gzip :refer [wrap-gzip]]
            [compojure.core :refer [GET POST PUT DELETE defroutes]]))

(defn api-routes 
  []
   (defroutes routes
     (GET "/internal/health" [] (response {}))))

(defn api 
  []
  (let [routes (api-routes)]
    (wrap-json-body (-> routes
                        wrap-gzip
                        wrap-json-response) {:keywords? true})))
