(ns insight-api.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [insight-api.handlers.handler :refer [app]])
  (:gen-class))

(defn -main [& args]
  (run-jetty app {:port 3000 :join? false}))