(ns clojure-asset-api.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [cheshire.core :as json]
            [clj-http.client :as client]
            [clojure.java.io :as io]))

(defn get-categories []
  ;; Placeholder for fetching categories from a config file
  {:Financial ["AAPL" "JPM"]
   :BigTech ["GOOG" "MSFT"]
   :Energy ["XOM" "CVX"]})

(defn fetch-price [symbol]
  ;; Placeholder for fetching price from a public API
  {:name "Apple Inc." :symbol symbol :price 150.00})

(defroutes app-routes
  (GET "/assets/categories" []
    (json/generate-string (get-categories)))
  (GET "/price" [symbol]
    (json/generate-string (fetch-price symbol)))
  (route/not-found "Not Found"))
