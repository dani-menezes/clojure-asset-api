(ns clojure-asset-api.diplomats.postgres-gateway
  (:require [next.jdbc :as jdbc]))

(def db-spec {:dbtype "postgresql"
              :dbname "your-db-name"
              :host "localhost"
              :user "your-username"
              :password "your-password"})

(defn save-asset [asset-data]
  (jdbc/execute! db-spec
                 ["INSERT INTO assets (symbol, price, change, percent_change, high, low, open, previous, timestamp, request_timestamp)
                   VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                  (:symbol asset-data)
                  (:price asset-data)
                  (:change asset-data)
                  (:percentChange asset-data)
                  (:high asset-data)
                  (:low asset-data)
                  (:open asset-data)
                  (:previous asset-data)
                  (:timestamp asset-data)
                  (:request-timestamp asset-data)]))
