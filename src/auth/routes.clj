(ns auth.routes
  (:require [auth.handlers :as handlers]
            [schema.core :as s]))


(defn dummy-handler
  [{:keys [parameters]}]
  {:status 200
   :body parameters})

(def ping-route
  ["/ping" {:name ::ping
                    :get handlers/ping}])


(def auth-routes
  [["/users" {:get handlers/get-all-users}]
   ["/login" {:post {:parameters {:body {:username s/Str
                                         :password s/Str}}
                     :handler handlers/login}}]

   ["/register" {:post {:parameters {:body {:username s/Str
                                         :password s/Str
                                         :email s/Str}}
                     :handler handlers/register}}]])
