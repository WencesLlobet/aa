(ns app.utils
  (:require [reagent.core :as r]))

;;;; JSON

(defn j->c [o] (js->clj o :keywordize-keys true))
(defn c->j [o] (clj->js o))

(defn json->clj
  [s]
  (-> s js/JSON.parse j->c))

(defn clj->json
  [o]
  (-> o c->j js/JSON.stringify))

(def ->reactify r/reactify-component)
(def ->element r/as-element)