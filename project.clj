(defproject clojure-asset-api "0.1.0-SNAPSHOT"
  :description "A Clojure backend service for asset-related data"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [ring/ring-core "1.9.0"]
                 [ring/ring-jetty-adapter "1.9.0"]
                 [compojure "1.6.2"]
                 [ring-cors "0.1.13"]
                 [clj-http "3.12.3"]
                 [cheshire "5.10.0"]
                 [com.taoensso/timbre "5.1.2"]]
  :main ^:skip-aot clojure-asset-api.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
