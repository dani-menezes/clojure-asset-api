(ns clojure-asset-api.controllers.asset-controller
  (:require [clojure-asset-api.services.asset-service :as service]))

(defn get-categories []
  ;; Fetch categories from a config file or database
  {:Financial ["AAPL" "JPM"]
   :BigTech ["GOOG" "MSFT"]
   :Energy ["XOM" "CVX"]})

(defn fetch-price [symbol]
  ;; Fetch and persist price using the service
  (println (str "\n[Controller] fetch-price:" symbol))
  (service/fetch-and-persist-asset symbol))
