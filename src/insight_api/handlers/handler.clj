(ns insight-api.handlers.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [insight-api.services.censo-service :as censo-service]))

(defroutes app-routes
  (POST "/censo/nomes" req
    (let [req (get-in req [:body])]
      (censo-service/add-censo-nomes req)
      {:status 201
       :headers {"Content-Type" "application/json"}
       :body req}))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults (wrap-json-response (wrap-json-body app-routes)) api-defaults))
