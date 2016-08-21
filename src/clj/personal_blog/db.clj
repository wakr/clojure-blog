(ns personal-blog.db
  (:require [yesql.core :refer [defquery defqueries]])
  (:require [environ.core :refer [env]])
  (:require [clojure.string :as str]))

(defn- remote-heroku-db-spec [host port database username password]
  {:connection-uri (str "jdbc:postgresql://" host ":" port "/" database "?user=" username "&password=" password
                        "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory")})

(defonce parsed-db
  (let [db-url (or (env :heroku-database-url)
                   (env :database-url))
        splitted-url (str/split db-url #":")
        host-field (str/split (nth splitted-url 2) #"@")
        port-field (str/split (nth splitted-url 3) #"/")
        database-field (nth port-field 1)
        username-field (nth splitted-url 1)
        passoword-field (nth host-field 0)]
  {:host (nth host-field 1)
   :port (nth port-field 0)
   :database (nth (str/split database-field #"\?") 0)
   :username (str/replace username-field #"/" "")
   :password passoword-field}))

(defonce db-conn
  (apply remote-heroku-db-spec
    (mapv parsed-db [:host :port :database :username :password])))

(defqueries "queries/blogposts_queries.sql"
   {:connection db-conn})
