(ns core.core
   (:use compojure.core)
    (:require [compojure.handler :as handler]
              [compojure.route :as route]
               [controller.controller :as controller]))

(defroutes public-routes
           (GET "/" [] (controller/index))
           (route/resources "/"))

(defroutes app-routes
           public-routes
           (route/not-found "404. Page not found"))


(def -main
  (handler/site app-routes))



