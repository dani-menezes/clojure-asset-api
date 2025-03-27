(ns clojure-asset-api.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [cheshire.core :as json]
            [clojure-asset-api.controllers.asset-controller :as controller]))

(defroutes app-routes
  (GET "/assets/categories" []
    (json/generate-string (controller/get-categories)))
 (GET "/price/:symbol" [symbol]
   (do
     (println "Received symbol:" symbol)
     (json/generate-string (controller/fetch-price symbol))))
  (route/not-found "Not Found"))
