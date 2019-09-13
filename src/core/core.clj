(ns core.core
   (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [controller.controller :as controller]
            [pediatrics_domain.doctor :as doctor-domain]
            [ring.util.response :as resp]
            [pediatrics_domain.doctor_type :as doctorType-domain]
            [pediatrics_domain.patient :as patient-domain]
            [pediatrics_domain.examination :as examination-domain]
            [pediatrics_domain.refer :as refer-domain]
            [clojure.spec.alpha :as s])
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

           (GET "/pediatrics_domain/doctor_types/:id/removeDoctorType" [id]
                (do (doctorType-domain/removeDoctorType id)
                    (resp/redirect "/getAllDoctorTypes")))

           (GET "/pediatrics_domain/patients/:id/removePatient" [id]
                (do (patient-domain/removePatient id)
                    (resp/redirect "/getAllPatients")))

           (GET "/pediatrics_domain/examinations/:id/removeExamination" [id]
                (do (examination-domain/removeExamination id)
                    (resp/redirect "/getAllExaminations")))

           (GET "/pediatrics_domain/refers/:id/removeRefer" [id]
                (do (refer-domain/removeRefer id)
                    (resp/redirect "/getAllRefers")))

           (GET "/pediatrics_domain/doctors/:id/updateDoctor" [id]
                (controller/updatingDoctor id))

           (POST "/pediatrics_domain/doctors/:doctor_id/updateDoctor" [& params]
                 (do (doctor-domain/updateDoctor (:doctor_id params) params)
                     (resp/redirect "/getAllDoctors")))

           (GET "/pediatrics_domain/doctor_types/:id/updateDoctorType" [id]
                (controller/updatingDoctorType id))

           (POST "/pediatrics_domain/doctor_types/:doctor_type_id/updateDoctorType" [& params]
                 (do (doctorType-domain/updateDoctorType (:doctor_type_id params) params)
                     (resp/redirect "/getAllDoctorTypes")))

           (GET "/pediatrics_domain/examinations/:id/updateExamination" [id]
                (controller/updatingExamination id))

           (POST "/pediatrics_domain/examinations/:examination_id/updateExamination" [& params]
                 (do (examination-domain/updateExamination (:examination_id params) params)
                     (resp/redirect "/getAllExaminations")))



           )

(defroutes app-routes
           public-routes
           (route/not-found "404. Page not found"))


(def -main
  (handler/site app-routes))



