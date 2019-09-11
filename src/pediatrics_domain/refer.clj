(ns pediatrics_domain.refer
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

(defn getAllRefers []
  (jdbc/query db-connection
              ["SELECT r.*, e.examination_id AS examination, dt.name AS dt_name, d.name AS d_name, d.surname AS d_surname, p.name AS p_name, p.surname AS p_surname FROM refer r JOIN examination e ON r.examination_id = e.examination_id JOIN patient p ON e.patient_id = p.patient_id JOIN doctor d ON e.doctor_id = d.doctor_id
               JOIN doctor_type dt ON r.doctor_type_id = dt.doctor_type_id "]))



