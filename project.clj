(defproject stefana_pediatrics "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.9.0"]
                           [compojure "1.5.1"]
                           [org.clojure/java.jdbc "0.3.0-alpha5"]
                           [mysql/mysql-connector-java "5.1.6"]
                           [de.ubercode.clostache/clostache "1.4.0"]
                           [ring-basic-authentication "1.0.5"]]
            :plugins [[org.clojure/core.unify "0.5.7"]
                      [lein-ring "0.12.4" :exclusions [org.clojure/core.unify]]]
            :ring {:handler core.core/-main}
            :profiles
            {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}})
