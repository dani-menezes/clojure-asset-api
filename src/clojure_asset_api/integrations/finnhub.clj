(ns clojure-asset-api.integrations.finnhub
  (:require [clj-http.client :as client]
            [cheshire.core :as json]))

(def api-key "cvili61r01qijvgj4g7gcvili61r01qijvgj4g80")

(defn fetch-quote [symbol]
  (print (str "\n" "https://finnhub.io/api/v1/quote?symbol=" symbol "&token=" api-key) )
  (let [url (str "https://finnhub.io/api/v1/quote?symbol=" symbol "&token=" api-key)
        headers {"X-Finnhub-Secret" api-key}
        response (client/get url {:headers headers :as :json})]
    (if (= 200 (:status response))
      (:body response)
      {:error "Unable to fetch price from Finnhub"})))

