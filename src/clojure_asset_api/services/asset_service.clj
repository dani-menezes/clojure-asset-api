(ns clojure-asset-api.services.asset-service
  (:require [clojure-asset-api.diplomats.finnhub-gateway :as finnhub]
            [clojure-asset-api.diplomats.postgres-gateway :as db]))

(defn fetch-and-persist-asset [symbol]
  (let [quote (finnhub/fetch-quote symbol)]
    (if (:error quote)
      quote
      (let [asset-data {:symbol symbol
                        :price (:c quote)
                        :change (:d quote)
                        :percentChange (:dp quote)
                        :high (:h quote)
                        :low (:l quote)
                        :open (:o quote)
                        :previous (:pc quote)
                        :timestamp (:t quote)
                        :request-timestamp (System/currentTimeMillis)}]
        (db/save-asset asset-data)
        asset-data))))
