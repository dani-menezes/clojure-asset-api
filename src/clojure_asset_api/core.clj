(ns clojure-asset-api.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [clojure-asset-api.routes :refer [app]]
            [taoensso.timbre :as timbre]))

(defn -main [& args]
  (timbre/info "Starting server on port 3000")
  (run-jetty app {:port 3000 :join? false}))
