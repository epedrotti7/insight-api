(ns insight-api.services.censo-service
  (:require [clj-http.client :as client]
            [clojure.string :as str]
            [insight-api.repositories.censo-repository :as repo]))

(defn add-censo-nomes [req-data]
  (let [nome (get req-data "nome")
        sexo (get req-data "sexo")
        url (str "https://servicodados.ibge.gov.br/api/v2/censos/nomes/" nome)
        response (client/get url {:query-params {"sexo" sexo}
                                  :as :json})
        body (:body response)
        res-data (-> body first :res)]

    (let [dados-censo (map (fn [res]
                             {:nome nome
                              :decada (-> (:periodo res)
                                          (str/split #",")
                                          first
                                          (subs 1))
                              :frequencia (:frequencia res)
                              :sexo sexo})
                           res-data)]

      (repo/save-censo-dados dados-censo)
      body)))