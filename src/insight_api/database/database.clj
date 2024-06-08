(ns insight-api.database.database
  (:require [korma.db :as db]))

(def db-spec
  (db/postgres {:db "insightdb"
                :user "insight"
                :password "insight"
                :host "localhost"
                :port 5432}))

(db/defdb mydb db-spec)