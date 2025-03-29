(ns clojure-asset-api.services.asset-service
  (:require [clojure-asset-api.diplomats.finnhub-gateway :as finnhub]
            [clojure-asset-api.diplomats.postgres-gateway :as db]))

(defn fetch-and-persist-asset [symbol]
  (let [quote (finnhub/fetch-quote symbol)]
    (if (:error quote)
      quote
      (let [asset-data {:symbol symbol
                        :price_current (:c quote)
                        :price_change (:d quote)
                        :price_percent (:dp quote)
                        :price_high (:h quote)
                        :price_low (:l quote)
                        :price_open (:o quote)
                        :price_prev_close (:pc quote)
                        :quote_timestamp (:t quote)
                        :request-timestamp (System/currentTimeMillis)}]
        (db/save-asset asset-data)
        asset-data))))
