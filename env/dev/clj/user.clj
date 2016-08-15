(ns user
  (:require [mount.core :as mount]
            personal-blog.core))

(defn start []
  (mount/start-without #'personal-blog.core/repl-server))

(defn stop []
  (mount/stop-except #'personal-blog.core/repl-server))

(defn restart []
  (stop)
  (start))


