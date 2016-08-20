(ns personal-blog.migrations
  (:require [migratus.core :as migratus])
  (:require [environ.core :refer [env]]))

(defonce db-config {:store :database
             :migration-dir "migrations"
             :db (env :heroku-database-url)})

(defn init-db
  []
  (do
    (migratus/init db-config)
    (migratus/migrate db-config)
    ))
