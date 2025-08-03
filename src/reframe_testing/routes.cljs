(ns reframe-testing.routes
  (:require
   [reitit.frontend :as rf]
   [reitit.frontend.easy :as rfe]
   [re-frame.core :as rf-core]
   [reframe-testing.views :as views]))

(def routes
  [["/" {:name :home
         :view views/home-page}]
   ["/about" {:name :about
              :view views/about-page}]
   ["/contact-us" {:name :contact
                   :view views/contact-page}]])

(def router
  (rf/router routes))

(defn on-navigate [new-match]
  (when new-match
    (rf-core/dispatch [:set-current-page new-match])))

(defn init-routes! []
  (rfe/start!
   router
   on-navigate
   {:use-fragment false}))