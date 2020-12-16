(ns auth.handlers
  (:require [auth.db :as db]))


(defn ping [_]
 {:status 200
 :body {:hello "world"}})

(defn get-all-users [_]
  {:status 200
   :body {:users (db/get-all-users)}})

(defn register
  [{:keys [parameters]}]
  (let [data (:body parameters)
        user (db/create-user data)]
    {:status 201
     :body {:user user}}))


(defn login
  [{:keys [parameters]}]
  (let [data (:body parameters)
        user (db/get-user-by-credentials data)]
    (if (nil? user)
      {:status 404
       :body {:error "Invalid credentials"}}
      {:status 200
       :body {:user user}})))
