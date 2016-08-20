(ns personal-blog.db
  (require [yesql.core :refer [defquery]]))

  (def db-spec {:classname "org.postgresql.Driver"
                :subprotocol "postgresql"
                :subname ""
                :user "me"})
