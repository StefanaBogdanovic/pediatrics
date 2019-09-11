(ns core.core
   (:use compojure.core)
    (:require [compojure.handler :as handler]
              [compojure.route :as route]
               [controller.controller :as controller]))

(defroutes public-routes
           (GET "/" [] (controller/index))
           (route/resources "/")

           (GET "/homepage" [] (controller/home))
           (route/resources "/")

           (GET "/getAllDoctors" [] (controller/getAllDoctors))
           (route/resources "/")

           (GET "/getAllDoctorTypes" [] (controller/getAllDoctorTypes))
           (route/resources "/")

           (GET "/getAllPatients" [] (controller/getAllPatients))
           (route/resources "/")

           (GET "/getAllExaminations" [] (controller/getAllExaminations))
           (route/resources "/")

           (GET "/getAllRefers" [] (controller/getAllRefers))
           (route/resources "/")

           )

(defroutes app-routes
           public-routes
           (route/not-found "404. Page not found"))


(def -main
  (handler/site app-routes))



