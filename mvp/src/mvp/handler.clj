(ns mvp.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/groups/:group-id/word/:word-id" [] "hello")
  (route/not-found "Not Found"))

(defn get-words [] (slurp "/resources/words.txt"))
(def app
  (wrap-defaults app-routes site-defaults))
