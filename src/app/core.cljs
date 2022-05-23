(ns app.core
  (:require
   [re-frame.core :as rf]
   [reagent.core :as r]
   [reagent.dom :as rdom]
   [app.events :as events]
   [app.subs :as subs]
   ["react-helmet" :refer [Helmet]]
   ["react-router-dom" :refer (Route BrowserRouter Outlet NavLink Routes)]))


(defn hero []
  (let [name (rf/subscribe [::subs/name])]
    [:div {:class "p-20 rounded text-center shadow-md font-normal font-sans bg-blue-400"}
     [:h2 {:class "text-xl text-teal-500"}
      "Hello " @name " !"]
     [:h3
      "Welcome"]]))

(defn index []
  [:div
   [:> Helmet [:title "Home"]]
   [:h2 "Home"]
   [hero]])

(defn users []
  [:div
   [:> Helmet [:title "Users"]]
   [:h2 "Users"]])

(defn about []
  [:div
   [:> Helmet [:title "About"]]
   [:h2 "About"]])

(defn navigation-link [label path]
  [:> NavLink {:to path :end true} label])

(defn navigation-bar [links]
  [:nav
   [:ul {:class "flex flex-row space-x-4"}
    (map
     (fn [{:keys [path label]}]
       ^{:key path} [:li (navigation-link label path)]) links)]])

(def links [{:path "/" :index true :label "Home" :element index}
            {:path "/about" :label "About" :element about}
            {:path "/users" :label "Users" :element users}])

(defn layout []
  [:div {:class "p-6 font-sans"}
   [navigation-bar links]
   [:div {:class "container mx-auto mt-12 px-6"}
    [:> Outlet]]])

(defn pages [links]
  (map
   (fn [link]
     ^{:key (:label link)}
     [:> Route {:path (:path link)
                :index (:index link)
                :element (r/as-element [:> (r/reactify-component (:element link))])}])
   links))

(defn root []
  [:> BrowserRouter
   [:> Routes
    [:> Route {:path "/" :element (r/as-element [:> (r/reactify-component layout)])}
     (pages links)]]])

(defn mount-root
  []
  (rdom/render [root] (js/document.getElementById "main")))

(defn init []
  (rf/dispatch-sync [:initialize-db]))

(defn ^:dev/after-load reload
  []
  (rf/clear-subscription-cache!)
  (mount-root))

(defn main
  []
  (init)
  (mount-root))
