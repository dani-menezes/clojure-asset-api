(ns clojure-asset-api.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [cheshire.core :as json]
            [ring.middleware.cors :refer [wrap-cors]]
            [clojure-asset-api.controllers.asset-controller :as controller]))

(defroutes app-routes
  (GET "/assets/categories" []
    (json/generate-string (controller/get-categories)))
 (GET "/price/:symbol" [symbol]
   (do
     (println "Received symbol:" symbol)
     (json/generate-string (controller/fetch-price symbol))))
  (route/not-found "Not Found"))

(def app
  (wrap-cors
    app-routes
    :access-control-allow-origin [#"http://localhost:3001"]
    :access-control-allow-methods [:get :post :put :delete]))