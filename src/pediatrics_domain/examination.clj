(ns pediatrics_domain.examination
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



(defn getAllExaminations []
  (jdbc/query db-connection
              ["SELECT e.*, d.name AS d_name, d.surname AS d_surname, p.name AS p_name, p.surname AS p_surname FROM examination e JOIN patient p ON e.patient_id = p.patient_id JOIN doctor d ON e.doctor_id = d.doctor_id"]))
