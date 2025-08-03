(ns reframe-testing.events
  (:require [re-frame.core :as rf]))

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   {:current-page nil}))

(rf/reg-event-db
 :set-current-page
 (fn [db [_ match]]
   (assoc db :current-page match)))

(rf/reg-sub
 :current-page
 (fn [db _]
   (:current-page db)))