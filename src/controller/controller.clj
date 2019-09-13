(ns controller.controller
  (:require
    [clostache.parser :as clostache]
    [pediatrics_domain.doctor :as doctor-domain]
    [pediatrics_domain.doctor_type :as doctorType-domain]
    [pediatrics_domain.patient :as patient-domain]
    [pediatrics_domain.examination :as examination-domain]
    [pediatrics_domain.refer :as refer-domain]
    ))

(defn read-template [template-name]
      (slurp (clojure.java.io/resource
               (str "pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn index []
      (render-template "index" {}))

(defn home []
  (render-template "homepage" {}))

(defn getAllDoctors []
  (render-template "getAllDoctors" {:doctor (doctor-domain/getAllDoctors)}))

(defn getAllDoctorTypes []
  (render-template "getAllDoctorTypes" {:doctor_type (doctorType-domain/getAllDoctorTypes)}))

(defn getAllPatients []
  (render-template "getAllPatients" {:patient (patient-domain/getAllPatients)}))

(defn getAllExaminations []
  (render-template "getAllExaminations" {:examination (examination-domain/getAllExaminations )}))

(defn getAllRefers []
  (render-template "getAllRefers" {:refer (refer-domain/getAllRefers)}))

(defn updatingDoctor [doctor_id]
  (render-template "updateDoctor" {:doctor (doctor-domain/getDoctorByID doctor_id)}))

