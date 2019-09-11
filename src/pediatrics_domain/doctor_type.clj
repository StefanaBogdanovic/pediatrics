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

