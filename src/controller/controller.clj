(ns controller.controller
  (:require
    [clostache.parser :as clostache]))

(defn read-template [template-name]
      (slurp (clojure.java.io/resource
               (str "pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn index []
      (render-template "index" {}))

