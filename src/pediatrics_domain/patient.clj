(ns pediatrics_domain.patient
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


(defn getAllPatients []
  (jdbc/query db-connection
              ["SELECT * FROM patient p"]))

(defn removePatient [id]
  (jdbc/execute! db-connection
                 ["DELETE FROM patient WHERE patient_id = ?" id]))


(defn get [id]
  (first (jdbc/query db-connection
                     ["SELECT * FROM patient WHERE patient_id = ?" id])))

(defn updatePatient [id params]
  (jdbc/update! db-connection :patient params (sql/where {:patient_id id})))




