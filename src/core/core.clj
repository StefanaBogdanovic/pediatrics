(ns core.core
   (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [controller.controller :as controller]
            [pediatrics_domain.doctor :as doctor-domain]
            [ring.util.response :as resp]
         )
  )

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

           (GET "/pediatrics_domain/doctors/:id/removeDoctor" [id]
                (do (doctor-domain/removeDoctor id)
                    (resp/redirect "/getAllDoctors")))

           )

(defroutes app-routes
           public-routes
           (route/not-found "404. Page not found"))


(def -main
  (handler/site app-routes))



