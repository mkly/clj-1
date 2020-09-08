(ns clj-1.core
  (:gen-class)
  (:require [clj-http.client :as client]))

(defn -main
  "Get user"
  [& args]
  (try
    (if-let [username (->> (client/get (str "https://api.github.com/user/" (first args)) {:as :auto}) :body :login)]
      (println (str "username is " username))
      (println "username not found"))
    (catch Exception _ (println "username not found"))))
