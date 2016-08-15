(ns personal-blog.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [personal-blog.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[personal-blog started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[personal-blog has shut down successfully]=-"))
   :middleware wrap-dev})
