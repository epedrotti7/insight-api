(ns insight-api.repositories.censo-repository
  (:require [korma.core :refer :all]
            [insight-api.database.database]))

(defentity censo)

(defn save-censo-dados [dados]
  (println dados)
  (doseq [dado dados]
    (insert censo
            #_{:clj-kondo/ignore [:invalid-arity]}
            (values dado))))