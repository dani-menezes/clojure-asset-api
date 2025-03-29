(ns clojure-asset-api.diplomats.postgres-gateway
  (:require [next.jdbc :as jdbc]))

;jdbc:postgresql://localhost:5432/asset_data
(def db-spec {:dbtype "postgresql"
              :dbname "asset_data"
              :host "localhost"
              :user "asset_user"
              :password "asset_pass"})

(defn save-asset [asset-data]
  (jdbc/execute! db-spec
                 ["INSERT INTO assets (symbol, price_current, price_change, price_percent, price_high, price_low, price_open, price_prev_close, quote_timestamp)
                   VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
                  (:symbol asset-data)
                  (:price_current asset-data)
                  (:price_change asset-data)
                  (:price_percent asset-data)
                  (:price_high asset-data)
                  (:price_low asset-data)
                  (:price_open asset-data)
                  (:price_prev_close asset-data)
                  (:quote_timestamp asset-data)
                  ]))
