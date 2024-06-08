(defproject insight-api "0.1.0-SNAPSHOT"
  :description "Projeto de exemplo com Korma"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [korma "0.4.3"]
                 [org.postgresql/postgresql "42.2.18"]
                 [compojure "1.6.2"]
                 [ring/ring-defaults "0.3.3"]
                 [ring/ring-json "0.5.0"]
                 [clj-http "3.12.3"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler insight-api.handlers.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.4.0"]]}})