(ns clojure-asset-api.integrations.finnhub
  (:require [clj-http.client :as client]
            [cheshire.core :as json]))

(def api-key "cvili61r01qijvgj4g7gcvili61r01qijvgj4g80")
(def secret-header "cvili61r01qijvgj4g90")

(defn fetch-quote [symbol]
  (let [url (str "https://finnhub.io/api/v1/quote?symbol=" symbol)
        headers {"X-Finnhub-Secret" secret-header}
        response (client/get url {:headers headers :as :json})]
    (if (= 200 (:status response))
      (:body response)
      {:error "Unable to fetch price from Finnhub"})))
