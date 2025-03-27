(ns clojure-asset-api.controllers.asset-controller
  (:require [clojure-asset-api.entities.asset :refer [->Asset]]
            [clj-http.client :as client]
            [cheshire.core :as json]))

(defn get-categories []
  ;; Fetch categories from a config file or database
  {:Financial ["AAPL" "JPM"]
   :BigTech ["GOOG" "MSFT"]
   :Energy ["XOM" "CVX"]})

(defn fetch-price [symbol]
  ;; Fetch price from a public API
  (let [response (client/get (str "https://api.example.com/price?symbol=" symbol)
                             {:as :json})]
    (if (= 200 (:status response))
      (let [data (:body response)]
        {:name (:name data) :symbol symbol :price (:price data)})
      {:error "Unable to fetch price"})))
