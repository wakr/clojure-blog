(ns personal-blog.model.blog_post
  (:require [personal-blog.db :as db])
  (:require [clojure.tools.logging :as log]))

(defn add-blog-post
  [title bodytext tags]
  (let [result (db/save-blogpost<! {:title title :bodytext bodytext :tags tags})]
  (log/info
    "Stored a new blogpost with values" title bodytext tags "with result" result)))

(defn get-all-blogposts
  []
  (let [result (db/get-all-blogposts)]
  (log/info "Fetched" (count result) "blogposts")
  result))
