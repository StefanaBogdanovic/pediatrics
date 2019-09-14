(ns pediatrics_domain.doctor_type
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


(defn getAllDoctorTypes []
  (jdbc/query db-connection
              ["SELECT * FROM doctor_type dt"]))

(defn removeDoctorType [id]
  (jdbc/execute! db-connection
                 ["DELETE FROM doctor_type WHERE doctor_type_id = ?" id]))

(defn getDoctorTypeByID [id]
  (first (jdbc/query db-connection
                     ["SELECT * FROM doctor_type WHERE doctor_type_id = ?" id])))

(defn updateDoctorType [id params]
  (jdbc/update! db-connection :doctor_type params (sql/where {:doctor_type_id id})))

(defn insertDoctorType
  [params]
  (jdbc/insert! db-connection :doctor_type params))