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
  [["/users" {:get handlers/ping}]
   ["/login" {:post {:parameters {:body {:username s/Str
                                         :password s/Str}}
                     :handler dummy-handler}}]

   ["/register" {:post {:parameters {:body {:username s/Str
                                         :password s/Str
                                         :email s/Str}}
                     :handler dummy-handler}}]])
