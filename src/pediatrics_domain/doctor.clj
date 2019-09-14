(ns pediatrics_domain.doctor
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def db-connection {
               :subprotocol "mysql"
               :subname "//localhost:3306/pediatrics"
               :user "root"
               :password "root"
               :zeroDateTimeBehaviour "convertToNull"
               })

(defn getAllDoctors []
  (jdbc/query db-connection
              ["SELECT d.*, dt.name as dt_name FROM doctor d JOIN doctor_type dt ON d.doctor_type_id = dt.doctor_type_id"]))


(defn removeDoctor [id]
  (jdbc/execute! db-connection
                 ["DELETE FROM doctor WHERE doctor_id = ?" id]))
(defn getDoctorByID [id]
  (first (jdbc/query db-connection
                     ["SELECT d.* FROM doctor d WHERE d.doctor_id = ?" id])))
(defn updateDoctor [id params]
  (jdbc/update! db-connection :doctor params (sql/where {:doctor_id id})))

(defn insertDoctor [params]
  (jdbc/insert! db-connection :doctor params))




