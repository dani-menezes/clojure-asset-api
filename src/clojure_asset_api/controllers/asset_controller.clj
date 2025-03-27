(ns clojure-asset-api.controllers.asset-controller
  (:require [clojure-asset-api.entities.asset :refer [->Asset]]
            [clojure-asset-api.integrations.finnhub :as finnhub]))

(defn get-categories []
  ;; Fetch categories from a config file or database
  {:Financial ["AAPL" "JPM"]
   :BigTech ["GOOG" "MSFT"]
   :Energy ["XOM" "CVX"]})

(defn fetch-price [symbol]
  ;; Fetch price using Finnhub API
  (let [quote (finnhub/fetch-quote symbol)]
    (if (:error quote)
      quote
      {:name symbol :symbol symbol :price (:c quote)})))
